package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Location;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class LocationService extends GenericService {

	@Override
	public int creerObjet(String... args) {
		DateTime dateDeb = new DateTime(Integer.parseInt(args[1].substring(6)), Integer.parseInt(args[1].substring(3, 5)), Integer.parseInt(args[1].substring(0, 2)), 0, 0, 0);
		DateTime dateFin = new DateTime(Integer.parseInt(args[2].substring(6)), Integer.parseInt(args[2].substring(3, 5)), Integer.parseInt(args[2].substring(0, 2)), 0, 0, 0);
		Location loc = new Location(new Interval(dateDeb, dateFin));

		Bien bien = (Bien)DaoFactory.getBienDAO().find(Bien.class, Integer.parseInt(args[0]));
		bien.ajouterLocation(loc);

		DaoFactory.getLocationDAO().saveOrUpdate(loc);
		DaoFactory.getBienDAO().saveOrUpdate(bien);

		return loc.getId();
	}

	@Override
	public Location recupererObjet(int idLoc) {
		Location uneLocation = (Location) DaoFactory.getLocationDAO().find(Bien.class, idLoc);
		return uneLocation;
	}
	@Override
	public void metttreAJourObjet() {

	}

	@Override
	public void supprimerObjet() {

	}
}
