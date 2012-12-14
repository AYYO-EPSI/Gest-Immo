package com.gestimmo.metier.model;

import org.joda.time.Interval;

public class Location {

	private int id;
	private Interval periode;

	public Location() {

	}

	public Location(Interval periode) {
		setPeriode(periode);
	}

	public int getId() {
		return id;
	}

	public void setId(int nouvelId) {
		id = nouvelId;
	}

	public Interval getPeriode() {
		return periode;
	}

	public void setPeriode(Interval nouvellePeriode) {
		periode = nouvellePeriode;
	}
}
