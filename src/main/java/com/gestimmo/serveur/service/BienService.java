package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Type;
import com.gestimmo.metier.model.Utilisateur;

public class BienService extends GenericService {

	@Override
	public int creerObjet(String... args) {
		Bien bien = new Bien(Type.valueOf(args[1]), Double.parseDouble(args[2]), args[3].charAt(0), args[4], args[5], args[6], Integer.parseInt(args[7]), Integer.parseInt(args[8]), Integer.parseInt(args[9]));

		Utilisateur util = (Utilisateur) DaoFactory.getUtilisateurDAO().find(Integer.parseInt(args[0]));
		util.ajouterBien(bien);

		DaoFactory.getLocationDAO().saveOrUpdate(util);
		DaoFactory.getBienDAO().saveOrUpdate(bien);

		return bien.getIdBien();
	}

	@Override
	public Bien recupererObjet(int idBien) {
		return (Bien) DaoFactory.getBienDAO().find(idBien);
	}

	@Override
	public void metttreAJourObjet() {

	}

	@Override
	public void supprimerObjet() {

	}
}
