package ihm;

import java.util.ArrayList;
import java.util.List;

import personnel.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;

import baseDeDonnees.BaseEmploye;


@SuppressWarnings({ "serial", "unused" })
public class Personnel extends JFrame {
	private BaseEmploye bdd = new BaseEmploye();
	private GestionPersonnel gestionPersonnel;
	private JButton valider = new JButton("valider");//creation de bouton	
	private JPasswordField pass = new JPasswordField();
	private JLabel erreur = new JLabel(" mauvais mot de passe");
	private String passwd;
	
	/* JPasswordField on l'utilise comme jTextField mais permet de cacher les caractères insérer  dans la zone de texte--------------*/
	/*-------------------------------------------------------  CONSTRUCTEUR  --------------------------------------------------------*/

	public Personnel(GestionPersonnel gestionPersonnel) {
		super("Bienvenue! ");
		this.gestionPersonnel = gestionPersonnel;
		this.setVisible(true);
		this.setSize(400,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getPanel());
		//this.pack();
		
		
		
	}

	private JPanel getPanel() {
		JPanel panel = new JPanel();
		/* le JPANEL panel positionne des éléments de l'écran */
		JPanel label = new JPanel();
		label.setLayout(new BoxLayout(label, BoxLayout.LINE_AXIS));
		
		/* Le JLabel permet d'afficher le texte */
		label.add(new JLabel("Entrer votre Mot de passe"));
		
		/* zoneTexte est un JPanel donc permettant la recupération
		 *  du mot de passe à l'écran*/
		JPanel zoneTexte = new JPanel();
		zoneTexte.setLayout(new BoxLayout(zoneTexte, BoxLayout.LINE_AXIS));
		zoneTexte.add(pass);
		
		/*valide est le panel sur lequel nous mettons le bouton
		 * valider sur l'interface*/
		JPanel valide = new JPanel();
		valide.setLayout(new BoxLayout(valide, BoxLayout.LINE_AXIS));
		valide.add(valider());
		
		/*sms erreur est un panel qui  affiche un message en cas
		 *  d'erreur  dans la saisie du mot de passe*/
		JPanel smserreur = new JPanel();
		smserreur.setLayout(new BoxLayout(smserreur, BoxLayout.LINE_AXIS));	
		erreur.setForeground(new Color(237,28,36));
		 erreur.setVisible(false);
		smserreur.add(erreur);
		

		/* On utilise le JPanel panel pour positionner via boxlayout
		 *  maintenant ces les trois JPanel (label,zoneTexte et valide) 
		 *  sur une  colonne */
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.add(label);
		panel.add(zoneTexte);
		panel.add(valide);
		panel.add(smserreur);

		return panel;
	}
	/*------------------------------------------------BOUTON  DE VALIDATION------------------------------------------------------
	 le bouton valider ouvre le menu principal si password correct  et ferme l interface courant sinon  il renvoie un message d'erreur*/
	protected JButton valider() { 	
		valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				if (bdd.connexion(new String(pass.getPassword()))){
					fermeture();
					new MenuPrincipal(); 	
				} else {
					erreur.setVisible(true);
					pass.setText("");
				}
		}
			});
		return valider;
	/* une methode de type bouton doit retourner un bouton*/
	}
	
	public Insets getInsets() {
		return new Insets(150,50,150,50);
	}
	private void fermeture() {
		this.setVisible(false);
	}
	/*------------------------------------------METHODE DE VERIFICATION DU MOT DE PASSE----------------------------------------
	on efface  util qui servait pour la ligne de commande et on teste pass.getText() qui recupère la valeur entrée par le root */
	
	
	/*----------------------------------------------------   MAIN  ------------------------------------------------------------*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Personnel(GestionPersonnel.getGestionPersonnel());

	}
}
