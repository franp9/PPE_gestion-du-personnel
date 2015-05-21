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
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings({ "serial" })


public class AjoutLigue extends JFrame  {
	
	/* ---------------- les labels -------------------------------*/
	private JLabel nomLigue = new JLabel("Nom de la ligue : ");
	private JLabel nomAdmin = new JLabel("Nom de l\'administrateur");
	private JLabel adresse = new JLabel("Adresse de la ligue : ");
	private JLabel messagedeReussite = new JLabel("vous venez d'ajouter une nouvelle ligue!");
	
	/*----------------les textfield-------------------------------*/
	private JTextField textnomligue = new JTextField(25);
	private JTextField textadresse = new JTextField(25);
	private JTextField textnomAdmin = new JTextField(25);

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
	
	private JPanel affichage(){
		JPanel menu = new JPanel();
		getInsets();
		menu.setLayout(new BorderLayout(2,5));
		add(label(),BorderLayout.WEST);
		add(texte(),BorderLayout.EAST);
		add(bouton(),BorderLayout.SOUTH);
		add(messageInterface(),BorderLayout.NORTH);
		return menu;
	}
	
	
	
	
	
	
	/*positionnement des labels*/
	private JPanel label() {
		JPanel position = new JPanel();
		JPanel positionLabelLigue = new JPanel();
		JPanel positionLabeladmin = new JPanel();
		JPanel positionLabeladresse = new JPanel();
				
		
	    //On définit le layout en lui indiquant qu'il travaillera en ligne		
		positionLabelLigue.setLayout(new BoxLayout(positionLabelLigue, BoxLayout.X_AXIS));
		positionLabelLigue.add(nomLigue);
		//Idem pour cette ligne
		positionLabeladresse.setLayout(new BoxLayout(positionLabeladresse, BoxLayout.X_AXIS));
		positionLabeladresse.add(adresse);
		//Idem pour cette ligne
		positionLabeladmin.setLayout(new BoxLayout(positionLabeladmin, BoxLayout.X_AXIS));
		positionLabeladmin.add(nomAdmin);
		
		
		 //On positionne maintenant ces trois lignes en colonne	
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(nomLigue);
		/*la ligne suivante permet de créer un espace entre les composants*/
		position.add(Box.createRigidArea(new Dimension(10,5)));
		position.add(adresse);
		position.add(Box.createRigidArea(new Dimension(10,5)));
		position.add(nomAdmin);
		
		return position;
	}
	
	/*disposition des textfields*/
	private JPanel texte() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
		JPanel menu3 = new JPanel();
		
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(textnomligue);
		//Idem pour cette ligne
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(textadresse);
		menu3.setLayout(new BoxLayout(menu3, BoxLayout.X_AXIS));
		menu3.add(textnomAdmin);
		
		 //On positionne maintenant ces  lignes en colonne	
		position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
		position.add(menu1);			
		position.add(menu2);
		position.add(menu3);
	
		return position;
	}
	
	private JPanel bouton() {
		JPanel position = new JPanel();
		JPanel menu1 = new JPanel();
		JPanel menu2 = new JPanel();
	    //On définit le layout en lui indiquant qu'il travaillera en ligne
		menu1.setLayout(new BoxLayout(menu1, BoxLayout.X_AXIS));
		menu1.add(ajouter());
		//Idem pour cette ligne
		menu2.setLayout(new BoxLayout(menu2, BoxLayout.X_AXIS));
		menu2.add(retour());
		
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
		
		return position;
	}
	
	
	private JButton retour(){
		JButton retour = new JButton("Retour");
		retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new GestionLigueIhm();
				fermeture();
			}
		});
		return retour;
	}
	/*-----fonction du bouton supprimer permettant la suppression de l'mployé dans la base de données*/
	private JButton ajouter(){
	    JButton ajouter = new JButton("Ajouter");
		ajouter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				/*messagedeReussite.setVisible(true) est le message signifiant que l'ajout c'est bien passé*/
				messagedeReussite.setVisible(true);
				/*commande sql permettant d'ajouter un utilisateur*/
			}
		});
		return ajouter;
	}
	
		public Insets getInsets() {
			return new Insets(50,50,50,50);
		}
	
	private void fermeture(){
		this.setVisible(false);
	}
	
	/* disposition du message en cas d'ajout*/
	private JPanel messageInterface(){
		JPanel position = new JPanel();		
		messagedeReussite.setForeground(new Color(237,28,36));
		messagedeReussite.setVisible(false);
		position.add(messagedeReussite);			
		
		return position;			
	}			
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new AjoutLigue();
	}

}
