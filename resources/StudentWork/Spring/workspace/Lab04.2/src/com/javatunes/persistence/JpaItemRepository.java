/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;

import com.javatunes.domain.MusicItem;

public class JpaItemRepository implements ItemRepository {
	
	// TODO: Inject the EM
	private EntityManager em;

	public MusicItem get(Long id) {
	    // TODO: Call EntityManager.find() and return the result
		return null;
	}

	@Override
	public Collection<MusicItem> getAll() {
		// Not implemented
		return null;
	}

	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		// Not implemented
		return null;
	}

	@Override
	public int size() {
		// Not implemented
		return 0;
	}

}
