/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import java.math.BigDecimal;

import org.springframework.batch.item.ItemProcessor;

import com.javatunes.domain.MusicItem;

// A simple Person processor that returns a Person
public class MusicItemPriceProcessor implements ItemProcessor<MusicItem, MusicItem> {
	
	private static BigDecimal ONE = new BigDecimal("1.00");

	@Override
	public MusicItem process(MusicItem mi) throws Exception {
		System.out.println("MusicItemPriceProcessor.process()");
		
		// TODO Processing
		mi.setPrice(mi.getPrice().add(ONE));
		
		return mi;
	}

}
