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
public class MusicItemReader implements ItemReader<MusicItem> {
	
	private int index = 0;
	
	@Inject
	Catalog cat;

	@Override
	public MusicItem read() throws Exception, UnexpectedInputException,
			ParseException, NonTransientResourceException {
		
		// Go through the MusicItems
		if (index < cat.size()) {
			// TODO: Get the item from the catalog, print it to the console, then return it
			MusicItem cur = cat.get(index);
			System.out.printf("MusicItemReader.read() -  Title: %s, Price: %s\n", cur.getTitle(), cur.getPrice());
			index++;
			return cur;
		} else {
			index=0;
			return null;
		}
	}
}
