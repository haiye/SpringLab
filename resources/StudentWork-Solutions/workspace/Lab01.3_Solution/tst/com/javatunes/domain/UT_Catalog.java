/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.domain;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javatunes.service.Catalog;

public class UT_Catalog {

	@Test
	public void catalogTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertTrue("spring container should not be null", ctx != null);
		
		// Look up catalog, make sure it is non-null and output it
		Catalog cat = ctx.getBean(Catalog.class);
		assertTrue("Catalog should be non-null", cat != null);
		System.out.println(cat);
		
		// Check that the catalog has some elements now
		assertTrue("Catalog size should not be zero", cat.size()!=0);
		
		// Look up some items, and output them.
		Collection<MusicItem> results = cat.findByKeyword("a");
		System.out.println("*** Results for lookup on 'a' ***");
		for (MusicItem cur : results) {
			System.out.println(cur);
		}
		
		
		ctx.close();
	}

}
