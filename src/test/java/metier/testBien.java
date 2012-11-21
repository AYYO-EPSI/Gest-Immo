package metier;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import com.gestimmo.metier.exceptions.AppliDataException;
import com.gestimmo.metier.model.Bien;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class testBien extends TestCase {
	 Bien unBien;

	public static TestSuite suite() {
		return new TestSuite(testBien.class);
	}

	public void setUp(){
		unBien = Bien.CabaneAuFondDuJardin;
	}

	public void testObjetExiste() {
		assertNotNull(unBien);
	}
	
	public void testSurface (){
	  unBien.setSurface(40.00);
	  assertThat(unBien.getSurface(), is(40.00));
	}
	
	public void testEnergie(){
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
	
	public void testAdresse(){
		unBien.setAdresse("adresse");
		assertThat(unBien.getAdresse(), is("adresse"));
	}
	
	public void testCodePostale(){
		unBien.setCodePostale("64600");
		assertThat(unBien.getCodePostale(), is("64600"));
	}
	
	public void testVille(){
		unBien.setVille("AngletCityBitch");
		assertThat(unBien.getVille(), is("AngletCityBitch"));
	}
	
	public void testNbPieces(){
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
		unBien.setGarage(10);
		assertThat(unBien.getGarage(), is(10));
	}
	
	public void testVeranda() {
		unBien.setVeranda(20);
		assertThat(unBien.getVeranda(),is(20));
	}
	public void testTypeBien(){
		assertNotNull(unBien.getType());
	}
	
	
}

	