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

import com.javatunes.domain.MusicItem;
import com.javatunes.service.Catalog;

// TODO: Annotate so the search model bean is on the session
// TODO: Annotate as a controller class 
// TODO: Map controller to /cart
public class CartController {
	
	// Inject a catalog
	@Inject
	Catalog cat;

	// TODO: Annotate this to add a model bean named search model	
	public Search createSearch() {
		return new Search();
	}
	
	// TODO: Annotate to respond to HTTP GET requests (generates basic cart page)
	public String get(Search s) {  // TODO: Annotate so that s is bound to a model bean named search
		return "TODO";
	}
	
	// Controller for adding an item into the Cart
	// TODO: Annotate to respond to GET requests for /content/cart/add
	public String add(Long id, HttpSession session) {  // TODO: Initialize id from a RequestParameter named "id" and make it required
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
		return "TODO";
	}

	// TODO: Annotate to respond to GET requests for /content/cart/checkout
	public String checkout(HttpSession session) {
		System.out.println("CartController.checkout()");
		session.removeAttribute("cart");
		return "TODO";
	}
	
}