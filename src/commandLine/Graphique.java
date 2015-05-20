package commandLine;
//import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Graphique{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Graphique();
	
	}
	 Graphique(){		 
			JFrame f = new JFrame("ma fenetre");
			JButton b = new JButton("push me");
			
			b.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) {//la methode implementé par interface ActionListener qui execute l'actio du bouton
					System.out.println("cliqué!");
				}
			});
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent event) {
				System.exit(0);
				}
			});
			
			
			f.add(b);// ajout bouton dans fenetre
			f.pack();			
			f.setVisible(true);//visibilité du bouton
	}

}
