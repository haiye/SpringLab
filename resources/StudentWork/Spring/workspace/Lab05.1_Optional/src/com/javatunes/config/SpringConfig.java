/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

// Declare as a Spring configuration class
// and import other configuration classes and XML config files
@Configuration
@EnableAspectJAutoProxy
@Import({SpringRepositoryConfig.class, SpringServicesConfig.class})
@ImportResource("/WEB-INF/configuration/applicationContext.xml")
public class SpringConfig {}