package com.gestimmo.metier.model;

import org.joda.time.Interval;

public class Location {

	private int id;
	private Interval periode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Interval getPeriode() {
		return periode;
	}

	public void setPeriode(Interval periode) {
		this.periode = periode;
	}

}
