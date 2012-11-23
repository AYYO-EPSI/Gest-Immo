package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import java.util.ArrayList;

public class Bien {

	private int id;
	private double surface;
	private char energie;
	private String adresse;
	private String codePostal;
	private String ville;
	private int tailleGarage; //fait
	private int nbPieces; // fait
	private int tailleVeranda;
	private ArrayList<Periode> periodes = new ArrayList<Periode>();
	private Type  type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSurface(double nouvelleSurface) throws AppliDataException {
                if (nouvelleSurface <= 0)
			throw new AppliDataException("Surface non conforme.");
		surface = nouvelleSurface;
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

	public void setGarage(int nouvelleTailleGarage) throws AppliDataException {
            if(nouvelleTailleGarage < 0){
                throw new AppliDataException ("le nombre de metre carre pour le garage est invalide");
            }
		tailleGarage = nouvelleTailleGarage;
	}

	public Integer getGarage() {
		return tailleGarage;
	}

	public void setVeranda(int nouvelleTailleVeranda) throws AppliDataException {
            if(nouvelleTailleVeranda < 0){
                throw new AppliDataException ("le nombre de metre carre pour la veranda est invalide");
            }
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
