package personnel;

import java.io.Serializable;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Représente une ligue. Chaque ligue est reliée à une liste
 * d'employés dont un administrateur. Comme il n'est pas possible
 * de créer un employé sans l'affecter à une ligue, le root est 
 * l'administrateur de la ligue jusqu'à ce qu'un administrateur 
 * lui ait été affecté avec la fonction {@link #setAdministrateur}.
 */

public class Ligue implements Serializable, Comparable<Ligue>
{
	private static final long serialVersionUID = 1L;
	private String nom;
	private SortedSet<Employe> employes;
	private Employe administrateur;
	private String adresse;
	private String nomAdministrateur;
	private String prenomAdministrateur;
	private int id;
	
	/**
	 * Crée une ligue.
	 * @param nom le nom de la ligue.
	 */
	
	public Ligue(String nom, String adresse,int id)
	{
		this.nom = nom;
		this.adresse =  adresse;
		this.id = id;
		employes = new TreeSet<>();
		administrateur = GestionPersonnel.getGestionPersonnel().getRoot();
		GestionPersonnel.getGestionPersonnel().add(this);
	}

	public Ligue(Employe administrateur,String nom, String adresse, int id) {
		this.nom = nom;
		this.adresse =  adresse;
		this.id = id;
		this.administrateur = administrateur;		
	}
	
	public Ligue(String nomAdministrateur, String prenomAdministrateur,String nom, String adresse, int id){
		this.nom = nom;
		this.adresse =  adresse;
		this.id = id;
		this.nomAdministrateur = nomAdministrateur;	
		this.prenomAdministrateur = prenomAdministrateur;	
	}

	/**
	 * Retourne le nom de la ligue.
	 * @return le nom de la ligue.
	 */

	public String getNom()
	{
		return nom;
	}

	/**
	 * Change le nom.
	 * @param nom le nouveau nom de la ligue.
	 */

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Retourne l'administrateur de la ligue.
	 * @return l'administrateur de la ligue.
	 */
	
	public Employe getAdministrateur()
	{
		return administrateur;
	}

	/**
	 * Fait de administrateur l'administrateur de la ligue.
	 * Lève DroitsInsuffisants si l'administrateur n'est pas 
	 * un employé de la ligue. Révoque les droits de l'ancien 
	 * administrateur.
	 * @param administrateur le nouvel administrateur de la ligue.
	 */
	
	public void setAdministrateur(Employe administrateur)
	{
		if (administrateur.getLigue() != this)
			throw new DroitsInsuffisants();
		this.administrateur = administrateur;
	}

	/**
	 * Retourne les employés de la ligue.
	 * @return les employés de la ligue dans l'ordre alphabétique.
	 */
	
	public SortedSet<Employe> getEmployes()
	{
		return Collections.unmodifiableSortedSet(employes);
	}

	/**
	 * Ajoute un employé dans la ligue. Cette méthode 
	 * est le seul moyen de créer un employé.
	 * @param nom le nom de l'employé.
	 * @param prenom le prénom de l'employé.
	 * @param mail l'adresse mail de l'employé.
	 * @param password le password de l'employé.
	 * @return l'employé créé. 
	 */

	public Employe addEmploye(String nom, String prenom, String mail, String password,int id)
	{
		Employe employe = new Employe(this, nom, prenom, mail, password,id);
		employes.add(employe);
		return employe;
	}
	
	void remove(Employe employe)
	{
		employes.remove(employe);
	}
	
	/**
	 * Supprime la ligue, entraîne la suppression de tous les employés
	 * de la ligue.
	 */
	
	public void remove()
	{
		GestionPersonnel.getGestionPersonnel().remove(this);
	}
	

	@Override
	public int compareTo(Ligue autre)
	{
		return getNom().compareTo(autre.getNom());
	}
	
	@Override
	public String toString()
	{
		return nom;
	}

	public String getadresse() {
		
		return adresse;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setadresse(String adresse) {
		// TODO Auto-generated method stub
		this.adresse = adresse;
	}

	public Object getnomAdministrateur() {
		// TODO Auto-generated method stub
		return nomAdministrateur;
	}

	public Object getprenomAdministrateur() {
		// TODO Auto-generated method stub
		return prenomAdministrateur;
	}

	public void setnomAdministrateur(String string) {
		this.nomAdministrateur = string;
		
	}

	public void setprenomAdministrateur(String string) {
		this.nomAdministrateur = string;
		
	}
}
