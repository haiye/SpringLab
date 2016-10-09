package com.javatunes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class JavaTunesWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	  @Override
	  protected String[] getServletMappings() {
	    // return new String[] { "/content/*" };  // Standard: Map dispatcher to URLs with /content
		return new String[] { "/" };  // OPTIONAL: Map dispatcher servlet to root of web app
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
