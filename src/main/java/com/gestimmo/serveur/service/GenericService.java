package com.gestimmo.serveur.service;


public abstract class GenericService {
	abstract public int creer(String... args);

	abstract public Object recuperer(int id);

	abstract public void metttreAJour();

	abstract public void supprimer();
}