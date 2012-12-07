package com.gestimmo.metier.dao;

public class DaoFactory {
	public static GenericDAO getBienDAO() {
		return new BienDao();
	}
}
