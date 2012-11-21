package com.gestimmo.metier.model;

import java.util.Date;

public class Periode {

	private String libelle;
	private double montant;
	private Date dateDebut;
	private Date dateFin;
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

	public void setDateDebut(Date date) {
		dateDebut = date;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateFin(Date date) {
		dateFin = date;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public int getId() {
		return id;
	}

}
