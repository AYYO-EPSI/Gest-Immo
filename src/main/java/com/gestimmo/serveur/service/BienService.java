package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Bien;

public class BienService {
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	public void creerBien() {
		Bien tt = new Bien();
		tt.setEnergie('A');
		tt.setAdresse("Adresse");
		tt.setCodePostal("CodePostal");
		tt.setNbPieces(666);
		tt.setSurface(666);
		tt.setTailleGarage(0);
		tt.setTailleVeranda(0);
		tt.setVille("CorsicaCityBeach");

		bienDao.saveOrUpdate(tt);
	}

	public Bien getUnBien(int idBien) {
		Bien unBien = (Bien) bienDao.find(Bien.class, idBien);
		return unBien;
	}
}
