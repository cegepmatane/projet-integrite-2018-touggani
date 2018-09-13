package controleur;
import vue.NavigateurDesVues;
import vue.VueAjouterVainqueur;
import vue.VueListeVainqueur;
import vue.VueVainqueurs;
import java.util.ArrayList;
import java.util.List;
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
		
		ArrayList<Vainqueur> listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		this.vueListeVainqueur.afficherListeVainqueurs(listeVainqueurTest);
		
		this.navigateur.naviguerVersVueListeVainqueur();	
		this.navigateur.naviguerVersVueAjouterVainqueur();
	}
	
	private static ControleurVainqueur instance = null;
	public static ControleurVainqueur getInstance()
	{
		if(null == instance) instance = new ControleurVainqueur();
		return instance;
	}
}
