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
	

    // New version for this lab - works OK with retries
	@Override
	public MusicItem process(MusicItem mi) throws Exception {
		System.out.format("MusicItemPriceProcessor.process() - current id, title. price is: %d, %s. %s \n", mi.getId(), mi.getTitle(), mi.getPrice());

		// Processing
		MusicItem ret = new MusicItem(mi);
		ret.setPrice(ret.getPrice().add(ONE));
		return ret;
	}

/*
	// Old version - what's the problem here.  Try it and see
	public MusicItem process(MusicItem mi) throws Exception {
		System.out.format("MusicItemPriceProcessor.process() - current id, title. price is: %d, %s. %s \n", mi.getId(), mi.getTitle(), mi.getPrice());
		
		// Processing
		mi.setPrice(mi.getPrice().add(ONE));
		return mi;
	}
*/

}
