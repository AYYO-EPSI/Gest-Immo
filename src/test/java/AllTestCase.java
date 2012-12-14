import junit.framework.TestCase;
import junit.framework.TestSuite;
import metier.*;

public final class AllTestCase extends TestCase {

	public AllTestCase() {
		super();
	}

	public AllTestCase(final String s) {
		super(s);
	}

	public static TestSuite suite() {
		final TestSuite suite = new TestSuite();
		suite.addTest(testBien.suite());
		suite.addTest(testPeriode.suite());
		suite.addTest(testLocation.suite());
		return suite;
	}

	public static void main(final String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
