package com.gestimmo.metier.dao;

import com.gestimmo.metier.exceptions.ApplicationMainException;
import com.gestimmo.serveur.processes.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;


public class GenericDao<T> {

	private final Session session;
	private Class<T> classConcernee;

	public GenericDao(Class<T> clazz) {
		classConcernee = clazz;
		session = HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public void saveOrUpdate(T objetConcernee) throws ApplicationMainException {
		try {
			session.saveOrUpdate(objetConcernee);
		} catch (final HibernateException e) {
			throwException(e);
		}
	}

	public void delete(T objetConcernee) throws ApplicationMainException {
		try {
			session.delete(objetConcernee);
		} catch (final HibernateException e) {
			throwException(e);
		}
	}

	public Object find(Integer objetId) throws ApplicationMainException {
		Object obj = null;

		try {
			obj = session.get(classConcernee, objetId);
		} catch (final HibernateException e) {
			throwException(e);
		}

		return obj;
	}

	public void throwException(HibernateException e) throws ApplicationMainException {
		throw new ApplicationMainException(e);
	}
}
