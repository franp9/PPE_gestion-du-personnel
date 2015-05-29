package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import baseDeDonnees.BaseEmploye;

@SuppressWarnings("serial")
public class GestionEmployeIHM extends JFrame {

	private BaseEmploye bdd = new BaseEmploye();
	private JTable tableau = new JTable(new GestionEmployeTABLE());
	private JButton modifier = new JButton("Modifier");
	private JButton retour = new JButton("retour");
	private JButton ajouter = new JButton("ajouter");
	private JLabel erreur = new JLabel("vous n'avez sélectionné aucun employé");
	private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	
	public GestionEmployeIHM() {
		super();
		setTitle("Gestion Employe");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		getContentPane().add(bouton(), BorderLayout.SOUTH);
		getContentPane().add(erreur, BorderLayout.NORTH);
		this.setSize(550,600);//adapte les dimensions de la fenetre en fonction de ses composants
		erreur.setVisible(false);
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

	/* retour() ramene vers le menu principal */

	private JButton retour() {
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new MenuPrincipal();
				fermeture();
			}
		});
		return retour;
	}

	/* le bouton modifier renvoi sur l interface de modification 
	 * des donnees des employes */
	private JButton modifier() {
		modifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				int indice = tableau.getSelectedRow();

				if (indice > -1) {
					int id = (int) tableau.getValueAt(indice, 0);
					String nom = (String) tableau.getValueAt(indice, 1);
					String prenom = (String) tableau.getValueAt(indice, 2);
					String mail = (String) tableau.getValueAt(indice, 3);
					String password = (String) tableau.getValueAt(indice, 4);
					
					
					/*bdd.modifierEmploye() prend en parametre les différents 
					 * éléments de notre tableau que nous souhaitons 
					 * modifier pour mettre a jour les éléments que nous 
					 * souaitons dans le tableau*/
					bdd.modifierEmploye(id, nom, prenom, mail, password);
				
					erreur.setVisible(false);
					
					System.out.println("ok");

				} else
					//erreur.setVisible(true);
					/* JOptionPane permet d'afficher une boite de dialogue alertant 
					 * l'utilisateur sur le fait qu'il n'a dans ce cas pas sélectionné
					 * un employé*/
					JOptionPane.showMessageDialog(frame,"veuillez sélectionner un employé!");
			}
		});
		return modifier;
	}

	private JButton ajouter() {
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AjoutEmploye();
				fermeture();
			}
		});
		return ajouter;
	}

	private void fermeture() {
		this.setVisible(false);
	}

	public static void main(String[] args) {
		new GestionEmployeIHM();
	}

}
