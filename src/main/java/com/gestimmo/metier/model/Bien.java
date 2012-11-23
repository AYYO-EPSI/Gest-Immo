package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import java.util.ArrayList;

public class Bien {
	//	Chateau,
	//	Taudis,
	//	CabaneAuFondDuJardin;

	private double surface;
	private char energie;
	private String adresse;
	private String codePostal;
	private String ville;
	private int tailleGarage;
	private int nbPieces;
	private int tailleVeranda;

	private ArrayList<Periode> periodes = new ArrayList<Periode>();


	public void setSurface(double nouveleSurface) {
		surface = nouveleSurface;
	}

	public double getSurface() {
		return surface;
	}

	public void setEnergie(char nouvelleEnergie) throws AppliDataException {
		ArrayList<String> energiesValides = new ArrayList<String>() {{
			add("A");
			add("B");
			add("C");
			add("D");
			add("E");
			add("F");
			add("G");
		}};

		if (!energiesValides.contains(String.valueOf(nouvelleEnergie)))
			throw new AppliDataException("Energie non valide.");
		energie = nouvelleEnergie;
	}

	public char getEnergie() {
		return energie;
	}

	public void setAdresse(String nouvelleAdresse) {
		adresse = nouvelleAdresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setCodePostale(String nouveauCodePostal) {
		codePostal = nouveauCodePostal;
	}

	public String getCodePostale() {
		return codePostal;
	}

	public void setVille(String nouvelleVille) {
		ville = nouvelleVille;
	}

	public String getVille() {
		return ville;
	}

	public void setNbPieces(int nombreDePiece) throws AppliDataException {
		if (nombreDePiece < 1)
			throw new AppliDataException("Le nombre de pièces ne peut-être inférieur à 1.");
		nbPieces = nombreDePiece;
	}

	public Integer getNbPieces() {
		return nbPieces;
	}

	public void setGarage(int nouvelleTailleGarage) {
		tailleGarage = nouvelleTailleGarage;
	}

	public Integer getGarage() {
		return tailleGarage;
	}

	public void setVeranda(int nouvelleTailleVeranda) {
		tailleVeranda = nouvelleTailleVeranda;
	}

	public Integer getVeranda() {
		return tailleVeranda;
	}

	public Periode getPeriode(int idPeriode) {
		Periode periodeARetourner = null;
		for (Periode unePeriode : periodes) {
			if (unePeriode.getId() == idPeriode) {
				periodeARetourner = unePeriode;
			}
		}

		return periodeARetourner;
	}

	public ArrayList<Periode> getPeriodes() {
		return periodes;
	}

	public void ajouterPeriode(Periode nouvellePeriode) {
		periodes.add(nouvellePeriode);
	}

	public void setPeriodes(ArrayList<Periode> listePeriodes) {
		periodes = listePeriodes;
	}

	public double calculerPrixLocation(DateTime dateDebutReservation, DateTime dateFinReservation) {
		double prixARetourner = 0;
		int totalJour;

		Interval intervalReservation = new Interval(dateDebutReservation, dateFinReservation);
		Interval intervalEntrePeriode, intervalDates;

		for (Periode p : periodes) {
			intervalDates = new Interval(p.getDateDebut(), p.getDateFin());

			if ( ( intervalEntrePeriode = intervalDates.overlap(intervalReservation) ) != null) {
				totalJour = Days.daysBetween(intervalEntrePeriode.getStart().toDateMidnight(), intervalEntrePeriode.getEnd().toDateMidnight()).getDays();
				prixARetourner += totalJour * p.getMontant();
			}
		}

		return prixARetourner;
	}


}
