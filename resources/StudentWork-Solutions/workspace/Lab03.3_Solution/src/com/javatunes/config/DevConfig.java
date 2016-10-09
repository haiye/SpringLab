/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.RepositoryType;
import com.javatunes.persistence.StorageType;
import com.javatunes.persistence.Version;
import com.javatunes.service.Catalog;
import com.javatunes.service.CatalogImpl;

// Declare as a Spring configuration class
// and declare the profile
@Configuration
@Profile("dev")
public class DevConfig {
	
	@Inject
	@RepositoryType(StorageType.IN_MEMORY)
	@Version(2.0)
	private ItemRepository itemRepository;
	
	@Bean
	public Catalog catalog() {
		CatalogImpl cat = new CatalogImpl(itemRepository);
		return cat;
	}
}