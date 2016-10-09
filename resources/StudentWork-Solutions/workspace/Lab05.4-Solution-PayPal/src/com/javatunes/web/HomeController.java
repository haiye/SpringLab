/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-12 LearningPatterns Inc.
 */
 
package com.javatunes.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javatunes.service.Catalog;

@Controller
@RequestMapping("/home")      // Map controller to /home
public class HomeController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "home";
	}

	// Handler method to process the search form submission
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public ModelAndView processSearch(@RequestParam(value="keyword", required=true) String keyword) {
		System.out.println("SearchController.processSearch()");
		return new ModelAndView("home", "matches", cat.findByKeyword(keyword));		
	}

/*	
	// Optional: Handler method taking a Model object as an argument 
	@RequestMapping(value="/search", method = RequestMethod.POST)
	public String processSearch(@RequestParam(value="keyword", required=true) String keyword, Model model) {
		System.out.println("SearchController.processSearch()");
		model.addAttribute("matches", cat.findByKeyword(keyword));
		return "home";
	}
*/	
	
}