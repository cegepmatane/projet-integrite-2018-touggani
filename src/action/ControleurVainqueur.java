package action;
import vue.NavigateurDesVues;
import vue.VueAjouterVainqueur;
import vue.VueListeVainqueur;
import vue.VueVainqueurs;
import java.util.List;
import vue.VueEditerVainqueur;

import donnee.VainqueurDAO;
import modele.Vainqueur;

public class ControleurVainqueur {
	
	private NavigateurDesVues navigateur;
	private VueAjouterVainqueur vueAjouterVainqueur = null;
	private VueEditerVainqueur vueEditerVainqueur = null;
	private VueListeVainqueur vueListeVainqueur = null;
	private VueVainqueurs vueVainqueur = null;
	
	VainqueurDAO vainqueurDAO = null;
		
	private ControleurVainqueur()
	{
		System.out.println("Initialisation du controleur");
		this.vainqueurDAO = new VainqueurDAO();
	}
	
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAjouterVainqueur = navigateur.getVueAjouterVainqueur();
		this.vueVainqueur = navigateur.getVueVainqueur();
		this.vueListeVainqueur = navigateur.getVueListeVainqueur();
		this.vueEditerVainqueur = navigateur.getVueEditerVainqueur();
		
		Vainqueur vainqueur = new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah");
		this.vueVainqueur.afficherVainqueur(vainqueur);
		
		this.navigateur.naviguerVersVueVainqueur();
		
		List<Vainqueur> listeVainqueurTest = vainqueurDAO.listerVainqueur();
		this.vueListeVainqueur.afficherListeVainqueurs(listeVainqueurTest);
		
		this.navigateur.naviguerVersVueListeVainqueur();	
		//this.navigateur.naviguerVersVueAjouterVainqueur();

	}
	
	private static ControleurVainqueur instance = null;
	public static ControleurVainqueur getInstance()
	{
		if(null == instance) instance = new ControleurVainqueur();
		return instance;
	}
	
	public void notifierEnregistrerNouveauVainqueur()
	{
		System.out.println("ControleurVainqueur.notifierEnregistrerNouveauVainqueur()");
		Vainqueur vainqueur = this.navigateur.getVueAjouterVainqueur().demanderVainqueur();
		this.vainqueurDAO.ajouterVainqueur(vainqueur);
		this.vueListeVainqueur.afficherListeVainqueurs(this.vainqueurDAO.listerVainqueur());
		this.navigateur.naviguerVersVueListeVainqueur();
	}
	
	public void notifierEnregistrerVainqueur()
	{
		System.out.println("ControleurVainqueur.notifierEnregistrerVainqueur()");
		Vainqueur vainqueur = this.navigateur.getVueEditerVainqueur().demanderVainqueur();
		this.vainqueurDAO.modifierVainqueur(vainqueur);
		this.vueListeVainqueur.afficherListeVainqueurs(this.vainqueurDAO.listerVainqueur()); 
		this.navigateur.naviguerVersVueListeVainqueur();		
	}
	
	public void notifierNaviguerAjouterVainqueur()
	{
		System.out.println("ControleurVainqueur.notifierNaviguerAjouterVainqueur()");
		this.navigateur.naviguerVersVueAjouterVainqueur();
	}
	
	public void notifierNaviguerEditerVainqueur(int idVainqueur)
	{
		System.out.println("ControleurVainqueur.notifierEditerVainqueur("+idVainqueur+")");
		this.vueEditerVainqueur.afficherVainqueur(this.vainqueurDAO.rapporterVainqueur(idVainqueur));
		this.navigateur.naviguerVersVueEditerVainqueur();
		
	}

}
