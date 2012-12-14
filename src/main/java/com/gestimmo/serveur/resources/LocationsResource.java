package com.gestimmo.serveur.resources;

import com.gestimmo.serveur.service.LocationService;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Post;

public class LocationsResource extends BaseResource {

	private final LocationService locationProcessus = new LocationService();

	@Post
	public void creerLocation(final Representation entity) {
		final Form form = new Form(entity);

		final int idLoc = ServiceFactory.getLocationService().creer(form.getFirstValue("idBien"), form.getFirstValue("dateDebut"), form.getFirstValue("dateFin"));

		getResponse().redirectSeeOther(getChildReference(getRequest().getResourceRef(), idLoc));
	}

}