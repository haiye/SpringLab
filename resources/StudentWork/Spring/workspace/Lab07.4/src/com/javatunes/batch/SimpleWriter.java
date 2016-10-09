/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemWriter;

// A simple writer for Person items
public class SimpleWriter implements ItemWriter<Person> {
	
	public void	write(java.util.List<? extends Person> items) {
		System.out.println("SimpleWriter.write()");
		for (Person cur : items) {
			System.out.println(cur);
		}
	}

}
