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

import com.javatunes.batch.Person;
import com.javatunes.batch.SimpleProcessor;
import com.javatunes.batch.SimpleReader;
import com.javatunes.batch.SimpleWriter;

@Configuration
// Enable Spring batch processing
@EnableBatchProcessing
public class BatchConfig {

	// @EnableBatchProcessing sets up the following two builders
    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;
    
 
    // Configure a Person reader
	@Bean
	public ItemReader<Person> reader() {
		// Use our version so we can see debugging output
		return new SimpleReader();
		// Alternate version
		// return new ListItemReader<Person>(Person.getPersons());
	}

	// Configure a Person processor
	@Bean
	public ItemProcessor<Person,Person> processor() {
		return new SimpleProcessor();
	}

	// Configure a Person writer
	@Bean
	public ItemWriter<Person> writer() {
		return new SimpleWriter();
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
				. <Person,Person>chunk(2).reader(reader())
				.processor(processor()).writer(writer()).build();
	}

}