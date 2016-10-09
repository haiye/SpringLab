/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */
 
package com.javatunes.persistence;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Named;

import com.javatunes.domain.MusicCategory;
import com.javatunes.domain.MusicItem;

// Add @Named annotation
@Named
@RepositoryType(StorageType.CLOUD)   // Add RepositoryType qualifier specifying CLOUD
public class CloudItemRepository implements ItemRepository {
	
	private static MusicItem theItem = new MusicItem(1L,"Title", "artist", "2013-08-01", new BigDecimal("15.99"), MusicCategory.Pop);
	private static ArrayList<MusicItem> theData = new ArrayList<MusicItem>(1);

	{ theData.add(theItem); }


	@Override
	public MusicItem get(Long id) {
		// TODO Auto-generated method stub
		return theItem;
	}

	@Override
	public Collection<MusicItem> getAll() {
			return theData;
	}

	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		return theData;
	}

	@Override
	public int size() {
		return theData.size();
	}

	@Override
	public String toString() {
		return "CloudItemRepository";
	}
}
