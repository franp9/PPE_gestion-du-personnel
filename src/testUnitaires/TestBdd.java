package testUnitaires;
import baseDeDonnees.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestBdd {
	
	@Test
	public void TestConnexion(){
		String mdp = "erreur";
		
		BaseEmploye bdd =  new BaseEmploye();
		
		assertFalse(bdd.connexion(mdp));
		
		mdp ="toor";
		
		assertTrue(bdd.connexion(mdp));
		
		
	}
}
