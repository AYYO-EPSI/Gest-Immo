package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class Periode {

	private int id;
	private String libelle;
	private double montant;
	private Interval periode;


	public Periode() {
	}

	public Periode(int indice) {
		setId(indice);
	}

	public Periode(String lib, DateTime dateDeb, DateTime dateFin, Double prix) {
		setLibelle(lib);
		setPeriode(new Interval(dateDeb, dateFin));
		setMontant(prix);
	}

	public int getId() {
		return id;
	}

	public void setId(int nouvelId) {
		id = nouvelId;
	}

	public void setLibelle(String nouveauLibelle) {
		libelle = nouveauLibelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setMontant(double nouveauMontant) throws AppliDataException {
		if (nouveauMontant <= 0) {
			throw new AppliDataException("Le montant d'une location doit etre positif.");
		}

		montant = nouveauMontant;
	}

	public double getMontant() {
		return montant;
	}

	public Interval getPeriode() {
		return periode;
	}

	public void setPeriode(Interval nouvellePeriode) {
		periode = nouvellePeriode;
	}
}
