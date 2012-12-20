package com.gestimmo.serveur.service;

import com.gestimmo.metier.dao.DaoFactory;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Location;
import com.gestimmo.metier.model.Periode;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class PeriodeService extends GenericService {

	@Override
	public int creerObjet(String... args) {
		DateTime dateDeb = new DateTime(Integer.parseInt(args[1].substring(6)), Integer.parseInt(args[1].substring(3, 5)), Integer.parseInt(args[1].substring(0, 2)), 0, 0, 0);
		DateTime dateFin = new DateTime(Integer.parseInt(args[2].substring(6)), Integer.parseInt(args[2].substring(3, 5)), Integer.parseInt(args[2].substring(0, 2)), 0, 0, 0);
		Double prix = Double.parseDouble(args[3]);
		String lib = args[4];

		Periode periode = new Periode(lib, dateDeb, dateFin, prix);


		Bien bien = (Bien) DaoFactory.getBienDAO().find(Bien.class, Integer.parseInt(args[0]));
		bien.ajouterPeriode(periode);

		DaoFactory.getPeriodeDAO().saveOrUpdate(periode);
		DaoFactory.getBienDAO().saveOrUpdate(bien);

		return periode.getId();
	}

	@Override
	public Periode recupererObjet(int idPeriode) {
		return (Periode) DaoFactory.getPeriodeDAO().find(Periode.class, idPeriode);
	}

	@Override
	public void metttreAJourObjet() {

	}

	@Override
	public void supprimerObjet() {

	}
}
