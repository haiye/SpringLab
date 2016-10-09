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
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

@Controller
@SessionAttributes("search")
@RequestMapping("/cart")      // Map controller to /cart
public class CartController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	@ModelAttribute("search")
	public Search createSearch() {
		return new Search();
	}
	
	// Controller for generating the basic cart page
	@RequestMapping(method = RequestMethod.GET)
	public String get(@ModelAttribute("search") Search s) {
		return "cart";
	}
	
	// Controller for adding an item into the Cart
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String add(@RequestParam(value="id", required=true) Long id, HttpSession session) {
		System.out.println("CartController.add()");
		// Shopping cart management - create new or get reference to existing
		@SuppressWarnings("unchecked")
		Collection<MusicItem> cart = (Collection<MusicItem>) session.getAttribute("cart");
		if (cart == null)  // first visit: session does not have a "cart"
		{
			cart = new ArrayList<MusicItem>();  // create new cart
			session.setAttribute("cart", cart);  // add it to session
		}
		MusicItem item = cat.findById(id);
		if (!cart.contains(item))  // based on equals() method of MusicItem
		{
			System.out.println("Adding item: " + item);
			cart.add(item);
		}
		return "cart";
	}

	@RequestMapping(value="/checkout", method = RequestMethod.GET)
	public String checkout(HttpSession session) {
		System.out.println("CartController.checkout()");
		session.removeAttribute("cart");
		return "cart";
	}
	
}