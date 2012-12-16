package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class BiensResource extends BaseResource {
	@Get
	public Representation afficherForm() {
		return TemplateRepresentation.createNew("ajoutBien.ftl", getContext());
	}

	@Post
	public void creerBien(Representation entity) throws ResourceException {
		final Form form = new Form(entity);

		final int idBien = ServiceFactory.getBienService().creerObjet(form.getFirstValue("surface"), form.getFirstValue("energie"), form.getFirstValue("adresse"), form.getFirstValue("codePostal"), form.getFirstValue("ville"), form.getFirstValue("tailleGarage"), form.getFirstValue("nbPieces"), form.getFirstValue("tailleVeranda"));

		if (idBien != 0) {
			setStatus(Status.SUCCESS_CREATED);
			getResponse().redirectSeeOther(getChildReference(getRequest().getResourceRef(), idBien));
		} else {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Erreur: donnée(s) invalide.");
		}
	}
}