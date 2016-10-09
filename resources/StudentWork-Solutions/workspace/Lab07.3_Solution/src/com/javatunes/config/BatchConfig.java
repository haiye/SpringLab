/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.batch.MusicItemNameProcessor;
import com.javatunes.batch.MusicItemReader;
import com.javatunes.batch.MusicItemWriter;
import com.javatunes.domain.MusicItem;

@Configuration
// Enable Spring batch processing
@EnableBatchProcessing
public class BatchConfig {

	// @EnableBatchProcessing sets up the following two builders
    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;
    
 
    // Configure a MusicItem reader
	@Bean
	public ItemReader<MusicItem> reader() {
		// Use our version so we can see debugging output
		return new MusicItemReader();
	}

	// Configure a MusicItem processor
	@Bean
	public ItemProcessor<MusicItem,MusicItem> nameProcessor() {
		return new MusicItemNameProcessor();
	}
	
	// Configure a MusicItem writer
	@Bean
	public ItemWriter<MusicItem> writer() {
		return new MusicItemWriter();
	}

	// Configure our job
	@Bean
	public Job job1() {
		return jobs.get("myJob").start(step1()).build();		
	}

	// Configure our step
	@Bean
	public Step step1() {
		return steps.get("step1")
				.<MusicItem,MusicItem> chunk(2).reader(reader())
				.processor(nameProcessor()).writer(writer()).build();
	}
}