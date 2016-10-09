/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javatunes.persistence.InMemoryItemRepository;
import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.JpaItemRepository;

// Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {
	
	// Declare the item repository bean
	@Bean @Profile("inMemory")
	public ItemRepository itemRepository() {
		return new InMemoryItemRepository();
	}
	
	@Bean @Profile("jpa")
	public ItemRepository jpaItemRepository() {
		return new JpaItemRepository();
	}
	
}