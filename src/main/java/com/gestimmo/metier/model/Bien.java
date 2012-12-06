package com.gestimmo.metier.model;

import com.gestimmo.metier.exceptions.AppliDataException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

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

	public Integer getNbPieces() {
		return nbPieces;
	}

	public void setTailleGarage(int nouvelleTailleGarage) {
		tailleGarage = nouvelleTailleGarage;
		
	}

	public Integer getTailleGarage() {
		return tailleGarage;
	}

	public void setTailleVeranda(int nouvelleTailleVeranda) {
		tailleVeranda = nouvelleTailleVeranda;
		
	}

	public Integer getTailleVeranda() {
		return tailleVeranda;
	}

	public Periode getPeriode(int id) {
		Periode periodeARetourner = null;
		for (Periode p : periodes) {
			if ( p.getId() == id ) {
				periodeARetourner = p;
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

	public void ajouterPeriodes(ArrayList<Periode> listePeriodes) {
		periodes = listePeriodes;
	}

	
	
	
}
