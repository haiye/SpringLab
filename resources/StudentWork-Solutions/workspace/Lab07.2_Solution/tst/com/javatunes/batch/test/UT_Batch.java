/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
	
public class UT_Batch {
	
    @Test
    public void testLaunchJob() throws Exception {

        // test a complete job
    	
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
     
    	JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
    	Job job = ctx.getBean(Job.class);
     
    	try {
     
    		JobExecution execution = jobLauncher.run(job, new JobParameters());
    		System.out.println("Exit Status : " + execution.getStatus());
    		assertTrue("Exit status should be COMPLETED", execution.getStatus() == BatchStatus.COMPLETED);
     
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
     
    	ctx.close();
    }

    
}
