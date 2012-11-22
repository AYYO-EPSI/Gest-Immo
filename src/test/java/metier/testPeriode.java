package metier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.joda.time.DateTime;
import com.gestimmo.metier.model.Periode;
import static org.hamcrest.CoreMatchers.allOf;

import junit.framework.TestCase;
import junit.framework.TestSuite;


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

}
