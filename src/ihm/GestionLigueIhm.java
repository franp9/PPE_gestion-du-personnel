package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import baseDeDonnees.BaseLigue;

@SuppressWarnings("serial")
public class GestionLigueIhm extends JFrame {

	private BaseLigue bdd = new BaseLigue();
	private JTable tableau = new JTable(new GestionLigueTable());
	private JButton modifier = new JButton("Modifier");
	private JButton retour = new JButton("retour");
	private JButton ajouter = new JButton("ajouter");
	private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	
	public GestionLigueIhm() {
		super();
		setTitle("Gestion Ligue");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		getContentPane().add(bouton(), BorderLayout.SOUTH);
		this.setSize(500,600);//adapte les dimensions de la fenetre en fonction de ses composants
		this.setLocationRelativeTo(null);
		//pack();
	}

	/*
	 * la methode bouton() de type panel organise la disposition des boutons sur
	 * une ligne en utilisant un flowlayout
	 */

	private JPanel bouton() {
		JPanel menu = new JPanel();
		setLayout(new FlowLayout());
		add(ajouter());
		add(retour());
		add(modifier());
		return menu;
	}

	/* JButton retour() ramene vers le menu principal */

	private JButton retour() {
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new MenuPrincipal();
				fermeture();
			}
		});
		return retour;
	}

	/*  JButton modifier() modifie les  donnees des ligues */
	private JButton modifier() {
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				int indice = tableau.getSelectedRow();

				if (indice > -1) {
					int id = (int) tableau.getValueAt(indice, 0);
					String nom = (String) tableau.getValueAt(indice, 1);
					String adresse = (String) tableau.getValueAt(indice, 2);
					String administrateur = (String) tableau.getValueAt(indice, 3);
				
					bdd.modifierLigue(id, nom, adresse, administrateur);

				} else
					//erreur.setVisible(true);
					/* JOptionPane permet d'afficher une boite de dialogue alertant 
					 * l'utilisateur sur le fait qu'il n'a dans ce cas pas sélectionné
					 * un employé*/
					JOptionPane.showMessageDialog(frame,"veuillez sélectionner une ligue!");
			}
		});
		return modifier;
	}
	
	/* JButton ajouter() nous renvoie vers l interface d'ajout d'ujne ligue 
	 * dans la base de donnees */

	private JButton ajouter() {
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AjoutLigue();
				fermeture();
			}
		});
		return ajouter;
	}

		/* fermeture() gere la fermeture de l 'interface en cas de redirection
		 * vers une autre interface */
	private void fermeture() {
		this.setVisible(false);
	}

	public static void main(String[] args) {

		new GestionLigueIhm();

	}

}
