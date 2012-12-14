package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Location;
import com.gestimmo.metier.model.Bien;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class LocationService extends GenericService {
	private final GenericDAO locationDao = DaoFactory.getLocationDAO();
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	@Override
	public int creer(String... args) {
		DateTime dateDeb = new DateTime(Integer.parseInt(args[1].substring(6)), Integer.parseInt(args[1].substring(3, 5)), Integer.parseInt(args[1].substring(0, 2)), 0, 0, 0);
		DateTime dateFin = new DateTime(Integer.parseInt(args[2].substring(6)), Integer.parseInt(args[2].substring(3, 5)), Integer.parseInt(args[2].substring(0, 2)), 0, 0, 0);
		Location loc = new Location(new Interval(dateDeb, dateFin));

		Bien bien = (Bien)bienDao.find(Bien.class, Integer.parseInt(args[0]));
		bien.ajouterLocation(loc);

		locationDao.saveOrUpdate(loc);
		bienDao.saveOrUpdate(bien);

		return loc.getId();
	}

	@Override
	public Location recuperer(int id) {
		return null;
	}

	@Override
	public void metttreAJour() {

	}

	@Override
	public void supprimer() {

	}
}
