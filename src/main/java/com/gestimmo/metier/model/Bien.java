package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;

import java.util.ArrayList;
import java.util.List;

public class Bien {

	private int idBien;
	private double surface;
	private char energie;
	private String adresse;
	private String codePostal;
	private String ville;
	private int tailleGarage;
	private int nbPieces;
	private int tailleVeranda;
	private List<Periode> periodes = new ArrayList<Periode>();
	private List<Location> locations = new ArrayList<Location>();
	private Type type;
	private Calculateur calc = new Calculateur();

	public Bien() {

	}

	public Bien(double nouvelleSurface, char ener, String nouvelleAdresse, String cp, String ville, int tailleGarage, int nbPieces, int tailleVeranda) {
		setSurface(nouvelleSurface);
		setEnergie(ener);
		setAdresse(nouvelleAdresse);
		setCodePostal(cp);
		setVille(ville);
		setTailleGarage(tailleGarage);
		setNbPieces(nbPieces);
		setTailleVeranda(tailleVeranda);
	}

	public int getIdBien() {
		return idBien;
	}

	public void setIdBien(int nouvelId) {
		idBien = nouvelId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type nouveauType) {
		type = nouveauType;
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

	public void setCodePostal(String nouveauCodePostal) {
		codePostal = nouveauCodePostal;
	}

	public String getCodePostal() {
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

	public int getNbPieces() {
		return nbPieces;
	}

	public void setTailleGarage(int nouvelleTailleGarage) throws AppliDataException {
		if (nouvelleTailleGarage < 0) {
			throw new AppliDataException("le nombre de metre carre pour le garage est invalide");
		}
		tailleGarage = nouvelleTailleGarage;
	}

	public int getTailleGarage() {
		return tailleGarage;
	}

	public void setTailleVeranda(int nouvelleTailleVeranda) throws AppliDataException {
		if (nouvelleTailleVeranda < 0) {
			throw new AppliDataException("le nombre de metre carre pour la veranda est invalide");
		}
		tailleVeranda = nouvelleTailleVeranda;
	}

	public int getTailleVeranda() {
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

	public List<Periode> getPeriodes() {
		return periodes;
	}

	public Location getLocation(int idLocation) {
		Location locationARetourner = null;
		for (Location uneLocation : locations) {
			if (uneLocation.getId() == idLocation) {
				locationARetourner = uneLocation;
			}
		}

		return locationARetourner;
	}

	public void ajouterPeriode(Periode nouvellePeriode) {
		for (Periode unePeriode : periodes) {
			if (unePeriode.getPeriode().overlaps(nouvellePeriode.getPeriode())) {
				throw new AppliDataException("Les périodes de location se chevauchent.");
			}
		}
		periodes.add(nouvellePeriode);
	}

	public void setPeriodes(List<Periode> listePeriodes) {
		periodes = listePeriodes;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void ajouterLocation(Location nouvelleLoc) {
		for (Location uneLocation : locations) {
			if (uneLocation.getPeriode().overlaps(nouvelleLoc.getPeriode())) {
				throw new AppliDataException("Les périodes de location se chevauchent.");
			}
		}
		locations.add(nouvelleLoc);
	}

	public void setLocations(List<Location> listeLocations) {
		locations = listeLocations;
	}

	public double calculerMontantLocation(int idLocation) {
		return calc.calculerPrixLocation(this, (getLocation(idLocation)).getPeriode());
	}
}