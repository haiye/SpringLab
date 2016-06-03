/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package org.SpringLab;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UT_Spring {

	@Test
	public void springTest() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
		assertTrue("spring container should not be null", ctx != null);
		System.out.println("Spring was bootstrapped for environment " + ctx.getEnvironment());
		ctx.close();
	}

}
