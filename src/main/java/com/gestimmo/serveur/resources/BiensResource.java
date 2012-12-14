package com.gestimmo.serveur.resources;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.BienService;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class BiensResource extends BaseResource {
	@Post
	public void creerBien(Representation entity) throws ResourceException {
		final Form form = new Form(entity);

		final int idLoc = ServiceFactory.getBienService().creer(form.getFirstValue("surface"), form.getFirstValue("energie"), form.getFirstValue("adresse"), form.getFirstValue("codePostal"), form.getFirstValue("ville"), form.getFirstValue("tailleGarage"), form.getFirstValue("nbPieces"), form.getFirstValue("tailleVeranda"));

		getResponse().redirectSeeOther(getChildReference(getRequest().getResourceRef(), idLoc));
	}
}