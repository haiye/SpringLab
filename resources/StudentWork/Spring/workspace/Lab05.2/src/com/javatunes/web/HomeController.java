/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Annotate as a controller
// TODO: Annotate to handle /content/home URL
public class HomeController {

	// TODO: Annotate to respond to HTTP GET requests
	@ResponseBody // Just needed for this lab - will do in a better way soon.
	public String get() {
		return "<h1>Hello Spring MVC</h1>";
	}
}