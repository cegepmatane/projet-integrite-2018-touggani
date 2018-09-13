package action;
import vue.NavigateurDesVues;
import vue.VueAjouterVainqueur;
import vue.VueListeVainqueur;
import vue.VueVainqueurs;
import java.util.List;

import donnee.VainqueurDAO;
import modele.Vainqueur;

public class ControleurVainqueur {
	
	private NavigateurDesVues navigateur;
	private VueAjouterVainqueur vueAjouterVainqueur = null;
	private VueListeVainqueur vueListeVainqueur = null;
	private VueVainqueurs vueVainqueur = null;
		
	public ControleurVainqueur()
	{
		System.out.println("Initialisation du controleur");		
	}
	public void activerVues(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAjouterVainqueur = navigateur.getVueAjouterVainqueur();
		this.vueVainqueur = navigateur.getVueVainqueur();
		this.vueListeVainqueur = navigateur.getVueListeVainqueur();
		
		Vainqueur vainqueur = new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah");
		this.vueVainqueur.afficherVainqueur(vainqueur);
		
		this.navigateur.naviguerVersVueVainqueur();
		
		VainqueurDAO moutonDAO = new VainqueurDAO();
		List<Vainqueur> listeVainqueurTest = moutonDAO.listerVainqueur();
		this.vueListeVainqueur.afficherListeVainqueurs(listeVainqueurTest);
		
		this.navigateur.naviguerVersVueListeVainqueur();	

	}
	
	private static ControleurVainqueur instance = null;
	public static ControleurVainqueur getInstance()
	{
		if(null == instance) instance = new ControleurVainqueur();
		return instance;
	}
}
