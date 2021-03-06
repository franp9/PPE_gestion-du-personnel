package baseDeDonnees;

import personnel.*;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class BaseLigue extends BaseDeDonnees {
	private CallableStatement requetes;
	private ResultSet resultat;
	private JOptionPane erreur = new JOptionPane();

	/*
	 * le contructeurr baseLigue() fait appel a la methode super() pemettant
	 * d'utiliser les les methodes de la classe mere baseDeDonnees
	 */
	public BaseLigue() {
		super();
	}

	/*
	 * la methode affichageLigue() permet de selctionner toutes les ligues de la
	 * base de donn�es et les affiche dans le tableau. Nous utilisons la
	 * procedure stoqu�e prepare affichageLigue(). Ici le sortedSet permet de
	 * classer les elements recuper�s dans l'ordre.
	 */

	public ArrayList<Ligue> affichageLigue() {
		/* affiche les employe */

		ArrayList<Ligue> liste = new ArrayList<Ligue>();

		/*
		 * la methode connect() permet la connection � la base de donn�es on
		 * h�rite de cette m�thode depuis la classe BaseDeDonnees
		 */
		connect();

		try {
			/* appel de la procedure stock�e */
			requetes = this.connexion.prepareCall("call affichageLigue()");

			if (requetes.execute()) {

				/* R�cup�ration des r�sultats */

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
	 * de la ligue dans la base de donn�e
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
			System.out.println("pb requete");
			//e.printStackTrace();
			erreur.showMessageDialog(null, "D�sol�, les modifications sur les noms et prenoms  "
											+ "se font dans gesttion des employes!",
					  "Erreur", JOptionPane.ERROR_MESSAGE);
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
