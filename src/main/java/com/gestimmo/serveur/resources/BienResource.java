package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.webProcessus.BienProcessus;
import org.restlet.representation.Representation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class BienResource extends ServerResource {

	private final BienProcessus bienProcessus = new BienProcessus();

	@Get
	public Representation voir() {
		bienProcessus.creerBien();

		int idBien = (Integer) getRequest().getAttributes().get("bienId");

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