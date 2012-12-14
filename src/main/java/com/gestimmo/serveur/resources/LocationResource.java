package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.BienService;
import com.gestimmo.serveur.service.LocationService;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.*;

import java.util.HashMap;
import java.util.Map;

public class LocationResource extends ServerResource {

	private final LocationService locationProcessus = new LocationService();

	@Put
	public Representation creerLocation(final Representation entity) {
		final Form form = new Form(entity);

		final int idLoc = locationProcessus.creerLocation(form.getFirstValue("idBien"), form.getFirstValue("dateDebut"), form.getFirstValue("dateFin"));

		return new StringRepresentation(String.valueOf(idLoc));
	}

}