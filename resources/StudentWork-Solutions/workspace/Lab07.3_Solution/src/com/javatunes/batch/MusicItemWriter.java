/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemWriter;

import com.javatunes.domain.MusicItem;

// A simple writer for Person items
public class MusicItemWriter implements ItemWriter<MusicItem> {
	
	public void	write(java.util.List<? extends MusicItem> items) {
		System.out.println("MusicItemWriter.write()");
		for (MusicItem cur : items) {
			System.out.println(cur.getTitle() + " : " + cur.getPrice());
		}
	}

}
