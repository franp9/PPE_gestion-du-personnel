package ihm;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.*;

import javax.swing.*;
import java.util.ArrayList;
import javax.swing.JFrame;

@SuppressWarnings({ "unused", "serial" })
public class GestionEmploye extends JFrame {
	
	JLabel nom = new JLabel("nom");
	JLabel numero = new JLabel("n°");
	
	JTextField tnom = new JTextField(10);
	JTextField tnumero = new JTextField(3);
	
	JButton afficher = new JButton("afficher données");
	JButton ajouter = new JButton("ajouter employé");
	JButton retour = new JButton("retour");
	
	
	public GestionEmploye(){ 
		super();
		this.setTitle("Gestion des Employes");
		this.setVisible(true);
		this.setSize(500,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.getContentPane().add(affichage());
		//this.pack();
	}
	
	/*organise la position du nm n° et les donnees a rentrer*/
	private JPanel appercu() {
		JPanel menu = new JPanel();		
		setLayout(new FlowLayout());		
		add(numero);
		add(tnumero);
		add(nom);
		add(tnom);
		add(afficher());
					
		return menu;
	}
	/*organise la disposition des boutons sur leur ligne*/
	private JPanel navigation() {
		JPanel menu = new JPanel();		
		setLayout(new FlowLayout());
		add(ajouter());	
		add(retour());			
		return menu;
	}
	/*ajuste position des noms zone d'ecriture et bouton sur le panel*/
	private JPanel affichage(){
		JPanel menu = new JPanel();
		menu.setLayout(new BorderLayout());
		add(appercu(),BorderLayout.CENTER);
		add(navigation(),BorderLayout.SOUTH);
		//add(boutonNavigation());
		return menu;
	}
	
	/* ramene vers le menu principal*/
	
	private JButton retour(){
		retour.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new MenuPrincipal();
				fermeture();
			}
		});
		return retour;
	}
	/* renvoi sur l interface de modification des donnees des employe*/
	private JButton afficher(){
		afficher.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new ModifierDonneesEmploye();
				fermeture();
			}
		});
		return afficher;
	}
	
	private JButton ajouter(){
		ajouter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				new AjoutEmploye();
				fermeture();
			}
		});
		return ajouter;
	}
	
	private void fermeture(){
		this.setVisible(false);
	}
	public Insets getInsets() {
		 return new Insets(75,75,50,50);
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new GestionEmploye();
	}

}
