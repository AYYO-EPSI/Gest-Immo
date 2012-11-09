import junit.framework.TestCase;
import junit.framework.TestSuite;
import metier.testBien;

public final class testAll extends TestCase {

	public testAll() {
		super();
	}

	public testAll(final String s) {
		super(s);
	}

	public static TestSuite suite() {
		final TestSuite suite = new TestSuite();

		suite.addTest(testBien.suite());

		return suite;
	}

	public static void main(final String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
