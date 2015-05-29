package baseDeDonnees;

import personnel.*;

import java.sql.*;
import java.util.ArrayList;

public class BaseLigue extends BaseDeDonnees {
	private CallableStatement requetes;
	private ResultSet resultat;

	/*
	 * le contructeurr baseLigue() fait appel a la methode super() pemettant
	 * d'utiliser les les methodes de la classe mere baseDeDonnees
	 */
	public BaseLigue() {
		super();
	}

	/*
	 * la methode affichageLigue() permet de selctionner toutes les ligues de la
	 * base de données et les affiche dans le tableau. Nous utilisons la
	 * procedure stoquée prepare affichageLigue(). Ici le sortedSet permet de
	 * classer les elements recuperés dans l'ordre.
	 */

	public ArrayList<Ligue> affichageLigue() {
		/* affiche les employe */

		ArrayList<Ligue> liste = new ArrayList<Ligue>();

		/*
		 * la methode connect() permet la connection à la base de données on
		 * hérite de cette méthode depuis la classe BaseDeDonnees
		 */
		connect();

		try {
			/* appel de la procedure stockée */
			requetes = this.connexion.prepareCall("call affichageLigue()");

			if (requetes.execute()) {

				/* Récupération des résultats */

				resultat = requetes.getResultSet();
				while (resultat.next()) {
					liste.add(new Ligue( 
							resultat.getString("prenom_employe"),
							resultat.getString("nom_employe"), 
							resultat.getString("nom_ligue"), 
							resultat.getString("adresse_ligue"), 
							resultat.getInt("id_ligue")));

				}
			}

		} catch (SQLException e) {
			// System.out.println("pb requete");
			e.printStackTrace();
		} finally {
			close();
		}

		return liste;
	}

	/*
	 * modifierLigue() prend en parametre l'identifiant le nom l'adresse 'id et
	 * nom de l'administrateur et permet de faire une modification des donnees
	 * de la ligue dans la base de donnée
	 */
	public void modificationLigue(int id, String nom, String adresse, String nomadmin, String prenomadmin) {
		connect();
		try {
			requetes = this.connexion.prepareCall("call modifierLigue(?,?,?,?,?");

			/* inserion des variables */
			requetes.setInt(1, id);
			requetes.setString(2, nom);
			requetes.setString(3, adresse);
			requetes.setString(4, nomadmin);
			requetes.setString(5, prenomadmin);

			/* execution de la requete */
			requetes.execute();

		} catch (SQLException e) {
			// System.out.println("pb requete");
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void ajouterLigue(String nom, String adresse , String nomadmin, String prenomadmin, int valeurTemporaire) {
		connect();
		try {
			requetes = this.connexion.prepareCall("call ajouterLigue(?,?,?,?,?)");

			/* inserion des variables */
			requetes.setString(1, nom);
			requetes.setString(2, adresse);
			requetes.setString(3, nomadmin);
			requetes.setString(4, prenomadmin);
			requetes.setInt(5, valeurTemporaire);

			/* execution de la requete */
			requetes.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

	}

	
	
}
