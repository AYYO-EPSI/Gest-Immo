package com.gestimmo.serveur.resources;

import org.restlet.data.Reference;
import org.restlet.resource.ServerResource;

public class BaseResource extends ServerResource {
	protected Reference getChildReference(Reference parentRef, int childId) {
		if (parentRef.getIdentifier().endsWith("/")) {
			return new Reference(parentRef.getIdentifier() + String.valueOf(childId));
		} else {
			return new Reference(parentRef.getIdentifier() + "/" + String.valueOf(childId));
		}
	}
}
