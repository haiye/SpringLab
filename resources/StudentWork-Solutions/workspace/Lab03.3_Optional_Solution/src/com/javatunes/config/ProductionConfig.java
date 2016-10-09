/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.javatunes.persistence.ItemRepository;
import com.javatunes.persistence.RepositoryType;
import com.javatunes.persistence.StorageType;

// Declare as a Spring configuration class
// and declare the profile
@Configuration
@Profile("production")
public class ProductionConfig extends BaseConfig {

	// Inject via a setter method, specifying the desired qualifiers	
	@Inject
	@RepositoryType(StorageType.CLOUD)
	public void setItemRepository(ItemRepository repositoryIn) {
		itemRepository= repositoryIn;
	}
	
}