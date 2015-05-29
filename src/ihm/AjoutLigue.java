package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import baseDeDonnees.BaseEmploye;
import baseDeDonnees.BaseLigue;

@SuppressWarnings({ "serial", "unused" })
public class AjoutLigue extends JFrame {

	private BaseLigue bdd = new BaseLigue();
	private JOptionPane validation = new JOptionPane();
	private JOptionPane erreur = new JOptionPane();
	private JFrame bravo = new JFrame("JOptionPane showMessageDialog example");

	/* ---------------- les labels ------------------------------- */
	private JLabel nomLigue = new JLabel("Nom de la ligue : ");
	private JLabel nomAdmin = new JLabel("Nom de l\'administrateur");
	private JLabel prenomAdmin = new JLabel("prenom de l'admnistrateur");
	private JLabel adresse = new JLabel("Adresse de la ligue : ");

	/*----------------les textfield-------------------------------*/
	private JTextField textnomligue = new JTextField(18);
	private JTextField textadresse = new JTextField(18);
	private JTextField textnomAdmin = new JTextField(18);
	private JTextField tprenomAdmin = new JTextField(18);

	public AjoutLigue() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("Menu d\'ajout des ligues");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(affichage());
		this.pack();
	}

	/*
	 * affichage() est un assemblage de tous les panels dans lesquels sont
	 * disposés les composants selon leurs natures, label, textfield et bouton,
	 * ici l'on fait une mise en commun et on les dispose dans l'interface
	 */

	private JPanel affichage() {
		JPanel menu = new JPanel();
		getInsets();
		menu.setLayout(new BorderLayout(2, 5));
		add(label(), BorderLayout.WEST);
		add(texte(), BorderLayout.EAST);
		add(bouton(), BorderLayout.SOUTH);
		return menu;
	}

	/*
	 * la methode label() permet d'ordonner le positonnement des labels dans
	 * l'interface graphique
	 */
	private JPanel label() {
		JPanel position = new JPanel();
		JPanel positionLabelLigue = new JPanel();
		JPanel positionLabelnomadmin = new JPanel();
		JPanel positionLabelprenomadmin = new JPanel();
		JPanel positionLabeladresse = new JPanel();

		// On définit le layout en lui indiquant qu'il travaillera en ligne
		positionLabelLigue.setLayout(new BoxLayout(positionLabelLigue,
				BoxLayout.X_AXIS));
		positionLabelLigue.add(nomLigue);
		positionLabeladresse.setLayout(new BoxLayout(positionLabeladresse,
				BoxLayout.X_AXIS));
		positionLabeladresse.add(adresse);
		positionLabelnomadmin.setLayout(new BoxLayout(positionLabelnomadmin,
				BoxLayout.X_AXIS));
		positionLabelnomadmin.add(nomAdmin);
		positionLabelprenomadmin.setLayout(new BoxLayout(
				positionLabelprenomadmin, BoxLayout.X_AXIS));
		positionLabelprenomadmin.add(prenomAdmin);

		/*
		 * positionnement en colonne des lignes précédemment crées grace a
		 * position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS))
		 */
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(nomLigue);
		/*
		 * la ligne suivante position.add(Box.createRigidArea(new
		 * Dimension(10,5))) permet de créer un espace entre les composants du
		 * panel adresse et nom administrateur et le nom de la ligue
		 */
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(adresse);
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(nomAdmin);
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(prenomAdmin);

		return position;
	}

	/*
	 * la methode texte() permet de positionner les textfields dans notre
	 * inteerface graphique
	 */
	private JPanel texte() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		JPanel menu3 = new JPanel();
		JPanel menu4 = new JPanel();

		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(textnomligue);
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(textadresse);
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
		menu3.add(textnomAdmin);
		menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
		menu4.add(tprenomAdmin);

		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(menu1);
		position.add(menu2);
		position.add(menu3);
		position.add(menu4);

		return position;
	}

	private JPanel bouton() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		// On définit le layout en lui indiquant qu'il travaillera en ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(ajouter());
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(retour());

		position.setLayout(new BoxLayout(position, BoxLayout.X_AXIS));
		/*
		 * setborderlyaout permet de positionner le layout dans son conteneur le
		 * premier chiffre est sa distance avec la bordure superieure le second
		 * est sa distance selon la bordure gauche du conteneur le dernier
		 * chiffre sa position ou distance de la bordure droite du conteneur
		 */
		position.setBorder(BorderFactory.createEmptyBorder(25, 125, 0, 0));
		position.add(menu1);
		/* la ligne suivante permet de créer un espace entre les composants */
		position.add(Box.createRigidArea(new Dimension(5, 0)));
		position.add(menu2);

		return position;
	}

	private JButton retour() {
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new GestionLigueIhm();
				fermeture();
			}
		});
		return retour;
	}

	/*-----fonction du bouton supprimer permettant la suppression de l'mployé dans la base de données*/
	private JButton ajouter() {
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int idTemporaire = 0;

				/*
				 * lorsque l'on clique sur le bouton modifier, la condition
				 * textnomligue.getText().equals("")) permet de verifier si le
				 * champ est vide on fait cette verification pour tous les
				 * champs et le message d'erreur est renvoyé a l'utiisateur
				 * grace à JOptionPane.showMessageDialog(erreur,
				 * "veuillez remplir tous les champs!")
				 * 
				 * option = validation.showConfirmDialog(null,
				 * "vous êtes sur le ppoint de valider votre modification!",
				 * "verification!", JOptionPane.YES_NO_OPTION,
				 * JOptionPane.QUESTION_MESSAGE); permet d'informer par une
				 * boide de dialogue l'utilisateur qu'il ajoute des donnees et
				 * lui permet de faire un choix
				 * 
				 * option == JOptionPane.OK_OPTION permet de capturer la reponse
				 * ok de l'utilisateur
				 * 
				 * bdd.ajouterLigue(textnomligue.getText(),
				 * textadresse.getText(), textnomAdmin.getText(),
				 * tprenomAdmin.getText(),idTemporaire); permet d'envoyer les
				 * infos saisies à la base de données pour traitement
				 * d'informations
				 */

				if ((textnomligue.getText().equals(""))
						|| textadresse.getText().equals("")
						|| textnomAdmin.getText().equals("")
						|| tprenomAdmin.getText().equals("")) {
					JOptionPane.showMessageDialog(erreur,
							"veuillez remplir tous les champs!");
				} else {
					@SuppressWarnings("static-access")
					int option = validation
							.showConfirmDialog(
									null,
									"vous êtes sur le ppoint de valider votre modification!",
									"verification!", JOptionPane.YES_NO_OPTION,
									JOptionPane.QUESTION_MESSAGE);
					if (option == JOptionPane.OK_OPTION) {

						bdd.ajouterLigue(textnomligue.getText(),
								textadresse.getText(), textnomAdmin.getText(),
								tprenomAdmin.getText(), idTemporaire);
						JOptionPane.showMessageDialog(bravo,
								"félicitation vous venez d'ajouter une ligue!");
						fermeture();
						new GestionLigueIhm();
					}
				}
			}
		});
		return ajouter;
	}

	public Insets getInsets() {
		return new Insets(50, 50, 50, 50);
	}

	private void fermeture() {
		this.setVisible(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AjoutLigue();
	}

}
