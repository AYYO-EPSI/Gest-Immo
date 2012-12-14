package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Bien;

public class BienService {
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	public int creerBien(String surface,
			String energie,
			String adresse,
			String codePostal,
			String ville,
			String tailleGarage,
			String nbPieces,
			String tailleVeranda) {
		Bien bien = new Bien();
		bien.setEnergie(energie.charAt(0));
		bien.setAdresse(adresse);
		bien.setCodePostal(codePostal);
		bien.setNbPieces(Integer.parseInt(nbPieces));
		bien.setSurface(Double.parseDouble(surface)  );
		bien.setTailleGarage(Integer.parseInt(tailleGarage));
		bien.setTailleVeranda(Integer.parseInt(tailleVeranda));
		bien.setVille(ville);

		bienDao.saveOrUpdate(bien);
		
		return bien.getIdBien();
	}

	public Bien getUnBien(int idBien) {
		Bien unBien = (Bien) bienDao.find(Bien.class, idBien);
		return unBien;
	}
}
