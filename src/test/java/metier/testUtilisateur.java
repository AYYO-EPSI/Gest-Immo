package metier;

import com.gestimmo.metier.model.Bien;
import com.gestimmo.metier.model.Utilisateur;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class testUtilisateur extends TestCase {
	
	Utilisateur unUtilisateur ;
	
	
	public static TestSuite suite() {
		return new TestSuite(testUtilisateur.class);
	}
	
	public void setUp() {
		unUtilisateur = new Utilisateur();
		
	}
	
	public void testId() {
		unUtilisateur.setId(1);
		assertThat(unUtilisateur.getId(),is(1));
	}
	
	public void testBiensUtilisateur(){
		unUtilisateur.ajouterBien(new Bien());
		assertThat(unUtilisateur.getBiens().size(), is(1));
	}

}
