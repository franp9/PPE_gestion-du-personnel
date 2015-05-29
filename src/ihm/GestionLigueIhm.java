package ihm;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import baseDeDonnees.BaseLigue;

@SuppressWarnings({ "serial", "unused" })
public class GestionLigueIhm extends JFrame {

	private BaseLigue bdd = new BaseLigue();
	private JTable tableau = new JTable(new GestionLigueTable());
	private JButton modifier = new JButton("Modifier");
	private JButton retour = new JButton("retour");
	private JButton ajouter = new JButton("ajouter");
	private JFrame frame = new JFrame("JOptionPane showMessageDialog example");
	private JOptionPane erreur = new JOptionPane();
	private JOptionPane validation = new JOptionPane();

	public GestionLigueIhm() {
		super();
		setTitle("Gestion Ligue");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(new JScrollPane(tableau), BorderLayout.CENTER);
		getContentPane().add(bouton(), BorderLayout.SOUTH);
		this.setSize(500, 600);// adapte les dimensions de la fenetre en
								// fonction de ses composants
		this.setLocationRelativeTo(null);

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

	/* JButton modifier() modifie les donnees des ligues */
	private JButton modifier() {
		modifier.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent event) {

				int indice = tableau.getSelectedRow();

				if (indice > -1) {
					int id = (int) tableau.getValueAt(indice, 0);
					String nom = (String) tableau.getValueAt(indice, 1);
					String adresse = (String) tableau.getValueAt(indice, 2);
					String nomadmin = (String) tableau.getValueAt(indice, 3);
					String prenomadmin = (String) tableau.getValueAt(indice, 4);

					int option = validation
							.showConfirmDialog(
									null,
									"vous êtes sur le point de d'effectuer une modification!",
									"verification!", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {
						bdd.modificationLigue(id, nom, adresse, nomadmin,
								prenomadmin);
						/*
						 * try { bdd.modificationLigue(id, nom, adresse,
						 * nomadmin, prenomadmin); } catch (SQLException e) {
						 * erreur.showMessageDialog(null, "Message d'erreur",
						 * "Erreur", JOptionPane.ERROR_MESSAGE); }
						 */
					}

					System.out.println(id);
					System.out.println(nom);
					System.out.println(adresse);
					System.out.println(nomadmin);
					System.out.println(prenomadmin);
				} else {
					/*
					 * JOptionPane permet d'afficher une boite de dialogue
					 * alertant l'utilisateur sur le fait qu'il n'a dans ce cas
					 * pas sélectionné un employé
					 */
					JOptionPane.showMessageDialog(frame,
							"veuillez sélectionner une ligue!");
				}
			}
		});
		return modifier;
	}

	/*
	 * JButton ajouter() nous renvoie vers l interface d'ajout d'ujne ligue dans
	 * la base de donnees
	 */

	private JButton ajouter() {
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new AjoutLigue();
				fermeture();
			}
		});
		return ajouter;
	}

	/*
	 * fermeture() gere la fermeture de l 'interface en cas de redirection vers
	 * une autre interface
	 */
	private void fermeture() {
		this.setVisible(false);
	}

	public static void main(String[] args) {

		new GestionLigueIhm();

	}

}
