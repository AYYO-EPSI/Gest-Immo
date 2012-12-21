package com.gestimmo.metier.model;

import org.joda.time.Days;
import org.joda.time.Interval;

import java.util.HashMap;
import java.util.Map;

public class
		Calculateur {
	public double calculerPrixLocation(Bien bien, Interval datesReservation) {
		double prixARetourner = 0;
		HashMap<Integer, Periode> listePeriodes = new HashMap<Integer, Periode>();
		for (Periode unePeriode : bien.getPeriodes()) {
			if (unePeriode.getPeriode().contains(datesReservation.getStart()) && unePeriode.getPeriode().contains(datesReservation.getEnd())) {
				listePeriodes.put(Days.daysBetween(datesReservation.getStart().toDateMidnight(), datesReservation.getEnd().toDateMidnight()).getDays(), unePeriode);
			} else if (unePeriode.getPeriode().contains(datesReservation.getStart())) {
				listePeriodes.put((Days.daysBetween(datesReservation.getStart().toDateMidnight(), unePeriode.getPeriode().getEnd().toDateMidnight()).getDays()), unePeriode);
			} else if (unePeriode.getPeriode().contains(datesReservation.getEnd())) {
				listePeriodes.put((Days.daysBetween(unePeriode.getPeriode().getStart().toDateMidnight(), datesReservation.getEnd().toDateMidnight()).getDays()), unePeriode);
			} else if (!unePeriode.getPeriode().isBefore(datesReservation.getStart()) && !unePeriode.getPeriode().isAfter(datesReservation.getEnd())) {
				listePeriodes.put((Days.daysBetween(unePeriode.getPeriode().getStart().toDateMidnight(), unePeriode.getPeriode().getEnd().toDateMidnight()).getDays()), unePeriode);
			}
		}

		for (Map.Entry<Integer, Periode> uneEntree : listePeriodes.entrySet()) {
			prixARetourner += uneEntree.getKey() * uneEntree.getValue().getMontant();
		}

		return prixARetourner;
	}
}
