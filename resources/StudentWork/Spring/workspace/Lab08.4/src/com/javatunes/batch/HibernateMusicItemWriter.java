/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

// A simple writer for Person items
public class HibernateMusicItemWriter implements ItemWriter<MusicItem> {
	
	ItemRepository repository;
	
	private static int retryCount = 0;	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void	write(java.util.List<? extends MusicItem> items) {
		System.out.println("HibernateMusicItemWriter.write() - start of chunk writing");
		for (MusicItem cur : items) {
			System.out.format("HibernateMusicItemWriter: id: %d, Title, %s, price, %s\n", cur.getId(), cur.getTitle(), cur.getPrice());

			if (cur.getId() == 10L && retryCount<2) {
				System.out.format("HibernateMusicItemWriter: Throwing exception with id==10 and retryCount = %d \n", retryCount);
				retryCount++;
				throw new RuntimeException("Throwing exception to test rollback"); 
			}
			
			repository.update(cur);
		}
		System.out.println("HibernateMusicItemWriter.write() - end of chunk writing");
		// Uncomment if you want to test this for other succeeding steps.
		// retryCount=0;
	}

	public ItemRepository getRepository() {
		return repository;
	}

	public void setRepository(ItemRepository repository) {
		this.repository = repository;
	}

}
