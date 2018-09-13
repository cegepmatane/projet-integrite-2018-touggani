import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;


 public class NavigateurDesVues extends Application{
	
	private VueAjouterVainqueur vueAjouterVainqueur;
	private VueListeVainqueur vueListeVainqueur;
	private VueVainqueurs vueVainqueur;
	
	public NavigateurDesVues() 
	{
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
		stade.setScene(this.vueAjouterVainqueur);
		stade.setScene(this.vueListeVainqueur);
		stade.setScene(this.vueVainqueur);
		stade.show();
	}
	
}
