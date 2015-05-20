package baseDeDonnees;
import java.sql.*;

public abstract class BaseDeDonnees {
	

	protected String url;
	protected String user;
	protected String passwd;
	protected Connection connexion;

	
	public BaseDeDonnees() {
		 url = "jdbc:mysql://localhost/gestionpersonnel";
		 user="root";
		 passwd="";
	}
	/*la methode connect() contient une ensemble de méthodes 
	 * permettant de connecter l'application à la base de données*/
	protected void connect() {
		try{
			/* chargement du driver JDBC ppour MySQL*/			
			Class.forName("com.mysql.jdbc.Driver");			
			/* Connexion à la base de donnée */

			connexion = DriverManager.getConnection(url, user, passwd);
			
		} catch (ClassNotFoundException e ) {
			System.out.println("driver pb");
			
		} catch (SQLException e) {
			System.out.println("connexion pb");
		}
	}
	
	/* la methode close() permet de fermer la connexion à la base 
	 * de données */
	protected void close() {
		try {
			if (connexion != null)
				connexion.close();
			
		} catch (SQLException e) {
			System.out.println("fermeture connexion pb");
		}
	}

}
