import javafx.application.Application;
import javafx.stage.Stage;

 public class NavigateurDesVues extends Application{
	
	private VueAjouterVainqueur vueAjouterVainqueur;
	
	public NavigateurDesVues() 
	{
		this.vueAjouterVainqueur = new VueAjouterVainqueur();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAjouterVainqueur);
		stade.show();
	}
	
}
