package baseDeDonnees;

import personnel.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;


public class BaseEmploye extends BaseDeDonnees {
	private CallableStatement requetes;
	private ResultSet resultat;

	public BaseEmploye() {

		super();
	}

	/*
	 * connexion(String mdp) prend en parametre le mot de passe que l
	 * utilisateur a entré puis verifie si celui ci correspond a celui de la
	 * base de donnéee si c'est un bon mot de passe il renvoie une valeur vrai
	 * permettant l'acces au menu principal
	 */
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		BaseEmploye bdd = new BaseEmploye();	
	}

	public boolean connexion(String mdp) {
		super.connect();
		int test = 0;

		try {
			/* Appel de la procédure stockée */
			requetes = connexion.prepareCall("call connexion(?)");

			/* Attribution des variables */
			requetes.setString(1, mdp);

			/* requetes.Execute() Exécute la requète
			 * pour pouvoir faire nos différentes vérification dans
			 * la base de données comme nous le souhaitons */
			if (requetes.execute()) {

				/* Récupération des résultats avec la méthode 
				 * requetes.getResultSet() */
				resultat = requetes.getResultSet();

				/* Traitement, */
				while (resultat.next()) {
					test = resultat.getInt("verif");
				}
			}

		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("pb requete");
		} finally {
			close();
		}

		return test == 1;
	}

	/*
	 * la methode affichageEmploye() permet de selctionner tous es employe de la
	 * base de données et les affiche dans le tableau. Nous utilisons la requete
	 * prepare affichageEmploye(). Ici le sortedSet permet de classer les
	 * elements recuperés dans l'ordre.
	 */

	public SortedSet<Employe> affichageEmploye() {
		/* affiche les employe */

		SortedSet<Employe> liste = new TreeSet<Employe>();
		connect();

		try {
			/* appel de la procedure stockée */
			requetes = this.connexion.prepareCall("call affichageEmploye()");

			/* Exécution de la requète 1 */
			if (requetes.execute()) {

				/* Récupération des résultats */
				resultat = requetes.getResultSet();

				/* Traitement */
				while (resultat.next()) {
					liste.add(new Employe(new Ligue(resultat
							.getString("nom_ligue"), resultat
							.getString("adresse_ligue"), resultat
							.getInt("id_ligue")), resultat
							.getString("nom_employe"), resultat
							.getString("prenom_employe"), resultat
							.getString("email_employe"), resultat
							.getString("mdp_employe"), resultat
							.getInt("id_employe")));
							
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
;
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
			String sql = "SELECT nom_ligue FROM `ligue`";

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


	public void ajoutEmploye(int idligue,String nom, String prenom,String mail,
			String password, String adresse) {
		connect();
		try {
			requetes = this.connexion
 					.prepareCall("call ajoutEmploye(?,?,?,?,?,?)");

			/* inserion des variables */
			requetes.setInt(1, idligue);
			requetes.setString(2, nom);
			requetes.setString(3, prenom);
			requetes.setString(4, mail);
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
