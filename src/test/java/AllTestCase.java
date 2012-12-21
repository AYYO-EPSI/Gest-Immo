import junit.framework.TestCase;
import junit.framework.TestSuite;
import metier.testBien;
import metier.testLocation;
import metier.testPeriode;
import metier.testUtilisateur;

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
		suite.addTest(testUtilisateur.suite());
		return suite;
	}

	public static void main(final String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
