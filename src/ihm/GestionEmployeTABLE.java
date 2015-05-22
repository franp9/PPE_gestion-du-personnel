package ihm;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import baseDeDonnees.BaseEmploye;
import personnel.Employe;

/* On a donc créé une classe héritant de AbstractTableModel
 *  et redéfinissant les méthodes indispensables.getColumnCount()
 *  getColumnCount(),getColumnName et getValueAt()
 *    */

@SuppressWarnings({ "unused", "serial" })
public class GestionEmployeTABLE extends AbstractTableModel {

	private ArrayList<Employe> personnes = new ArrayList<Employe>();
	
	/* Le tableau entetes contient tous les intitulés 
	 * compris dans l'entete de notre tableau contenant
	 * toutes les données */
	private String[] entetes = { "id", "nom", "Prenom", "mail", "Password",
			"Ligue"};
	private BaseEmploye bdd = new BaseEmploye();

	public GestionEmployeTABLE() {
		super();

		/*
		 * pour chaque employe x dans la liste baseAffichagePersonnel on
		 * l'ajoute a la liste personnes a travers la boucle for (Employe x :
		 * bdd.affichageEmploye()){ personnes.add(x); }
		 */
		for (Employe x : bdd.affichageEmploye()) {
			personnes.add(x);
		}
	}

	@Override
	/*
	 * la methode getColumnCount return le nombre de colonne DU tableau
	 */
	public int getColumnCount() {
		return entetes.length;
	}

	/*
	 * la methode getRowCount() return le nombre de lignes DU tableau
	 */
	@Override
	public int getRowCount() {
		return personnes.size();
	}

	/*
	 * la methode getColumName DOIT retourner l'entete du tableau
	 */
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/*
	 * doit retourner la valeur du tableau à la colonne et la ligne spécifiées
	 */
	@Override
	public Object getValueAt(int rowIndex, int ColumnIndex) {
		switch (ColumnIndex) {
		case 0:
			return personnes.get(rowIndex).getId();
		case 1:
			return personnes.get(rowIndex).getNom();
		case 2:
			return personnes.get(rowIndex).getPrenom();
		case 3:
			return personnes.get(rowIndex).getMail();
		case 4:
			return personnes.get(rowIndex).getPassword();
		case 5:
			return personnes.get(rowIndex).getLigue();
		}

		return null;
	}

	/*
	 * is celleditable est une methode prenant en parametre les lignes et
	 * colonnes de notre tableau permettant la modification des données. A true
	 * ce booleen rend toutes les tables editable
	 */

	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;

	}

	/*
	 * la methode setvalue permet de prendre en compte les modifications, elle
	 * sera automatiquement appelé lorsque la modification sera validé
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		if (aValue != null) {
			Employe employe = personnes.get(rowIndex);

			switch (columnIndex) {

			case 1:
				employe.setNom(aValue.toString());
				break;
			case 2:
				employe.setPrenom(aValue.toString());
				break;
			case 3:
				employe.setMail(aValue.toString());
				break;
			case 4:
				employe.setPassword(aValue.toString());
				break;
			case 5:
				if (bdd.nomsLigues().contains(aValue.toString())) {
					System.out.println("yeah");
				} else {
					// APPEL ERREUR : ligue non existante
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
