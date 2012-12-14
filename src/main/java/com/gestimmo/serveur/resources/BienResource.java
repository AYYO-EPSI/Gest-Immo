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
		Map<String, Object> donnees = new HashMap<String, Object>();
		donnees.put("pageTitle", "Voir un bien");
		donnees.put("bien", leBienRepresente);

		return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with(donnees);
	}

	@Post
	public Representation mettreAjour() {
		String title = "MaJ du bien !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}

	@Delete
	public Representation supprimer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
}