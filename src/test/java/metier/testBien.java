package metier;

import com.gestimmo.metier.exceptions.AppliDataException;
import com.gestimmo.metier.model.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class testBien extends TestCase {

	Bien unBien;
	Calculateur calc;

	public static TestSuite suite() {
		return new TestSuite(testBien.class);
	}

	public void setUp() {
		unBien = new Bien();
		calc = new Calculateur();
	}

	public void testObjetExisteetPasNul() {
		assertThat(unBien, is(allOf(instanceOf(Bien.class), notNullValue(Bien.class))));
	}

	public void testSurface() {
		unBien.setSurface(40.00);
		assertThat(unBien.getSurface(), is(40.00));
	}

	public void testSurfaceInferieurOuEgale0() {
		try {
			unBien.setSurface(-1);
			fail("Impossible d'avoir une surface inferieur ou �gale � 0");
		} catch (AppliDataException e) {
		}
	}


	public void testEnergie() {
		unBien.setEnergie('A');
		assertThat(unBien.getEnergie(), is('A'));
	}

	public void testNoteEnergieDoitEtreValide() {
		try {
			unBien.setEnergie('Z');
			fail("Impossible d'avoir une énergie notée Z.");
		} catch (AppliDataException e) {
		}
	}

	public void testAdresse() {
		unBien.setAdresse("adresse");
		assertThat(unBien.getAdresse(), is("adresse"));
	}

	public void testCodePostale() {
		unBien.setCodePostal("64600");
		assertThat(unBien.getCodePostal(), is("64600"));
	}

	public void testVille() {
		unBien.setVille("AngletCityBitch");
		assertThat(unBien.getVille(), is("AngletCityBitch"));
	}

	public void testNbPieces() {
		unBien.setNbPieces(1);
		assertThat(unBien.getNbPieces(), is(1));
	}

	public void testNbPiecesPas0() {
		try {
			unBien.setNbPieces(0);
			fail("Impossible d'obtenir aucune pièces.");
		} catch (AppliDataException e) {
		}
	}

	public void testGarage() {
		unBien.setTailleGarage(10);
		assertThat(unBien.getTailleGarage(), is(10));
	}

	public void testGarageinf0() {
		try {
			unBien.setTailleGarage(-1);
			fail("valeur surface garage non valide car inferieur a 0");
		} catch (AppliDataException e) {

		}
	}

	public void testVeranda() {
		unBien.setTailleVeranda(20);
		assertThat(unBien.getTailleVeranda(), is(20));
	}

	public void testTailleVeranda() {
		try {
			unBien.setTailleVeranda(-5);
			fail("valeur surface veranda non valide car inferieur a 0");
		} catch (AppliDataException e) {

		}
	}

	public void testAjoutPeriode() {
		unBien.ajouterPeriode(new Periode());
		assertThat(unBien.getPeriodes().size(), is(1));
	}

	public void testAjoutPeriodesNonChevauchante() {
		try {
			Periode periodeOk = new Periode();
			Periode periodeFausse = new Periode();

			periodeOk.setPeriode(new Interval(new DateTime(2012, 1, 1, 0, 0), new DateTime(2012, 12, 31, 0, 0)));
			periodeOk.setPeriode(new Interval(new DateTime(2011, 1, 1, 0, 0), new DateTime(2013, 1, 1, 0, 0)));

			unBien.ajouterPeriode(periodeOk);
			unBien.ajouterPeriode(periodeFausse);

			fail("Les periodes se chevauchent !");
		} catch (AppliDataException e) {
		}
	}

	public void testAjoutPeriodes() {
		ArrayList<Periode> periodes = new ArrayList<Periode>();
		periodes.add(new Periode());
		periodes.add(new Periode());

		unBien.setPeriodes(periodes);
		assertThat(unBien.getPeriodes().size(), is(2));
	}

	public void testUnePeriode() {
		Periode p = new Periode(1);
		unBien.ajouterPeriode(p);
		assertThat(unBien.getPeriode(1).getId(), is(1));
	}

	public void testCalculerPrixPourUnInterval() {
		Periode periode = new Periode(1);
		periode.setPeriode(new Interval(new DateTime(2012, 1, 1, 0, 0), new DateTime(2012, 12, 31, 0, 0)));
		periode.setMontant(85);

		DateTime dateDebutReservation = new DateTime(2012, 1, 15, 0, 0);
		DateTime dateFinReservation = new DateTime(2012, 2, 15, 0, 0);

		unBien.ajouterPeriode(periode);
		Interval interval = new Interval(dateDebutReservation, dateFinReservation);

		assertThat(calc.calculerPrixLocation(unBien, interval), is(periode.getMontant() * (Days.daysBetween(dateDebutReservation.toDateMidnight(), dateFinReservation.toDateMidnight()).getDays())));
	}

	public void testCalculerPrixPourPlusieursIntervales() {
		Periode periode1 = new Periode(1);
		periode1.setPeriode(new Interval(new DateTime(2012, 1, 1, 0, 0), new DateTime(2012, 1, 31, 0, 0)));
		periode1.setMontant(25);

		Periode periode2 = new Periode(2);
		periode2.setPeriode(new Interval(new DateTime(2012, 2, 1, 0, 0), new DateTime(2012, 2, 29, 0, 0)));
		periode2.setMontant(15);

		Periode periode3 = new Periode(3);
		periode3.setPeriode(new Interval(new DateTime(2012, 3, 1, 0, 0), new DateTime(2012, 3, 31, 0, 0)));
		periode3.setMontant(85);

		DateTime dateDebutReservation = new DateTime(2012, 1, 15, 0, 0);
		DateTime dateFinReservation = new DateTime(2012, 3, 15, 0, 0);

		unBien.ajouterPeriode(periode1);
		unBien.ajouterPeriode(periode2);
		unBien.ajouterPeriode(periode3);

		double montant = periode1.getMontant() * 16;
		montant += periode2.getMontant() * 28;
		montant += periode3.getMontant() * 14;

		assertThat(calc.calculerPrixLocation(unBien, new Interval(dateDebutReservation, dateFinReservation)), is(montant));
	}

	public void testType() {
		unBien.setType(Type.Chateau);
		assertThat(unBien.getType(), is(Type.Chateau));
	}

	public void testAjoutLocation() {
		unBien.ajouterLocation(new Location());
		assertThat(unBien.getLocations().size(), is(1));
	}

	public void testAjoutLocationNonChevauchante() {
		try {
			Location locationOk = new Location(new Interval(new DateTime(2012, 1, 1, 0, 0), new DateTime(2012, 12, 31, 0, 0)));
			Location locationNok = new Location(new Interval(new DateTime(2011, 1, 1, 0, 0), new DateTime(2013, 1, 1, 0, 0)));

			unBien.ajouterLocation(locationOk);
			unBien.ajouterLocation(locationNok);

			fail("Les periodes de location se chevauchent !");
		} catch (AppliDataException e) {
		}
	}

	public void testAjoutlocations() {
		ArrayList<Location> loc = new ArrayList<Location>();
		loc.add(new Location());
		loc.add(new Location());

		unBien.setLocations(loc);
		assertThat(unBien.getLocations().size(), is(2));
	}

	public void testUneLocation() {
		Location loc = new Location();
		loc.setId(1);
		unBien.ajouterLocation(loc);
		assertThat(unBien.getLocation(1).getId(), is(1));
	}
}

	
