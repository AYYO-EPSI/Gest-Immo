package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Type;

public class BienService extends GenericService {

	@Override
	public int creerObjet(String... args) {
		Bien bien = new Bien(Type.valueOf(args[0]), Double.parseDouble(args[1]), args[2].charAt(0), args[3], args[4], args[5], Integer.parseInt(args[6]), Integer.parseInt(args[7]), Integer.parseInt(args[8]));

		DaoFactory.getBienDAO().saveOrUpdate(bien);

		return bien.getIdBien();
	}

	@Override
	public Bien recupererObjet(int idBien) {
		return (Bien) DaoFactory.getBienDAO().find(Bien.class, idBien);
	}

	@Override
	public void metttreAJourObjet() {

	}

	@Override
	public void supprimerObjet() {

	}
}
