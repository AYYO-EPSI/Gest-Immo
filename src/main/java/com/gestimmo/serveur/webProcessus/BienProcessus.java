package com.gestimmo.serveur.webProcessus;

import com.gestimmo.metier.dao.BienDao;
import com.gestimmo.metier.model.Bien;

public class BienProcessus {
	private final BienDao bienDao = new BienDao();

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
