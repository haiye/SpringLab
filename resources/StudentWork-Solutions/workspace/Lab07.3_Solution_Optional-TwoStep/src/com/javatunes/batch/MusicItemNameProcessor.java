/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemProcessor;

import com.javatunes.domain.MusicItem;

// A simple Person processor that returns a Person
public class MusicItemNameProcessor implements ItemProcessor<MusicItem, MusicItem> {

	@Override
	public MusicItem process(MusicItem mi) throws Exception {
		System.out.println("MusicItemNameProcessor.process()");
		mi.setTitle(mi.getTitle().toUpperCase());
		return mi;
	}

}
