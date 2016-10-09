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
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.javatunes.domain.MusicItem;
import com.javatunes.service.ServiceTX;

@ServiceTX
public class JpaItemRepository implements ItemRepository {
	
	@PersistenceContext
	private EntityManager em;

	public MusicItem get(Long id) {
		return em.find(MusicItem.class,id);
	}

	public void persist(MusicItem item) {
		em.persist(item);
		System.out.println(item + " persisted!");
	}

	public void remove(MusicItem item) {
		em.remove(item);
	}
	
	@Override
	public Collection<MusicItem> getAll() {
		// Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MusicItem> searchByArtistTitle(String keyword) {
		String likeKeyword = "%" + keyword + "%";
		String artistQuery = "SELECT mi FROM MusicItem mi WHERE mi.artist LIKE :queryString OR mi.title LIKE :queryString";
	    TypedQuery<MusicItem> q = em.createQuery(artistQuery, MusicItem.class);
	    q.setParameter("queryString", likeKeyword);
	    return q.getResultList();
	}

	@Override
	public int size() {
		// Auto-generated method stub
		return 0;
	}

}
