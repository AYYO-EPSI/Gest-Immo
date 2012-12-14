package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.dao.GenericDAO;
import com.gestimmo.metier.model.Bien;

public class BienService extends GenericService {
	private final GenericDAO bienDao = DaoFactory.getBienDAO();

	@Override
	public int creer(String... args) {
		try {
			Bien bien = new Bien(Double.parseDouble(args[0]), args[1].charAt(0), args[2], args[3], args[4], Integer.parseInt(args[5]), Integer.parseInt(args[6]), Integer.parseInt(args[7]));

			bienDao.saveOrUpdate(bien);

			return bien.getIdBien();
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public Bien recuperer(int idBien) {
		Bien unBien = (Bien) bienDao.find(Bien.class, idBien);
		return unBien;
	}

	@Override
	public void metttreAJour() {

	}

	@Override
	public void supprimer() {

	}
}
