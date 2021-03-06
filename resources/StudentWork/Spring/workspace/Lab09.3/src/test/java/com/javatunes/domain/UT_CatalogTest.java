/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.domain;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javatunes.config.SpringConfig;
import com.javatunes.service.Catalog;

import static org.junit.Assert.assertTrue;

public class UT_CatalogTest {

	@Test
	public void testCatalog() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);

		Catalog cat = ctx.getBean(Catalog.class);
		
		System.out.println("\n*** Retrieving item from the database ***");
		System.out.println(cat.findById(1L));
		System.out.println("***\n");

		ctx.close();
	}

}
