package baseDeDonnees;

import personnel.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class BaseLigue extends BaseDeDonnees {
	private CallableStatement requetes;
	private ResultSet resultat;

		/* le contructeurr baseLigue() fait appel a la 
		 * methode super() pemettant d'utiliser les 
		 * les methodes de la classe mere baseDeDonnees
		 * */
	public BaseLigue() {
		super();
	}

	/*
	 * la methode affichageLigue() permet de selctionner toutes les ligues de la
	 * base de données et les affiche dans le tableau. Nous utilisons la procedure stoquée
	 * prepare affichageLigue(). Ici le sortedSet permet de classer les
	 * elements recuperés dans l'ordre.
	 */

	public SortedSet<Ligue> affichageLigue() {
		/* affiche les employe */

		SortedSet<Ligue> liste = new TreeSet<Ligue>();

		/* la methode connect() permet la connection 
		 * à la base de données on hérite de cette méthode
		 *  depuis la classe BaseDeDonnees*/
		connect();

		try {
			/* appel de la procedure stockée */
			requetes = this.connexion.prepareCall("call affichageLigue()");

			if (requetes.execute()) {

				/* Récupération des résultats */

				resultat = requetes.getResultSet();
				
				while (resultat.next()) {
					liste.add(new Ligue
								(new Employe(new Ligue(resultat
										.getString("nom_ligue"), resultat
										.getString("adresse_ligue"), resultat
										.getInt("id_ligue")), resultat
										.getString("nom_employe"), resultat
										.getString("prenom_employe"), resultat
										.getString("email_employe"), resultat
										.getString("mdp_employe"), resultat
										.getInt("id_employe")),						
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
	 * nom de l'administrateur et permet de faire une modification des donnees de
	 * la ligue dans la base de donnée
	 */
	public void modifierLigue(int id, String nom, String adresse, String administrateur) {
		connect();
		try {
			requetes = this.connexion
					.prepareCall("call modifierLigue(?,?,?,?)");

			/* inserion des variables */
			requetes.setInt(1, id);
			requetes.setString(2, nom);
			requetes.setString(3, adresse);
			requetes.setString(4, administrateur);

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
	 * la methode nomsLigues() permet de vérifier si le nom de la ligue entré
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



}
