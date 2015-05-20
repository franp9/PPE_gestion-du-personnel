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

public class AjoutEmploye extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BaseEmploye bdd = new BaseEmploye();
	private JFrame erreur = new JFrame("JOptionPane showMessageDialog example");

	/* ----------- les labels des champs ------------------- */
	private JLabel lepassword = new JLabel("Mot de passe");
	private JLabel lemail = new JLabel("Mail");
	private JLabel leprenom = new JLabel("Prenom");
	private JLabel lenom = new JLabel("Nom");	
	private JLabel laligue = new JLabel("Nom Ligue");
	private JLabel lecode = new JLabel("Type employe");
	private JLabel ladresse = new JLabel("adresse employe");
	
	private JLabel message = new JLabel("vous venez d'ajouter un administrateur!");	
	private JLabel erreurMail = new JLabel("le mail saisie n'est pas bon!");
	private JLabel erreurNomLigue = new JLabel("le nom de la ligue n'est pas bon!");
	/*----------------les textfield-------------------------------*/
	private JTextField tpass = new JTextField(25);
	private JTextField tmail = new JTextField(25);
	private JTextField tprenom = new JTextField(25);
	private JTextField tnom = new JTextField(25);
	private JTextField tcode = new JTextField(25);
	private JTextField tligue = new JTextField(25);
	private JTextField tadresse = new JTextField(25);
	
	private int ligue;
	private String nom, prenom, mail ,adresse, password, codeEmploye;	

	AjoutEmploye() {
		super();
		this.setTitle("Menu compte root");
		this.setVisible(true);
		// this.setSize(600,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(affichage());
		this.pack();

	}
	AjoutEmploye(String ligue,String nom, String prenom, String mail, String codeEmploye, String adresse,String password){
		ligue = tligue.getText() ;
		nom = tnom.getText();
		prenom = tprenom.getText();
		mail = tmail.getText();
		codeEmploye = tcode.getText();
		adresse = tadresse.getText();
		password = tpass.getText();
	}

	/*
	 * gridlayout permet de classer les elements suivants un ordre de ligne et
	 * de colonne
	 */
	/*
	 * dans affichage nous agencons la disposition de tous les elements de notre
	 * interface
	 */
	private JPanel affichage() {
		JPanel menu = new JPanel();
		getInsets();
		menu.setLayout(new BorderLayout(2, 5));
		add(label(), BorderLayout.WEST);
		add(texte(), BorderLayout.EAST);
		add(bouton(), BorderLayout.SOUTH);
		add(messageInterface(), BorderLayout.NORTH);
		return menu;
	}

	/* disposition de nos differents labels */
	private JPanel label() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		JPanel menu3 = new JPanel();
		JPanel menu4 = new JPanel();
		JPanel menu5 = new JPanel();
		JPanel menu6 = new JPanel();
		JPanel menu7 = new JPanel();

		// On définit le layout en lui indiquant qu'il travaillera en ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(laligue);
		// Idem pour cette ligne
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(lemail);
		// Idem pour cette ligne
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
		menu3.add(lenom);
		// Idem pour cette ligne
		menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
		menu4.add(leprenom);
		// Idem pour cette ligne
		menu5.setLayout(new BoxLayout(menu5, BoxLayout.X_AXIS));
		menu5.add(lecode);
		// Idem pour cette ligne
		menu6.setLayout(new BoxLayout(menu6, BoxLayout.X_AXIS));
		menu6.add(lepassword);
		// Idem pour cette ligne
		menu7.setLayout(new BoxLayout(menu7, BoxLayout.X_AXIS));
		menu7.add(ladresse);

		// On positionne maintenant ces trois lignes en colonne
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(menu1);
		/* la ligne suivante permet de créer un espace entre les composants */
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu2);
		/* la ligne suivante permet de créer un espace entre les composants */
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu3);
		/* la ligne suivante permet de créer un espace entre les composants */
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu4);
		/* la ligne suivante permet de créer un espace entre les composants */
		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu5);

		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu6);

		position.add(Box.createRigidArea(new Dimension(10, 5)));
		position.add(menu7);

		return position;
	}

	/* disposition des textfields */
	private JPanel texte() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		JPanel menu3 = new JPanel();
		JPanel menu4 = new JPanel();
		JPanel menu5 = new JPanel();
		JPanel menu6 = new JPanel();
		JPanel menu7 = new JPanel();

		// On définit le layout en lui indiquant qu'il travaillera en ligne
		menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
		menu4.add(tmail);		
		// Idem pour cette ligne
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
		menu3.add(tprenom);
		// Idem pour cette ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(tligue);
		// Idem pour cette ligne
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(tnom);		
		/* idem pour cette ligne */
		menu5.setLayout(new BoxLayout(menu5, BoxLayout.X_AXIS));
		menu5.add(tpass);
		/* idem pour cette ligne */
		menu6.setLayout(new BoxLayout(menu6, BoxLayout.X_AXIS));
		menu6.add(tcode);

		menu7.setLayout(new BoxLayout(menu7, BoxLayout.X_AXIS));
		menu7.add(tadresse);
		// On positionne maintenant ces lignes en colonne
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(menu1);
		position.add(menu2);
		position.add(menu3);
		position.add(menu4);
		position.add(menu5);
		position.add(menu6);
		position.add(menu7);

		return position;
	}

	/* disposition des boutons */

	private JPanel bouton() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		// On définit le layout en lui indiquant qu'il travaillera en ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(ajouter());
		// Idem pour cette ligne
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

	/* disposition du message en cas d'ajout */
	private JPanel messageInterface() {
		JPanel position = new JPanel();
		message.setForeground(new Color(237, 28, 36));
		message.setVisible(false);
		position.add(message);

		return position;
	}


	/* cree l'espace entre les bords du conteneur et ses composants */
	public Insets getInsets() {
		return new Insets(50, 20, 20, 20);
	}

	private void fermeture() {
		this.setVisible(false);
	}

	/*------------------gestion des différentes commandes -------------*/
	/* bouton permettant retour vers le menu principal */
	private JButton retour() {
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				new GestionEmployeIHM();
				fermeture();
			}
		});
		return retour;
	}

	/*-----fonction du bouton ajouter permettant l'ajout d'un employé dans la base de données*/
	private JButton ajouter() {
		JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				if (verificationChamp()) {
					/* on teste que le mail est bon */					
					bdd.ajoutEmploye(ligue,mail,nom,prenom,password,adresse);
					message.setVisible(true);
					
				} else {
					/*
					 * notre JOptionPane ici vide permet d'afficher une boite de
					 * dialogue alertant l'utilisateur sur le fait qu'il n'a pas
					 * entré des informations dans toutes les cases
					 */
					JOptionPane.showMessageDialog(erreur,
							"veuillez remplir tous les champs!");
				}
			}
		});
		return ajouter;
	}

	/* verification de la validité du mail */
	/*
	 * nous verifions avec le sexpressions regulieres , pour ce faire nous
	 * importons le paquage java.util.regex. la methode trim() supprime les
	 * espaces vides dans un srting*
	 */
	public boolean testmail() {
		if (tmail.getText() != null && tmail.getText().trim().length() > 0)
			return tmail
					.getText()
					.matches(
							"^[a-zA-Z0-9\\.\\-\\_]+@([a-zA-Z0-9\\-\\_\\.]+\\.)+([a-zA-Z]{2,4})$");
		else
			return false;
	}

	/*
	 * la methode verification des champs est une methode qui renvoie vrai si
	 * tous les champs sont remplis sinon elle renvoie faux*
	 */

	public boolean verificationChamp() {
		return !tnom.getText().isEmpty() && !tprenom.getText().isEmpty()
				&& !tpass.getText().isEmpty() && !tadresse.getText().isEmpty()
				&& !tmail.getText().isEmpty() && !tligue.getText().isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AjoutEmploye();
	}

}
