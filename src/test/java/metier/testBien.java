package metier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.allOf;

import java.util.ArrayList;

import org.hamcrest.core.IsNot;


import com.gestimmo.metier.exceptions.AppliDataException;
import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Periode;

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

	public void testObjetExisteetPasNul() {
		assertThat(unBien, is(allOf(instanceOf(Bien.class),notNullValue(Bien.class))));
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
	
	public void testAjoutPeriode(){
		unBien.ajouterPeriode(new Periode());
		assertThat(unBien.getPeriodes().size(),is(1));
	}
	
	public void testAjoutPeriodes(){
		ArrayList<Periode> periodes = new ArrayList();
		periodes.add(new Periode());
		periodes.add(new Periode());
		
		unBien.ajouterPeriodes(periodes);
		assertThat(unBien.getPeriodes().size(),is(2));
	}
	
	public void testUnePeriode(){
		Periode p = new Periode( 1 );
		unBien.ajouterPeriode( p );
		assertThat(unBien.getPeriode( 1 ).getId(),is( 1 ));
	}
	
	
	
	
}

	