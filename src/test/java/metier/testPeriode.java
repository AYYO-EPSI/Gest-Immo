package metier;

import com.gestimmo.metier.exceptions.AppliDataException;
import com.gestimmo.metier.model.Periode;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.joda.time.DateTime;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


public class testPeriode extends TestCase {
	Periode unePeriode;
	
	public static TestSuite suite() {
		return new TestSuite(testPeriode.class);
	}
	
	public void setUp(){
		unePeriode = new Periode();
	}
	
	public void testObjetExisteetPasNul() {
		assertThat(unePeriode, is(allOf(instanceOf(Periode.class),notNullValue(Periode.class))));
}
	
	public void testLibelle() {
		unePeriode.setLibelle("Periode1");
		assertThat(unePeriode.getLibelle(), is("Periode1"));
	}

	public void testMontant() {
		unePeriode.setMontant(250.86);
		assertThat(unePeriode.getMontant(), is(250.86));
	}

	public void testDateDebut() {
		DateTime date = new DateTime();
		unePeriode.setDateDebut(date);
		assertThat(unePeriode.getDateDebut(), is(date));
	}

	public void testDateFin() {
		DateTime date = new DateTime();
		unePeriode.setDateFin(date);
		assertThat(unePeriode.getDateFin(), is(date));
	}

	public void testMontantPositif() {
		try {
			unePeriode.setMontant(-250.86);
			fail("Le montant doit etre positif.");
		} catch (AppliDataException e) {
		}
	}

	public void testFinAvantDebut() {
		try {
			DateTime dateDebut = new DateTime(2012, 12, 31, 0, 0);
			DateTime dateFin = new DateTime(2012, 10, 31, 0, 0);
			unePeriode.setDateDebut(dateDebut);
			unePeriode.setDateFin(dateFin);
			fail("La date de debut doit etre inferieure a la date de fin");
		} catch (AppliDataException a) {}
	}

	public void testDebutApresFin() {
		try {
			DateTime dateDebut = new DateTime(2012, 12, 31, 0, 0);
			DateTime dateFin = new DateTime(2012, 10, 31, 0, 0);
			unePeriode.setDateFin(dateFin);
			unePeriode.setDateDebut(dateDebut);
			fail("La date de fin doit etre superieure a la date de debut");
		} catch (AppliDataException a) {}
	}

}
