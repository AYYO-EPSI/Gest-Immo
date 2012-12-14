package com.gestimmo.metier.dao;

public class DaoFactory {
	public static GenericDAO getBienDAO() {
		return new BienDao();
	}

	public static GenericDAO getLocationDAO() {
		return new LocationDao();
	}
}
