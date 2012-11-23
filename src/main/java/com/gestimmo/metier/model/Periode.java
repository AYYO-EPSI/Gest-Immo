package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;
import org.joda.time.DateTime;

public class Periode {

	private String libelle;
	private double montant;
	private DateTime dateDebut;
	private DateTime dateFin;
	private int id;

	public Periode() {
	}

	public Periode(int indice) {
		id = indice;
	}

	public void setLibelle(String nouveauLibelle) {
		libelle = nouveauLibelle;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setMontant(double nouveauMontant) throws AppliDataException {
		if (nouveauMontant <= 0){
			throw new AppliDataException("Le montant d'une location doit etre positif.");
			}

		montant = nouveauMontant;
	}

	public Double getMontant() {
		return montant;
	}

	public void setDateDebut(DateTime nouvelleDateDebut) throws AppliDataException {
		if (dateFin != null && nouvelleDateDebut.isAfter(dateFin)) {
			throw new AppliDataException ("La date de debut doit etre inferieure a la date de fin de periode");
		}

		dateDebut = nouvelleDateDebut;
	}

	public DateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateFin(DateTime nouvelleDateFin) throws AppliDataException {
		if (dateDebut != null && nouvelleDateFin.isBefore(dateDebut)) {
			throw new AppliDataException ("La date de fin doit etre superieure a la date de debut de periode");
		}

		dateFin = nouvelleDateFin;
	}

	public DateTime getDateFin() {
		return dateFin;
	}

	public int getId() {
		return id;
	}

}
