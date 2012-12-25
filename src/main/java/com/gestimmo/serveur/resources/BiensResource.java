package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;

public class BiensResource extends BaseResource {

	@Override
	public void doInit() {
		super.doInit();
		if (!userConnecte()) {
			getResponse().redirectSeeOther(getRequest().getRootRef());
		}
	}

	@Get
	public Representation voirSesBiens() {
		chargerObjetsEnMemoire(utilisateurActuel.getBiens());
		return TemplateRepresentation.createNew("listeBiens.ftl", getContext()).with("listeBiens", utilisateurActuel.getBiens());
	}
}