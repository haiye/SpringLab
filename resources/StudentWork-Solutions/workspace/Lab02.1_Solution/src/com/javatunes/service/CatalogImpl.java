/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.service;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import com.javatunes.domain.MusicItem;
import com.javatunes.persistence.ItemRepository;

// Declare as a bean with id musicCatalog
@Named("musicCatalog")
public class CatalogImpl implements Catalog {

	// Inject the repository
	@Inject
	private ItemRepository itemRepository;


	public void setItemRepository(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	public MusicItem findById(Long id) {
		return itemRepository.get(id);
	}

	public Collection<MusicItem> findByKeyword(String keyword) {
		return itemRepository.searchByArtistTitle(keyword);
	}

	@Override
	public int size() {
		return itemRepository.size();
	}
	
	@Override
	public String toString() {
		return "I am a shiny new " + getClass().getName() + " brought to you from Spring" + " but you can just call me " + getClass().getInterfaces()[0] + ".  My itemRepository is " + itemRepository;
	}

}
