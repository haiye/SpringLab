/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright 2006-12 LearningPatterns Inc.
 */
 
package com.javatunes.web;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javatunes.domain.MusicCategory;
import com.javatunes.service.Catalog;

@Controller
@RequestMapping("/home")      // Map controller to /home
public class HomeController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	// Optional - Method to add reference data into model
	@ModelAttribute("categories")
	public Collection<MusicCategory> populateCategories() {
		ArrayList<MusicCategory> categories = new ArrayList<MusicCategory>();
		for (MusicCategory cat : MusicCategory.values()) {
			categories.add(cat);
		}
		return categories;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search search) {
		search.setKeyword("Diva");
		return "home";
	}

	// Handler method to process the search form submission
	// Uses optional searchCategory functionality
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch(@ModelAttribute("search") Search search) {
		System.out.println("SearchController.processSearch()");
		String keyword = search.getKeyword();
		System.out.println("keyword = " + keyword);
		if (keyword==null || keyword.length()==0) {  // No keyword?  Then use category
			System.out.println("search.getCategory() = " + search.getCategory());
			search.setMatches(cat.findByCategory(search.getCategory()));
		} else {
			search.setMatches(cat.findByKeyword(keyword));
		}
		return "home";
	}
}