package vue;
import javafx.application.Application;
import javafx.stage.Stage;


import action.ControleurVainqueur;


 public class NavigateurDesVues extends Application{
	
	private Stage stade;
	private VueAjouterVainqueur vueAjouterVainqueur = null;
	private VueAjouterDistinction vueAjouterDistinction = null;
	private VueEditerVainqueur vueEditerVainqueur = null;
	private VueListeVainqueur vueListeVainqueur = null;
	private VueVainqueurs vueVainqueur = null;
	private ControleurVainqueur controleur = null;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterVainqueur = new VueAjouterVainqueur();
		this.vueAjouterDistinction = new VueAjouterDistinction();
		this.vueEditerVainqueur = new VueEditerVainqueur();
		this.vueListeVainqueur = new VueListeVainqueur();
		this.vueVainqueur = new VueVainqueurs();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		this.stade.setScene(null);
		this.stade.show();
	
		this.controleur = ControleurVainqueur.getInstance(); 
		this.controleur.activerVues(this);
		this.vueAjouterVainqueur.setControleur(controleur);
		this.vueAjouterDistinction.setControleur(controleur);
		this.vueEditerVainqueur.setControleur(controleur);
		this.vueListeVainqueur.setControleur(controleur);
		this.vueVainqueur.setControleur(controleur);

	 	}	
		
		public VueAjouterVainqueur getVueAjouterVainqueur() {
			return vueAjouterVainqueur;
		}
		public VueEditerVainqueur getVueEditerVainqueur() {
			return this.vueEditerVainqueur;
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
		public void naviguerVersVueEditerVainqueur()
		{
			stade.setScene(this.vueEditerVainqueur);
			stade.show();				
		}
		
		public void naviguerVersVueListeVainqueur()
		{
			stade.setScene(this.vueListeVainqueur);
			stade.show();		
		}
		
		public void naviguerVersVueAjouterDistinction()
		{
			stade.setScene(this.vueAjouterDistinction);
			stade.show();		
		}
			
			
	}
	

