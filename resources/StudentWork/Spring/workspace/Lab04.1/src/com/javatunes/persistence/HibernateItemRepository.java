/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.javatunes.domain.MusicItem;

public class HibernateItemRepository implements ItemRepository {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
	  sessionFactory = sf;
	}
	public SessionFactory getSessionFactory() {
	  return sessionFactory;
	}

	public MusicItem get(Long id) {
		// Call EntityManager.find() and return the result
		Session s = getSessionFactory().getCurrentSession();
		s.beginTransaction();
		MusicItem ret = (MusicItem)s.get(MusicItem.class, id);
		s.getTransaction().commit();
		return ret;
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
