package com.gestimmo.metier.dao;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Location;
import com.gestimmo.metier.model.Periode;
import com.gestimmo.metier.model.Utilisateur;

public class DaoFactory {
	public static GenericDao getBienDAO() {
		return new GenericDao<Bien>(Bien.class);
	}

	public static GenericDao getLocationDAO() {
		return new GenericDao<Location>(Location.class);
	}

	public static GenericDao getPeriodeDAO() {
		return new GenericDao<Periode>(Periode.class);
	}

	public static GenericDao getUtilisateurDAO() {
		return new GenericDao<Utilisateur>(Utilisateur.class);
	}
}