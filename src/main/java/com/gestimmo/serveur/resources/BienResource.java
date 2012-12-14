package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.BienService;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class BienResource extends ServerResource {

	private final BienService bienProcessus = new BienService();

	@Get
	public Representation voirBien() {
		int idBien = Integer.parseInt((String) getRequest().getAttributes().get("bienId"));

		Map<String, Object> donnees = new HashMap<String, Object>();
		donnees.put("pageTitle", "Voir un bien !!!");
		donnees.put("bien", bienProcessus.voirUnBien(idBien));

		return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with(donnees);
	}

	@Post
	public Representation mettreAjour() {
		String title = "MaJ du bien !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}

	@Put
	public Representation creerBien(final Representation entity) {
		final Form form = new Form(entity);

		final int idLoc = bienProcessus.creerBien(form.getFirstValue("surface"), 
				form.getFirstValue("energie"), 
				form.getFirstValue("adresse"), 
				form.getFirstValue("codePostal"), 
				form.getFirstValue("ville"), 
				form.getFirstValue("tailleGarage"), 
				form.getFirstValue("nbPieces"), 
				form.getFirstValue("tailleVeranda"));

		return new StringRepresentation(String.valueOf(idLoc));
	}

	@Delete
	public Representation supprimer() {
		String title = "Page des biens !!!";

		return TemplateRepresentation.createNew("index.ftl", getContext()).with("pageTitle", title);
	}
}