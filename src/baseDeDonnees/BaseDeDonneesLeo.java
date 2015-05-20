package baseDeDonnees;
import java.sql.*;

public class BaseDeDonneesLeo {
	
	private String url;
	private String user;
	private String passwd;
	private Connection connexion;
	private CallableStatement requetes;
	private ResultSet resultat;

	public BaseDeDonneesLeo() {
		 url = "jdbc:mysql://localhost/gestionpersonnel1";
		 user="root";
		 passwd="";
	}
	
	private void connect() {
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
	
	public void close() {
		try {
			if (connexion != null)
				connexion.close();
			
		} catch (SQLException e) {
			System.out.println("fermeture connexion pb");
		}
	}
	
	public boolean connexion(String mdp) {
		connect();
		int test = 0;
		
		try {
			/* Appel de la procédure stockée */
			
			requetes = connexion.prepareCall("call connexion(?)");
			
			/* Attribution des variables */
			
			requetes.setString(1, mdp);
			
			/* Exécution de la requète */
		
			if(requetes.execute()) {
				
				/* Récupération des résultats */
				
			    resultat = requetes.getResultSet();
			    
			    /* Traitement */
			    
			    while(resultat.next()){
			       test = resultat.getInt("root");
			    }
			}
		
		} catch (SQLException e) {
			System.out.println("pb requete");
		} finally {
			close();
		}

		return test == 1;
	}
	

	public static void main(String[] args) {
		BaseDeDonneesLeo ninja = new BaseDeDonneesLeo();
		System.out.println(ninja.connexion("toor"));
	}
}
