/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
	
import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

public class UT_Catalog {

	@Test
	public void catalogTest() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		// Set the profile to use
		ctx.getEnvironment().setActiveProfiles("dev");
		
		ctx.register(SpringConfig.class);
		ctx.refresh();
		
		assertTrue("spring container should not be null", ctx != null);
		
		Catalog cat = ctx.getBean(Catalog.class);
		System.out.println(cat);

		ctx.close();
	}

}
