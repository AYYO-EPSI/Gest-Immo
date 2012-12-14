package com.gestimmo.serveur.service;


public abstract class GenericService {
	abstract public int creerObjet(String... args);

	abstract public Object recupererObjet(int id);

	abstract public void metttreAJourObjet();

	abstract public void supprimerObjet();
}