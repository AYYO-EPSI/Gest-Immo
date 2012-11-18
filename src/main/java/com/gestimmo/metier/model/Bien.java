package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;

import java.util.ArrayList;

public class Bien {

	private double surface;
	private char energie;
	private String adresse;
	private String codePostal;
	private String ville;
	private int tailleGarage;
	private int nbPieces;
	private int tailleVeranda;

	public void setSurface(double nouveleSurface) {
		surface = nouveleSurface;
	}

	public double getSurface() {
		return surface;
	}

	public void setEnergie(char nouvelleEnergie) throws AppliDataException {
		ArrayList<String> energiesValides = new ArrayList<String>() {{add("A"); add("B"); add("C"); add("D"); add("E"); add("F"); add("G");}};

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

	public Object getType() {
		return new Object();
	}
	
}
