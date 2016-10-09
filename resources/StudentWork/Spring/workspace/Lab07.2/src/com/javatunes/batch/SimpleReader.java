/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

// A simple reader for Person items
public class SimpleReader implements ItemReader<Person> {
	
	private int index = 0;

	@Override
	public Person read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		System.out.println("SimpleReader.read()");
		
		// Uncomment the following to see how an exception blows things up.
		// if (index==2) throw new Exception("Testing exceptions");
		
		// Go through the list of persons
		if (index < Person.getPersons().size()) {
			return Person.getPersons().get(index++);
		} else {
		    index=0;
			return null;
		}
	}
}
