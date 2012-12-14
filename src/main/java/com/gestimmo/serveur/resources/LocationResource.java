package com.gestimmo.serveur.resources;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Location;
import com.gestimmo.serveur.service.BienService;
import com.gestimmo.serveur.service.LocationService;
import com.gestimmo.serveur.service.ServiceFactory;

public class LocationResource extends BaseResource {

	private Bien leBienParent;
	private Location laLocationRepresentee;

	private final LocationService locationProcessus = new LocationService();
	private final BienService bienProcessus = new BienService();

	@Override
	public void doInit() {
		final int idBien = Integer.parseInt((String) getRequest().getAttributes().get("bienId"));
		leBienParent = ServiceFactory.getBienService().recuperer(idBien);
		if (leBienParent != null) {
			final String idLoc = (String) getRequestAttributes().get("locId");
		}
	}
}