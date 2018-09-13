package vue;
import controleur.ControleurVainqueur;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Vainqueur;

import java.util.ArrayList;


 public class NavigateurDesVues extends Application{
	
	private Stage stade;
	private VueAjouterVainqueur vueAjouterVainqueur;
	private VueListeVainqueur vueListeVainqueur;
	private VueVainqueurs vueVainqueur;
	private ControleurVainqueur controleur;
	
	public NavigateurDesVues() 
	{
		this.controleur = new ControleurVainqueur(this);
		this.vueAjouterVainqueur = new VueAjouterVainqueur();
		this.vueListeVainqueur = new VueListeVainqueur();
		this.vueVainqueur = new VueVainqueurs();
		
		ArrayList<Vainqueur> listeVainqueurTest = new ArrayList<Vainqueur>();
		listeVainqueurTest.add(new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis"));
		listeVainqueurTest.add(new Vainqueur("Liverpool", "18 Juin 1985", "Kloop", "Salah"));
		this.vueListeVainqueur.afficherListeVainqueurs(listeVainqueurTest);

		Vainqueur vainqueur = new Vainqueur("Paris", "2 Mai 2018", "Blanc", "Luis");
		this.vueVainqueur.afficherVainqueur(vainqueur); 
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		this.stade.setScene(this.vueListeVainqueur);
		this.stade.show();
	
		//// TEST ////
		this.naviguerVersVueListeVainqueur();
		this.naviguerVersVueVainqueur();
		this.naviguerVersVueAjouterVainqueur();
	 	}	
		
		public VueAjouterVainqueur getVueAjouterVainqueur() {
			return vueAjouterVainqueur;
		}
	 	public VueListeVainqueur getVueListeVainqueur() {
			return vueListeVainqueur;
		}
	 	public VueVainqueurs getVueVainqueur() {
			return vueVainqueur;
		}
		
		public void naviguerVersVueVainqueur() {
			stade.setScene(this.vueVainqueur);
			stade.show();
		}
		
		public void naviguerVersVueAjouterVainqueur()
		{
			stade.setScene(this.vueAjouterVainqueur);
			stade.show();				
		}
		
		public void naviguerVersVueListeVainqueur()
		{
			stade.setScene(this.vueListeVainqueur);
			stade.show();		
		}
			
			
			
	}
	

