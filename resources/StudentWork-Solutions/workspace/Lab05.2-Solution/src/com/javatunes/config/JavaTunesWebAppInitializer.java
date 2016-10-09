/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaTunesWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	  @Override
	  protected String[] getServletMappings() {
	    return new String[] { "/content/*" };
	  }
	  
	  @Override
	  protected Class<?>[] getRootConfigClasses() {
	    return new Class<?>[] { SpringConfig.class };
	  }

	  @Override
	    protected Class<?>[] getServletConfigClasses() {
	  return new Class<?>[] { WebConfig.class };
	  }
}
