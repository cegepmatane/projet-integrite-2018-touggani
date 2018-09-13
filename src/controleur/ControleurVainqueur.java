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
		
	public ControleurVainqueur(NavigateurDesVues navigateur)
	{
		this.navigateur = navigateur;
		this.vueAjouterVainqueur = navigateur.getVueAjouterVainqueur();
		this.vueVainqueur = navigateur.getVueVainqueur();
		this.vueListeVainqueur = navigateur.getVueListeVainqueur();
		System.out.println("Initialisation du controleur");
		
		Vainqueur vainqueur = new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah");
		this.vueVainqueur.afficherVainqueur(vainqueur);
		
		this.navigateur.naviguerVersVueVainqueur();
		
		ArrayList<Vainqueur> listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		this.vueListeVainqueur.afficherListeVainqueurs(listeVainqueurTest);
		
		this.navigateur.naviguerVersVueListeVainqueur();	
	}
}
