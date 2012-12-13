package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Location;
import com.gestimmo.metier.model.Bien;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class LocationService {
	private final GenericDAO locationDao = DaoFactory.getLocationDAO();
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	public int creerLocation(String idBien, String debut, String fin) {

		DateTime dateDeb = new DateTime(Integer.parseInt(debut.substring(6)), Integer.parseInt(debut.substring(3, 5)), Integer.parseInt(debut.substring(0, 2)), 0, 0, 0);
		DateTime dateFin = new DateTime(Integer.parseInt(fin.substring(6)), Integer.parseInt(fin.substring(3, 5)), Integer.parseInt(fin.substring(0, 2)), 0, 0, 0);
		Interval interval = new Interval(dateDeb, dateFin);
		Location loc = new Location();
		loc.setPeriode(interval);

		Bien bien = (Bien)bienDao.find(Bien.class, Integer.parseInt(idBien));
		bien.ajouterLocation(loc);

		locationDao.saveOrUpdate(loc);

		bienDao.saveOrUpdate(bien);

		return loc.getId();
	}
}
