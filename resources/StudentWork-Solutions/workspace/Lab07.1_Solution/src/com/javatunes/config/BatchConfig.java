package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.batch.SimpleTasklet;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Inject
    private JobBuilderFactory jobs;

    @Inject
    private StepBuilderFactory steps;
    
	@Bean
	public Job job1() {
		return jobs.get("myJob").start(step1()).build();		
	}

	@Bean
	public Step step1() {
		return steps.get("step1").tasklet(new SimpleTasklet()).build();
	}

}