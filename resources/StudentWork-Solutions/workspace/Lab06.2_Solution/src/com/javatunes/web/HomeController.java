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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javatunes.service.Catalog;

@Controller
@SessionAttributes("search")
@RequestMapping("/home")      // Map controller to /home
public class HomeController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	// 
	@ModelAttribute("search")
	public Search createSearch() {
		return new Search();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "home";
	}

	// Handler method to process the search form submission
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("search") Search search) {
		System.out.println("SearchController.processSearch()");
		String keyword = search.getKeyword();
		System.out.println("keyword = " + keyword);
		search.setMatches(cat.findByKeyword(keyword));
		return "home";
	}
}