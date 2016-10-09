/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemProcessor;

// A simple Person processor that returns a Person
public class SimpleProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person p) throws Exception {
		System.out.println("SimpleProcessor.process()");
		p.setFirstName(p.getFirstName().toUpperCase());
		p.setLastName(p.getLastName().toUpperCase());
		return p;
	}

}
