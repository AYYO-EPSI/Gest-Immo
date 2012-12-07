package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.BienService;
import org.restlet.representation.Representation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class BienResource extends ServerResource {

	private final BienService bienProcessus = new BienService();

	@Get
	public Representation voir() {
		bienProcessus.creerBien();

		int idBien = Integer.parseInt((String) getRequest().getAttributes().get("bienId"));

		Map<String, Object> donnees = new HashMap<String, Object>();
		donnees.put("pageTitle", "Voir un bien !!!");
		donnees.put("bien", bienProcessus.getUnBien(idBien));

		return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with(donnees);
	}

	@Post
	public Representation mettreAjour() {
		String title = "MaJ du bien !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}

	@Put
	public Representation creer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}

	@Delete
	public Representation supprimer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
}