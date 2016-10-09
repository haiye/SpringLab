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
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javatunes.service.Catalog;

// Configure using Spring's testing integration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/configuration/applicationContext.xml")
public class UT_Catalog {

    @Autowired
    private ApplicationContext ctx;
    
	@Test
	public void catalogTest() {
		assertTrue("spring container should not be null", ctx != null);
		
		Catalog cat = ctx.getBean(Catalog.class);
		assertTrue("Catalog should not be null", cat!=null);
		
		System.out.println(cat);
		System.out.println(cat.size());
		System.out.println(cat.findByKeyword("a"));

	}

}
