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
	public Collection<MusicCategory> populateCategories() {
		ArrayList<MusicCategory> categories = new ArrayList<MusicCategory>();
		for (MusicCategory cat : MusicCategory.values()) {
			categories.add(cat);
		}
		return categories;
	}

    // TODO Annotate method parameter
	@RequestMapping(method = RequestMethod.GET)
	public String get( Search search) {
	
	    // TODO: Initialize keyword to "Diva"
	    
		return "home";
	}

	// Handler method to process the search form submission
	// TODO Annotate method parameter
	@RequestMapping(method = RequestMethod.POST)
	public String processSearch( Search search) {
		System.out.println("SearchController.processSearch()");
		
		// TODO: Get keyword from Search bean
		// TODO: Do search using catalog object
		// TODO: Add results into the model's matches property

		return "home";
	}
}