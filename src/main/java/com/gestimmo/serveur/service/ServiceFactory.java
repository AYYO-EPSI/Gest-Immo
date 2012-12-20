package com.gestimmo.serveur.service;

public class ServiceFactory {
	public static BienService getBienService() {
		return new BienService();
	}

	public static LocationService getLocationService() {
		return new LocationService();
	}

	public static PeriodeService getPeriodeService() {
		return new PeriodeService();
	}
}