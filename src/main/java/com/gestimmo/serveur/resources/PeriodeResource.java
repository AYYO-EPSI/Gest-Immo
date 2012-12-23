package com.gestimmo.serveur.resources;

import com.gestimmo.metier.exceptions.ApplicationMainException;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.serveur.processes.TemplateRepresentation;
import com.gestimmo.serveur.service.ServiceFactory;
import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;

public class PeriodeResource extends BaseResource {
	private Bien leBienParent;

	@Override
	public void doInit() {
		super.doInit();
		leBienParent = ServiceFactory.getBienService().recupererObjet(Integer.parseInt((String) getRequest().getAttributes().get("bienId")));
	}

	@Get
	public Representation afficherForm() {
		return TemplateRepresentation.createNew("ajoutPeriode.ftl", getContext()).with("bienId", leBienParent.getIdBien());
	}

	@Post
	public void creerPeriode(final Representation entity) {
		final Form form = new Form(entity);

		try {
			ServiceFactory.getPeriodeService().creerObjet((String) getRequest().getAttributes().get("bienId"), form.getFirstValue("dateDebut"), form.getFirstValue("dateFin"), form.getFirstValue("prix"), form.getFirstValue("libelle"));

			setStatus(Status.SUCCESS_CREATED);
			getResponse().redirectSeeOther(getRequest().getRootRef() + "/bien/" + getRequest().getAttributes().get("bienId"));
		} catch (NumberFormatException ne) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, "Conversion illicite.");
		} catch (ApplicationMainException e) {
			throw new ResourceException(Status.CLIENT_ERROR_BAD_REQUEST, e.getMessage());
		}
	}

}
