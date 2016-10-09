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
import com.javatunes.persistence.Version;

// Declare as a Spring configuration class
// and declare the profile
@Configuration
@Profile("dev")
public class DevConfig extends BaseConfig {
	
	// Inject via a setter method, specifying the desired qualifiers
	@Inject
	@RepositoryType(StorageType.IN_MEMORY)
	@Version(2.0)
	public void setItemRepository(ItemRepository repositoryIn) {
		itemRepository= repositoryIn;
	}
}