/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-12 LearningPatterns Inc.
 */
 
package com.javatunes.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/", "/home"})  // OPTIONAL: Map these controllers to root context (/) and to /home 
// @RequestMapping("/home")      // Map controller to /home
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "home";
	}
}