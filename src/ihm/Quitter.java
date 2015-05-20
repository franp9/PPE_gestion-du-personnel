package ihm;

import javax.swing.*;

public class Quitter extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel aurevoir = new JLabel("Merci d\'avoir utilisé notre application.\n aurevoir!");
	
	public Quitter(){ 
		super();
		this.setTitle("MENU PRINCIPAL");
		this.setVisible(true);
		this.setSize(300,150);//adapte les dimensions de la fenetre en fonction de ses composants
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		this.getContentPane().add(aurevoir);
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
