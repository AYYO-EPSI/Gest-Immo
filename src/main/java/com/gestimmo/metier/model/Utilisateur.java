package com.gestimmo.metier.model;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
	
	private int id;
	private List<Bien> tabBiens = new ArrayList<Bien>();
	
	public void setId(int i) {
		this.id=i;
	}

	public int getId() {
		return id;
	}

	public void ajouterBien(Bien bien) {
		tabBiens.add(bien);
	}

	public List<Bien> getBiens() {
		return tabBiens;
	}
	
	
	
	

}
