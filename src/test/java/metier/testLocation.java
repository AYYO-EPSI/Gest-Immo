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

public class testLocation extends TestCase {

	 Location uneLocation;

	public static TestSuite suite() {
		return new TestSuite(testLocation.class);
	}

	public void setUp() {
		uneLocation = new Location();
	}

	public void testIdNonNul() {
		uneLocation.setId(1);
		assertThat(uneLocation.getId(), is(1));
	}

	public void testPeriodeExiste() {
		Interval p = new Interval(123456,654321);
		uneLocation.setPeriode(p);
		assertThat(uneLocation.getPeriode(), is(allOf(instanceOf(Interval.class), notNullValue(Interval.class))));
	}
}

	
