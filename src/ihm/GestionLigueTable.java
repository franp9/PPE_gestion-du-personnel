package ihm;

import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import baseDeDonnees.BaseEmploye;
import baseDeDonnees.BaseLigue;
import personnel.Employe;
import personnel.Ligue;

/* On a donc cr�� une classe h�ritant de AbstractTableModel
 *  et red�finissant les m�thodes indispensables.getColumnCount()
 *  getColumnCount(),getColumnName et getValueAt()
 *    */

@SuppressWarnings({ "unused", "serial" })
public class GestionLigueTable extends AbstractTableModel {

	private ArrayList<Ligue> ligues = new ArrayList<Ligue>();
	private String[] entetes = { "id", "nom", "adresse" , "nom administrateur" , "prenom admmnistrateur",};
	private BaseLigue bdd = new BaseLigue();

	public GestionLigueTable() {
		super();
		/*
		 * pour chaque ligue x dans la liste baseAffichage() on
		 * l'ajoute la liste des ligues a travers la boucle for (ligue x :
		 * bdd.affichagListes()){ listes.add(x); }
		 * ainsi cette boucle for sert a remplir le tableau
		 */
		for (Ligue x : bdd.affichageLigue()) {
			ligues.add(x);
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
		return ligues.size();
	}

	/*
	 * la methode getColumName DOIT retourner l'entete du tableau
	 */
	public String getColumnName(int columnIndex) {
		return entetes[columnIndex];
	}

	/*
	 * doit retourner la valeur du tableau � la colonne et la ligne sp�cifi�es
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
			return ligues.get(rowIndex).getnomAdministrateur();
		case 4:
			return ligues.get(rowIndex).getprenomAdministrateur();
		}

		return null;
	}

	/*
	 * is celleditable est une methode prenant en parametre les lignes et
	 * colonnes de notre tableau permettant la modification des donn�es. A true
	 * ce booleen rend toutes les tables editable
	 */

	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return true;

	}

	/*
	 * la methode setvalue permet de prendre en compte les modifications, elle
	 * sera automatiquement appel� lorsque la modification sera valid�
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
       		case 3:
				ligue.setnomAdministrateur(aValue.toString());
				break;
			case 4:
				ligue.setprenomAdministrateur(aValue.toString());
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
