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
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.javatunes.batch.Person;
import com.javatunes.batch.SimpleProcessor;
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
    
 
    // Configure a Person reader to read from a flat file
	@Bean ItemReader<Person> flatFileReader() {
		// Create the line tokenizer that splits the line and creates a field set
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();  // Creates tokenizer for comma delimited lines
		String[] names = {"firstName", "lastName", "salary"};
		tokenizer.setNames( names);
		
		// Create a FieldSet mapper that creates person objects
		BeanWrapperFieldSetMapper<Person> beanMapper = new BeanWrapperFieldSetMapper<Person>();
		beanMapper.setTargetType(Person.class);

		// Create a line mapper that uses the Line tokenizer and FieldSet mapper
		DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<Person>();
		lineMapper.setFieldSetMapper(beanMapper);
		lineMapper.setLineTokenizer(tokenizer);
		
		// Create the reader that uses the LineMapper
		FlatFileItemReader<Person> reader = new FlatFileItemReader<Person>();
		reader.setResource(new ClassPathResource("people.csv"));
 		reader.setLineMapper(lineMapper);

		return reader;
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
				. <Person,Person>chunk(2).reader(flatFileReader())
				.processor(processor()).writer(writer()).build();
	}

}