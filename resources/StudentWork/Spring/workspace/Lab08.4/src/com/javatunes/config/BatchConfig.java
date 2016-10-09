/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.HibernateCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.javatunes.batch.HibernateMusicItemWriter;
import com.javatunes.batch.MusicItemNameProcessor;
import com.javatunes.batch.MusicItemPriceProcessor;
import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

@Configuration
// Enable Spring batch processing
@EnableBatchProcessing
@EnableTransactionManagement
public class BatchConfig {

	// @EnableBatchProcessing sets up the following two builders
    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;
    
    @Inject
    SessionFactory sf;
    
	// Inject the repository
	@Inject
	ItemRepository repository;    
    
 
    // Configure a MusicItem reader
	@Bean
	public ItemReader<MusicItem> reader() {

		HibernateCursorItemReader<MusicItem> reader = new HibernateCursorItemReader<MusicItem>();
		reader.setQueryString("from MusicItem");
		reader.setSessionFactory(sf);
		reader.setUseStatelessSession(true);
		return reader;
	}

	// Configure a MusicItem processor
	@Bean
	public ItemProcessor<MusicItem,MusicItem> nameProcessor() {
		return new MusicItemNameProcessor();
	}
	
	@Bean
	public ItemProcessor<MusicItem,MusicItem> priceProcessor() {
		return new MusicItemPriceProcessor();
	}
		
	// Configure a MusicItem writer writing to the DB
	@Bean
	public ItemWriter<MusicItem> writer() {
		HibernateMusicItemWriter theWriter = new HibernateMusicItemWriter();
		theWriter.setRepository(repository);

		return theWriter;
	}

	// Configure our job
	@Bean
	public Job job1() {
		return jobs.get("myJob1").start(step1()).next(step2()).build();		
	}

/*	
	@Bean
	public Job job1() {
		return jobs.get("myJob8").start(step2()).build();		
	}
*/
	
	// Configure our step 
	@Bean
	public Step step1() {
		return steps.get("step1")
				.<MusicItem,MusicItem> chunk(2).reader(reader())
				.processor(priceProcessor()).writer(writer())
				.faultTolerant().retry(RuntimeException.class).retryLimit(3)
				.build();
	}	
	
	// Configure our step two
	@Bean
	public Step step2() {
		return steps.get("step2")
				.<MusicItem,MusicItem> chunk(2).reader(reader())
				.processor(nameProcessor()).writer(writer())
				.faultTolerant().retry(RuntimeException.class).retryLimit(3)
				.build();
	}

}