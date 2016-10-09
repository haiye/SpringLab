/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.service.Catalog;

public class UT_Catalog {
	@Test
	public void catalogTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertTrue("spring container should not be null", ctx != null);
		
		Catalog catalog = ctx.getBean(Catalog.class);
		
		Catalog catalog2 = ctx.getBean(Catalog.class);
		
		assertTrue("Catalogs should not be equal", catalog!=catalog2);
		
		ctx.close();
	}

}
