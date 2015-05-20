package ihm;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import personnel.GestionPersonnel;

@SuppressWarnings("unused")
public class ModifierDonneesEmploye extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*---- les differents boutons et de navigations-------------*/
	private JButton retour = new JButton("Retour");
	private JButton supprimer = new JButton("Supprimer");
	private JButton modifier = new JButton("Modifier");
	
	/* ----------- les labels des champs -------------------*/
	private JLabel lepassword = new JLabel("Mot de passe");
	private JLabel lemail = new JLabel("Mail");
	private JLabel leprenom = new JLabel("Prenom");
	private JLabel lenom = new JLabel("Nom");
	private JLabel laligue = new JLabel("Ligue");
	/*----------------les textfield-------------------------------*/
	private JTextField tpass = new JTextField(25);
	private JTextField tmail = new JTextField(25);
	private JTextField tprenom = new JTextField(25);
	private JTextField tnom = new JTextField(25);
	private JTextField tligue = new JTextField(25);
			
		ModifierDonneesEmploye(){ 
			super();
			this.setTitle("Menu compte root");
			this.setVisible(true);
			//this.setSize(1000,500);//adapte les dimensions de la fenetre en fonction de ses composants
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().add(affichage());
			this.pack();
			
		}
		/*gridlayout permet de classer les elements suivants un ordre de ligne et de colonne*/
		/*dans affichage nous agencons la disposition de tous les elements de notre interface*/
		private JPanel affichage(){
			JPanel menu = new JPanel();
			getInsets();
			menu.setLayout(new BorderLayout(2,5));
			add(label(),BorderLayout.WEST);
			add(texte(),BorderLayout.EAST);
			add(bouton(),BorderLayout.SOUTH);
			return menu;
		}
		/*disposition de nos differents labels*/
		private JPanel label() {
			JPanel position = new JPanel();
			JPanel menu1 = new JPanel();
			JPanel menu2 = new JPanel();
			JPanel menu3 = new JPanel();
			JPanel menu4 = new JPanel();
			JPanel menu5 = new JPanel();
			
			
		    //On définit le layout en lui indiquant qu'il travaillera en ligne
			menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
			menu1.add(lenom);
			//Idem pour cette ligne
			menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
			menu2.add(leprenom);
			//Idem pour cette ligne
			menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
			menu3.add(lemail);
			//Idem pour cette ligne
			menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
			menu4.add(lepassword);	
			//Idem pour cette ligne
			menu5.setLayout(new BoxLayout(menu5, BoxLayout.X_AXIS));
			menu5.add(laligue);
			 //On positionne maintenant ces lignes en colonne	
			position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
			position.add(menu1);
			/*la ligne suivante permet de créer un espace entre les composants*/
			position.add(Box.createRigidArea(new Dimension(0,5)));
			position.add(menu2);
			/*  Idem*/
			position.add(Box.createRigidArea(new Dimension(0,5)));
			position.add(menu3);
			/*  Idem*/
			position.add(Box.createRigidArea(new Dimension(0,5)));
			position.add(menu4);
			
			position.add(Box.createRigidArea(new Dimension(0,5)));
			position.add(menu5);
			
			return position;
		}
		/*disposition des textfields*/
		private JPanel texte() {
			JPanel position = new JPanel();
			JPanel menu1 = new JPanel();
			JPanel menu2 = new JPanel();
			JPanel menu3 = new JPanel();
			JPanel menu4 = new JPanel();
			JPanel menu5 = new JPanel();
		    //On définit le layout en lui indiquant qu'il travaillera en ligne
			menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
			menu1.add(tnom);
			//Idem pour cette ligne
			menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
			menu2.add(tprenom);
			//Idem pour cette ligne
			menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
			menu3.add(tmail);
			//Idem pour cette ligne
			menu4.setLayout(new BoxLayout(menu4, BoxLayout.X_AXIS));
			menu4.add(tpass);	
			/*idem pour cette ligne*/
			menu5.setLayout(new BoxLayout(menu5, BoxLayout.X_AXIS));
			menu5.add(tligue);
			 //On positionne maintenant ces  lignes en colonne	
			position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
			position.add(menu1);			
			position.add(menu2);
			position.add(menu3);
			position.add(menu4);
			position.add(menu5);
			
			return position;
		}
		/*disposition des boutons*/

		private JPanel bouton() {
			JPanel position = new JPanel();
			JPanel menu1 = new JPanel();
			JPanel menu2 = new JPanel();
			JPanel menu3 = new JPanel();
		    //On définit le layout en lui indiquant qu'il travaillera en ligne
			menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
			menu1.add(modifier());
			//Idem pour cette ligne
			menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
			menu2.add(supprimer());
			//Idem pour cette ligne
			menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
			menu3.add(retour());		
			 //On positionne maintenant ces trois lignes en colonne	
			position.setLayout(new BoxLayout(position, BoxLayout.X_AXIS));
			/*setborderlyaout permet de positionner le layout dans son conteneur
			 * le premier chiffre est sa distance avec la bordure superieure
			 * le second est sa distance selon la bordure gauche du conteneur
			 * le dernier chiffre sa position ou distance de la bordure droite du conteneur  */
			position.setBorder(BorderFactory.createEmptyBorder(25,125,0,0));
			
			position.add(menu1);
			/*la ligne suivante permet de créer un espace entre les composants*/
			position.add(Box.createRigidArea(new Dimension(5,0)));
			position.add(menu2);
			position.add(Box.createRigidArea(new Dimension(5,0)));
			position.add(menu3);
			
			return position;
		}
			
		
		/*cree l'espace entre les bords du conteneur et ses composants*/
		public Insets getInsets() {
			 return new Insets(75,75,50,50);
			}
		private void fermeture(){
			this.setVisible(false);
		}
		/*------------------gestion des différentes commandes -------------*/
		/*bouton permettant retour vers le menu principal*/
		private JButton retour(){
			retour.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					new GestionEmploye();
					fermeture();
				}
			});
			return retour;
		}
		/*-----fonction du bouton supprimer permettant la suppression de l'mployé dans la base de données*/
		private JButton supprimer(){
			supprimer.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					/*commande sql permettant la suppression d'un utilisateur*/
				}
			});
			return supprimer;
		}
		/*-----fonction du bouton modifier permettant modification des donnees du user------s*/
		private JButton modifier(){
			modifier.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					/*commande sql permettant modification*/
				}
			});
			return modifier;
		}
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub					
				new ModifierDonneesEmploye();				
			}


}
