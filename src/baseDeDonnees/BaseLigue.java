package baseDeDonnees;

import personnel.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class BaseLigue extends BaseDeDonnees {
	private CallableStatement requetes;
	private ResultSet resultat;

	public BaseLigue() {
		super();
	}

	/*
	 * la methode affichageLigue() permet de selctionner toutes les ligues de la
	 * base de données et les affiche dans le tableau. Nous utilisons la requete
	 * prepare affichageLigue(). Ici le sortedSet permet de classer les
	 * elements recuperés dans l'ordre.
	 */

	public SortedSet<Ligue> affichageLigue() {
		/* affiche les employe */

		SortedSet<Ligue> liste = new TreeSet<Ligue>();

		connect();

		try {
			/* appel de la procedure stockée */
			requetes = this.connexion.prepareCall("call affichageEmploye()");

			/* Exécution de la requète 1 */

			if (requetes.execute()) {

				/* Récupération des résultats */

				resultat = requetes.getResultSet();

				/* Traitement */

		/*		while (resultat.next()) {
					liste.add(
							resultat.getString("nom_employe"),
							resultat.getString("prenom_employe"),
							resultat.getInt("id_employe"));
				}*/
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
	 * modifierEmploye() prend en parametre l'identifiant le nom le prenom le
	 * mail et la password * et permet de faire une modification des donnees de
	 * l'employe dans la base de donnée
	 */
	public void modifierEmploye(int id, String nom, String prenom, String mail,
			String password) {
		connect();
		try {
			requetes = this.connexion
					.prepareCall("call modifierEmploye(?,?,?,?,?)");

			/* inserion des variables */
			requetes.setInt(1, id);
			requetes.setString(2, nom);
			requetes.setString(3, prenom);
			requetes.setString(4, mail);
			requetes.setString(5, password);

			/* execution de la requete */
			requetes.execute();

		} catch (SQLException e) {
			// System.out.println("pb requete");
			e.printStackTrace();
		} finally {
			close();
		}
	}

	/*
	 * la methode nomsLigues() perùmet de vérifier si le nom de la ligue entré
	 * dans le le tableau est correcte permettant ainsi d'évité d' ajouter un
	 * nom de ligue qui n existe pas dans la base de données
	 */
	public ArrayList<String> nomsLigues() {
		/* affiche les employe */

		ArrayList<String> liste = new ArrayList<String>();

		connect();

		try {
			String sql = "SELECT nom_ligue FROM `gestion_ligue`";

			PreparedStatement prepare = connexion.prepareStatement(sql);

			prepare.execute();

			resultat = prepare.getResultSet();

			while (resultat.next())
				liste.add(new String(resultat.getString("nom_ligue")));

		} catch (SQLException e) {
			// System.out.println("pb requete");
			e.printStackTrace();
		} finally {
			close();
		}

		return liste;
	}


	public void ajoutEmploye(int idligue,String mail,String nom, String prenom,
			String password, String adresse) {
		connect();
		try {
			requetes = this.connexion
 					.prepareCall("call ajoutEmploye(?,?,?,?,?,?)");

			/* inserion des variables */
			requetes.setInt(1, idligue);
			requetes.setString(2, mail);
			requetes.setString(3, nom);
			requetes.setString(4, prenom);
			requetes.setString(5, password);
			requetes.setString(6, adresse);
			

			/* execution de la requete */
			requetes.execute();

		} catch (SQLException e) {
			// System.out.println("pb requete");
			e.printStackTrace();
		} finally {
			close();
		}
	}
	



}
