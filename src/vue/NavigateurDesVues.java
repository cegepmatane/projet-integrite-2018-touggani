package vue;
import controleur.ControleurVainqueur;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Vainqueur;

import java.util.ArrayList;


 public class NavigateurDesVues extends Application{
	
	private Stage stade;
	private VueAjouterVainqueur vueAjouterVainqueur = null;
	private VueListeVainqueur vueListeVainqueur = null;
	private VueVainqueurs vueVainqueur = null;
	private ControleurVainqueur controleur = null;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterVainqueur = new VueAjouterVainqueur();
		this.vueListeVainqueur = new VueListeVainqueur();
		this.vueVainqueur = new VueVainqueurs();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		this.stade.setScene(this.vueListeVainqueur);
		this.stade.show();
	
		this.controleur = new ControleurVainqueur(this); 

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
	

