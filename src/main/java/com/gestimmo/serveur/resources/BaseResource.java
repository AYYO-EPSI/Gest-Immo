package com.gestimmo.serveur.resources;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.model.Utilisateur;
import org.hibernate.Hibernate;
import org.restlet.data.Reference;
import org.restlet.resource.ServerResource;

import java.util.List;

public class BaseResource extends ServerResource {

	protected Utilisateur utilisateurActuel;

	@Override
	public void doInit() {
		String id = getRequest().getCookies().getFirstValue("ACCESS_USER");
		if (id != null) {
			utilisateurActuel = (Utilisateur) DaoFactory.getUtilisateurDAO().find(Integer.parseInt(id));
		}
	}

	protected Reference getChildReference(Reference parentRef, int childId) {
		if (parentRef.getIdentifier().endsWith("/")) {
			return new Reference(parentRef.getIdentifier() + String.valueOf(childId));
		} else {
			return new Reference(parentRef.getIdentifier() + "/" + String.valueOf(childId));
		}
	}

	protected void chargerObjetsEnMemoire(List liste) {
		for (Object o : liste) {
			Hibernate.initialize(o);
		}
	}

	protected boolean userConnecte() {
		return utilisateurActuel != null;
	}

}
