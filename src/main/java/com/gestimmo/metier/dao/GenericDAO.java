package com.gestimmo.metier.dao;

import com.gestimmo.metier.exceptions.ApplicationMainException;
import com.gestimmo.serveur.processes.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public abstract class GenericDAO {
	private final Session session;

	public GenericDAO() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public Session getSession() {
		return session;
	}

	public void saveOrUpdate(final Object objetConcernee) throws ApplicationMainException {
		try {
			session.saveOrUpdate(objetConcernee);
		} catch (final HibernateException e) {
			throwException(e);
		}
	}

	public void delete(final Object objetConcernee) throws ApplicationMainException {
		try {
			session.delete(objetConcernee);
		} catch (final HibernateException e) {
			throwException(e);
		}
	}

	public Object find(final Class<?> clazz, final Integer objetId) throws ApplicationMainException {
		Object obj = null;

		try {
			obj = session.load(clazz, objetId);
		} catch (final HibernateException e) {
			throwException(e);
		}

		return obj;
	}

	public List findAll(final String tableName) throws ApplicationMainException {
		List objects = null;

		try {
			final Query query = session.createQuery("from " + tableName);
			objects = query.list();
		} catch (final HibernateException e) {
			throwException(e);
		}

		return objects;
	}

	public void throwException(final HibernateException e) throws ApplicationMainException {
		throw new ApplicationMainException(e);
	}
}