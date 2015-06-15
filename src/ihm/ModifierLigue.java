package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import baseDeDonnees.BaseLigue;

@SuppressWarnings("serial")
public class ModifierLigue extends JFrame {

	@SuppressWarnings("unused")
	private BaseLigue bdd = new BaseLigue();
	private JOptionPane validation = new JOptionPane();
	private JOptionPane erreur = new JOptionPane();
	/* ---------------- les labels ------------------------------- */
	private JLabel nomLigue = new JLabel("Nom de la ligue : ");
	private JLabel nomAdmin = new JLabel("Nom de l\'administrateur");
	private JLabel prenomAdmin = new JLabel("prenom de l'admnistrateur");
	private JLabel adresse = new JLabel("Adresse de la ligue : ");

	/*----------------les textfield-------------------------------*/
	private JTextField tnomligue = new JTextField(15);
	private JTextField tadresse = new JTextField(15);
	private JTextField tnomAdmin = new JTextField(15);
	private JTextField tprenomAdmin = new JTextField(15);

	public ModifierLigue() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("Modification des ligues");
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(affichage());
		this.pack();
	}

	private JPanel affichage() {
		JPanel menu = new JPanel();
		getInsets();
		menu.setLayout(new BorderLayout(2, 5));
		add(label(), BorderLayout.WEST);
		add(texte(), BorderLayout.EAST);
		add(bouton(), BorderLayout.SOUTH);
		return menu;
	}

	/* positionnement des labels */
	private JPanel label() {
		JPanel position = new JPanel();
		JPanel positionLabelLigue = new JPanel();
		JPanel positionLabeladmin = new JPanel();
		JPanel positionLabeladresse = new JPanel();

		// On définit le layout en lui indiquant qu'il travaillera en ligne
		positionLabelLigue.setLayout(new BoxLayout(positionLabelLigue,
				BoxLayout.X_AXIS));
		positionLabelLigue.add(nomLigue);
		positionLabeladresse.setLayout(new BoxLayout(positionLabeladresse,
				BoxLayout.X_AXIS));
		positionLabeladresse.add(adresse);
		positionLabeladmin.setLayout(new BoxLayout(positionLabeladmin,
				BoxLayout.X_AXIS));
		positionLabeladmin.add(nomAdmin);
		positionLabeladmin.setLayout(new BoxLayout(positionLabeladmin,
				BoxLayout.X_AXIS));
		positionLabeladmin.add(prenomAdmin);

		/*
		 * la ligne suivante position.add(Box.createRigidArea(new
		 * Dimension(10,5))) permet de créer un espace entre les composants du
		 * panel adresse et nom administrateur et le nom de la ligue On
		 * positionne maintenant ces trois lignes en colonne
		 */
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(nomLigue);
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(adresse);
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(nomAdmin);
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(prenomAdmin);

		return position;
	}

	/* disposition des textfields */
	private JPanel texte() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		JPanel menu3 = new JPanel();
		JPanel menu4 = new JPanel();

		/* disposition en ligne */
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(tnomligue);
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(tadresse);
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
		menu3.add(tnomAdmin);
		menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
		menu4.add(tprenomAdmin);

		/* position des lignes en colonne */
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
		menu1.add(valider());
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(retour());

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

	private JButton valider() {
		JButton valider = new JButton("Ajouter");
		valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (tnomligue.getText().equals("")) {
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
						// bdd.modifierLigue(,tnomligue.getText(),tadresse.getText(),tnomAdmin.getText(),tprenomAdmin.getText());
						fermeture();
						new GestionLigueIhm();
					}
				}

			}
		});
		return valider;
	}

	private void fermeture() {
		this.setVisible(false);
	}

	public static void main(String[] args) {
		new ModifierLigue();
	}

}
