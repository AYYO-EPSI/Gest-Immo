package com.gestimmo.serveur.processes;

import com.gestimmo.metier.exceptions.ApplicationMainException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.routing.Filter;

public class HandlerHibernate extends Filter {

	private Session session;
	private Transaction transactionEncours;

	public HandlerHibernate(final Context context) {
		super(context);
	}

	@Override
	protected int beforeHandle(final Request request, final Response response) {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		transactionEncours = session.beginTransaction();

		return CONTINUE;
	}

	@Override
	protected void afterHandle(final Request request, final Response response) {
		try {
			transactionEncours.commit();
		} catch (final ApplicationMainException e) {
			System.out.println(e);
			transactionEncours.rollback();
		}
	}
}