package com.gestimmo.metier.model;

import org.joda.time.DateTime;

public class Periode {

	private String libelle;
	private double montant;
	private DateTime dateDebut;
	private DateTime dateFin;
	private int id;

	public Periode() {}

	public Periode(int indice) {
		id = indice;
	}

	public void setLibelle(String nouveauLibelle) {
		libelle = nouveauLibelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setMontant(double nouveauMontant) {
		montant = nouveauMontant;
	}

	public Double getMontant() {
		return montant;
	}

	public void setDateDebut(DateTime date) {
		dateDebut = date;
	}

	public DateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateFin(DateTime date) {
		dateFin = date;
	}

	public DateTime getDateFin() {
		return dateFin;
	}

	public int getId() {
		return id;
	}

}
