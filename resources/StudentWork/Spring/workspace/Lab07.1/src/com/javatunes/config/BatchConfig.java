package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.batch.SimpleTasklet;

@Configuration
// TODO: Enable Batch Processing
public class BatchConfig {

   // TODO: Declare and inject factory for building jobs

   // TODO: Declare and inject factory for building steps  
	
	@Bean
	public Step step1() {
	  // TODO: Create and return a step called "step1" that will run SimpleTasklet
	return null;
	}

	@Bean
	public Job job1() {
	  // TODO: Create and return a job called "myJob" that will contain step1
	  return null;
	}


}