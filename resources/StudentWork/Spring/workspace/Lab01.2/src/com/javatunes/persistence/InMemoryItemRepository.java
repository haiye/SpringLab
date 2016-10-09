/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.persistence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.javatunes.domain.MusicItem;

public class InMemoryItemRepository implements ItemRepository {

	// this is simply to eliminate the need to stand a database up!
	private List<MusicItem> catalogData = new CatalogData();

	private Integer maxSearchResults = 5;

	
	public MusicItem get(Long id) {
		return catalogData.get(catalogData.indexOf(new MusicItem(id)));
	}

	public Collection<MusicItem> searchByArtistTitle(String keyword) {

		Collection<MusicItem> result = new ArrayList<MusicItem>();
		
		for (MusicItem item : catalogData) {
			if (matches(keyword.toLowerCase(), item) && result.size() < maxSearchResults) {
				result.add(item);
			}
		}
		return result;
	}

	private boolean matches(String keyword, MusicItem item) {
		return item.getTitle().toLowerCase().indexOf(keyword) != -1 || item.getArtist().toLowerCase().indexOf(keyword) != -1;
	}

	public Collection<MusicItem> getAll() {
		return Collections.unmodifiableCollection(catalogData);
	}

	@Override
	public int size() {
		return catalogData.size();
	}
	
	@Override
	public String toString() {
		return String.format("InMemoryItemRepository: Size=%d", size());
	}

}
