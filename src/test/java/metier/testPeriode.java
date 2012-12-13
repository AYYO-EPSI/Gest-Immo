package metier;

import com.gestimmo.metier.exceptions.AppliDataException;
import com.gestimmo.metier.model.Periode;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.joda.time.Interval;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class testPeriode extends TestCase {
	Periode unePeriode;

	public static TestSuite suite() {
		return new TestSuite(testPeriode.class);
	}

	public void setUp() {
		unePeriode = new Periode();
	}

	public void testObjetExisteetPasNul() {
		assertThat(unePeriode, is(allOf(instanceOf(Periode.class), notNullValue(Periode.class))));
	}

	public void testLibelle() {
		unePeriode.setLibelle("Periode1");
		assertThat(unePeriode.getLibelle(), is("Periode1"));
	}

	public void testMontant() {
		unePeriode.setMontant(250.86);
		assertThat(unePeriode.getMontant(), is(250.86));
	}

	public void testPeriodeExiste() {
		Interval p = new Interval(123456, 654321);
		unePeriode.setPeriode(p);
		assertThat(unePeriode.getPeriode(), is(allOf(instanceOf(Interval.class), notNullValue(Interval.class))));
	}

	public void testMontantPositif() {
		try {
			unePeriode.setMontant(-250.86);
			fail("Le montant doit etre positif.");
		} catch (AppliDataException e) {
		}
	}

}
