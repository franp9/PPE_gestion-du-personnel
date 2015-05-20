package ihm;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;

@SuppressWarnings({ "serial", "unused" })
public class MenuPrincipal extends JFrame {
	
	private JButton gererCompte = new JButton("Gerer les employés");
	private JButton gererLigues = new JButton("Gerer vos Ligues");
	private JButton quitter = new JButton("quitter");
	
 
		public MenuPrincipal(){ 
			super();
			this.setTitle("MENU PRINCIPAL");
			this.setVisible(true);
			this.setSize(400,400);//adapte les dimensions de la fenetre en fonction de ses composants
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
			this.getContentPane().add(getPanel());
		
		}
		private JPanel getPanel() {
			JPanel menu = new JPanel();
			/* on va utiliser pour le positionnement un flowLayout permettant l'ajout d'elemeent les uns a la suite des autres horizontalement */
			setLayout(new FlowLayout());
			/*nous pouvons dès lors rajouter nos boutons contenus dans leurs fonctions*/
			add(gererRoot());
			add(gererLigues());
			add(quitter());
			/*un panel doit toujours retourner un panel*/
			return menu;
		}
		/*-------------------------------------------- fonction du bouton qui renvoi vers le menu du super admin ------------------------------*/
		private JButton gererRoot (){
			gererCompte.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					/*on invoque la methode fermeture pour fermer le menu principal des l'appui de ce bouton*/
					fermeture();
					/*le bouon nous dirige vers le menu du compte root*/
					new GestionEmployeIHM(); 
				}
			});
		/*notre methode de type bouton doit retourner notre  bouton */
			return gererCompte;
		}
		
		private JButton gererLigues(){
			gererLigues.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					fermeture();					
					new GestionLigueIhm(); 
				}
			});
			return gererLigues;
		}
		private JButton quitter(){
			quitter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					fermeture();					
					new Quitter(); 	 
				}
			});
			return quitter;
		}
		/*cree l'espace entre les bords du conteneur et ses composants*/
		public Insets getInsets() {
			 return new Insets(150,50,50,50);
			} 
		
		
		private void fermeture(){
			this.setVisible(false);
		}
		private void extinction(){
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		
		public static void main(String[] args) {
		// TODO Auto-generated method stub					
			new MenuPrincipal();				
		}
}
