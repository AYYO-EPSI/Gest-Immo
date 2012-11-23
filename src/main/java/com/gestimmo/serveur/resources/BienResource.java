package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class BienResource extends ServerResource {

	@Get
	public Representation represente() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
}
