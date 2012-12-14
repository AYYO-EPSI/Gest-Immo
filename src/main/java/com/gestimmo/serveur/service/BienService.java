package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Bien;

public class BienService {
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	public int creerBien(String surface, String energie, String adresse, String codePostal, String ville, String tailleGarage, String nbPieces, String tailleVeranda) {
		try {
			Bien bien = new Bien(Double.parseDouble(surface), energie.charAt(0), adresse, codePostal, ville, Integer.parseInt(tailleGarage), Integer.parseInt(nbPieces), Integer.parseInt(tailleVeranda));

			bienDao.saveOrUpdate(bien);

			return bien.getIdBien();
		} catch (Exception e) {
			return 0;
		}
	}

	public Bien voirUnBien(int idBien) {
		Bien unBien = (Bien) bienDao.find(Bien.class, idBien);
		return unBien;
	}
}
