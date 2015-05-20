package ihm;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import baseDeDonnees.BaseEmploye;
import personnel.Ligue;

/* On a donc créé une classe héritant de AbstractTableModel
 *  et redéfinissant les méthodes indispensables.getColumnCount()
 *  getColumnCount(),getColumnName et getValueAt()
 *    */

@SuppressWarnings({ "unused", "serial" })
public class GestionLigueTable extends AbstractTableModel {

	private ArrayList<Ligue> ligues = new ArrayList<Ligue>();
	private String[] entetes = { "id", "nom", "adresse" , "administrateur"};
	private BaseEmploye bdd = new BaseEmploye();

	public GestionLigueTable() {
		super();

		/*
		 * pour chaque employe x dans la liste baseAffichagePersonnel on
		 * l'ajoute a la liste personnes a travers la boucle for (Employe x :
		 * bdd.affichageEmploye()){ personnes.add(x); }
		 */
	/*	for (Ligue x : bdd.affichageLigue()) {
			ligues.add(x);
		}*/
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
		return ligues.size();
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
			return ligues.get(rowIndex).getId();
		case 1:
			return ligues.get(rowIndex).getNom();
		case 2:
			return ligues.get(rowIndex).getadresse();
		case 3:
			return ligues.get(rowIndex).getAdministrateur();
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
			Ligue ligue = ligues.get(rowIndex);

			switch (columnIndex) {

			case 1:
				ligue.setNom(aValue.toString());
				break;
			case 2:
				ligue.setadresse(aValue.toString());
				break;
	/*		case 3:
				ligue.setAdministrateur(aValue.toString());
				break;*/
			case 3:
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
