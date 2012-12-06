package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.*;

public class DefaultResource extends ServerResource {

	@Get
	@Post
	@Put
	@Delete
	public Representation represente() {
		String file, title;
		final String pageReference = getReference().getRemainingPart().substring(1);

		if (pageReference.length() != 0 && TemplateRepresentation.templateExiste("statique/" + pageReference + ".ftl", getContext())) {
			file = "statique/" + pageReference;
			title = pageReference.substring(0, 1).toUpperCase() + pageReference.substring(1).toLowerCase();
		} else {
			file = "index";
			title = "Accueil";
		}

		return TemplateRepresentation.createNew(file + ".ftl", getContext()).with("pageTitle", title);
	}
}
