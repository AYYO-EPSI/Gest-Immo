package com.gestimmo.serveur.resources;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class LocationResource extends BaseResource {

	private Bien leBienParent;

	@Override
	public void doInit() {
		leBienParent = ServiceFactory.getBienService().recupererObjet(Integer.parseInt((String) getRequest().getAttributes().get("bienId")));
	}

	@Get
	public Representation afficherForm() {
		return TemplateRepresentation.createNew("ajoutLocation.ftl", getContext()).with("bienId", leBienParent.getIdBien());
	}

	@Post
	public void creerLocation(final Representation entity) {
		final Form form = new Form(entity);

		final int idLoc = ServiceFactory.getLocationService().creerObjet(form.getFirstValue("idBien"), form.getFirstValue("dateDebut"), form.getFirstValue("dateFin"));

		if (idLoc != 0) {
			setStatus(Status.SUCCESS_CREATED);
			getResponse().redirectSeeOther(getRequest().getRootRef() + "/bien/" + form.getFirstValue("idBien"));
		} else {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Erreur: donnée(s) invalide.");
		}
	}

}