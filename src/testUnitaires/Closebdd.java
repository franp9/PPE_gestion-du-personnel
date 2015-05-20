package testUnitaires;

import org.junit.Assert;
import org.junit.Test;

import baseDeDonnees.BaseDeDonneesLeo;

/* ICI nous testerons la fermeture de la base de données 
 * nous utiliserons junit4 */

public class Closebdd {
	
	@Test
	public void testClose(){
		BaseDeDonneesLeo base = new BaseDeDonneesLeo();
	    base.close();
		Assert.fail();
	}
}
