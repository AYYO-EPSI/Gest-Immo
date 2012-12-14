package com.gestimmo.serveur.resources;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Location;
import com.gestimmo.serveur.service.ServiceFactory;

public class LocationResource extends BaseResource {

	private Bien leBienParent;
	private Location laLocationRepresentee;

	@Override
	public void doInit() {
		leBienParent = ServiceFactory.getBienService().recupererObjet(Integer.parseInt((String) getRequest().getAttributes().get("bienId")));
		if (leBienParent != null) {
			laLocationRepresentee = ServiceFactory.getLocationService().recupererObjet(Integer.parseInt(((String) getRequestAttributes().get("locId"))));
		}
	}
}