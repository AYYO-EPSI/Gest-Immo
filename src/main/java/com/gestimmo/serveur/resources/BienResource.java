package com.gestimmo.serveur.resources;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.HashMap;
import java.util.Map;

public class BienResource extends BaseResource {

	private Bien leBienRepresente;

	@Override
	public void doInit() {
		final int idBien = Integer.parseInt((String) getRequest().getAttributes().get("bienId"));
		leBienRepresente = ServiceFactory.getBienService().recupererObjet(idBien);
	}

	@Get
	public Representation voirBien() {
		return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with("bien", leBienRepresente);
	}

	@Post
	public Representation mettreAjour() {
		return TemplateRepresentation.createNew("index.ftl", getContext());
	}

	@Delete
	public Representation supprimer() {
		return TemplateRepresentation.createNew("index.ftl", getContext());
	}
}