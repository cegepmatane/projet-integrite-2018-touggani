import javafx.application.Application;
import javafx.stage.Stage;

 public class NavigateurDesVues extends Application{
	
	private VueAjouterVainqueur vueAjouterVainqueur;
	private VueListeVainqueur vueListeVainqueur;
	private VueVainqueurs vueVainqueur;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterVainqueur = new VueAjouterVainqueur();
		this.vueListeVainqueur = new VueListeVainqueur();
		this.vueVainqueur = new VueVainqueurs();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAjouterVainqueur);
		stade.setScene(this.vueListeVainqueur);
		stade.setScene(this.vueVainqueur);
		stade.show();
	}
	
}
