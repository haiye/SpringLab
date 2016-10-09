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
    return new String[] { "TODO" };
  }
	  
  @Override
  protected Class<?>[] getRootConfigClasses() {
    // TODO: Return the root Spring config class
    return new Class<?>[] { null };
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // TODO: Return the Web config class
    return new Class<?>[] { null };
  }
}
