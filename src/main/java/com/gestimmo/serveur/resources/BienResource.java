package com.gestimmo.serveur.resources;

import com.gestimmo.metier.exceptions.ApplicationMainException;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Type;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class BienResource extends BaseResource {

	private Bien leBienRepresente;

	@Override
	public void doInit() {
		super.doInit();
		if (getRequest().getAttributes().get("bienId") != null) {
			int idBien = Integer.parseInt((String) getRequest().getAttributes().get("bienId"));
			leBienRepresente = ServiceFactory.getBienService().recupererObjet(idBien);
		}
	}

	@Get
	public Representation voirBien() {
		if (leBienRepresente != null) {
			chargerObjetsEnMemoire(leBienRepresente.getLocations());
			chargerObjetsEnMemoire(leBienRepresente.getPeriodes());
			return TemplateRepresentation.createNew("voirBien.ftl", getContext()).with("bien", leBienRepresente);
		} else {
			return TemplateRepresentation.createNew("ajoutBien.ftl", getContext()).with("listeTypes", Type.values());
		}
	}

	@Post
	public Representation creerObjet(Representation entity) throws ResourceException {
		if (leBienRepresente == null) {
			final Form form = new Form(entity);

			try {
				final int idBien = ServiceFactory.getBienService().creerObjet("1", form.getFirstValue("type"), form.getFirstValue("surface"), form.getFirstValue("energie"), form.getFirstValue("adresse"), form.getFirstValue("codePostal"), form.getFirstValue("ville"), form.getFirstValue("tailleGarage"), form.getFirstValue("nbPieces"), form.getFirstValue("tailleVeranda"));

				setStatus(Status.SUCCESS_CREATED);
				getResponse().redirectSeeOther(getChildReference(getRequest().getResourceRef(), idBien));
			} catch (NumberFormatException ne) {
				throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Conversion illicite.");
			} catch (ApplicationMainException e) {
				throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, e.getMessage());
			}
		}

		return null;
	}
}