/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import javax.inject.Inject;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// A simple reader for MusicItem items
// TODO: Implement the correct type to be an item reader for MusicItem instances
public class MusicItemReader {
	
	private int index = 0;
	
	@Inject
	Catalog cat;

	// TODO: Uncomment the read() method once you've implemented the correct interface
/*	
	public MusicItem read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		System.out.println("MusicItemReader.read()");
		// Go through the MusicItems
		if (index < cat.size()) {

			// TODO: Get the item from the catalog
			MusicItem cur = null;

			System.out.printf("MusicItemReader.read() -  Title: %s, Price: %s\n", cur.getTitle(), cur.getPrice());

			// TODO: Increment the index

			return cur;
		} else {
			index=0;
			return null;
		}
	}
*/
}
