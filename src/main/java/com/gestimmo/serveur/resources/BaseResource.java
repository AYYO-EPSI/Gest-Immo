package com.gestimmo.serveur.resources;

import org.hibernate.Hibernate;
import org.restlet.data.Reference;
import org.restlet.resource.ServerResource;

import java.util.List;

public class BaseResource extends ServerResource {
	protected Reference getChildReference(Reference parentRef, int childId) {
		if (parentRef.getIdentifier().endsWith("/")) {
			return new Reference(parentRef.getIdentifier() + String.valueOf(childId));
		} else {
			return new Reference(parentRef.getIdentifier() + "/" + String.valueOf(childId));
		}
	}

	protected void chargerObjetsEnMemoire(List liste) {
		for (Object o: liste) {
			Hibernate.initialize(o);
		}
	}
}
