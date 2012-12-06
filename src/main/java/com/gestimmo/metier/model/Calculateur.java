package com.gestimmo.metier.model;

import java.util.HashMap;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

public class Calculateur {
	public double calculerPrixLocation(Bien bien, Interval datesReservation) {
		double prixARetourner = 0;
		HashMap<Integer, Periode> listePeriodes = new HashMap<Integer, Periode>();
		for ( Periode p : bien.getPeriodes() ) {			
			
			Interval intervalDates = new Interval(p.getDateDebut(), p.getDateFin());
			
			if ( intervalDates.contains(datesReservation.getStart()) && intervalDates.contains(datesReservation.getEnd()) ) 
			{
				listePeriodes.put(Days.daysBetween(datesReservation.getStart().toDateMidnight(), datesReservation.getEnd().toDateMidnight()).getDays(), p);
			}
			else if ( intervalDates.contains(datesReservation.getStart()) ) 
			{
				listePeriodes.put(( Days.daysBetween(datesReservation.getStart().toDateMidnight(), p.getDateFin().toDateMidnight()).getDays() ), p);
			} 
			else if ( intervalDates.contains(datesReservation.getEnd()) ) 
			{
				listePeriodes.put(( Days.daysBetween(p.getDateDebut().toDateMidnight(), datesReservation.getEnd().toDateMidnight()).getDays() ), p);
			} 
			else if ( !intervalDates.isBefore(datesReservation.getStart()) && !intervalDates.isAfter(datesReservation.getEnd())) 
			{
				listePeriodes.put(( Days.daysBetween( p.getDateDebut().toDateMidnight(), p.getDateFin().toDateMidnight()).getDays() ), p);
			}
		}
		
		for (Map.Entry<Integer, Periode> e : listePeriodes.entrySet()) {
			prixARetourner += e.getKey() * e.getValue().getMontant();
		}
		
		return prixARetourner;
	}
}
