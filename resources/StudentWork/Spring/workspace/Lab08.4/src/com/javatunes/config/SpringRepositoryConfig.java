/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javatunes.persistence.HibernateItemRepository;
import com.javatunes.persistence.ItemRepository;

// Declare as a configuration class
@Configuration
public class SpringRepositoryConfig {
	

	@Inject
	SessionFactory sf;
	
	// Define itemRepository bean
	@Bean
	public ItemRepository itemRepository() {
		HibernateItemRepository rep = new HibernateItemRepository();
		rep.setSessionFactory(sf);
		return rep;
	}
}