import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;	
import javafx.scene.control.Label;


 public class VueListeVainqueur extends Application {
 	
	 protected GridPane grilleVainqueurs;
	 
	public void start(Stage stade) throws Exception {
		Pane panneau = new Pane();	
		grilleVainqueurs = new GridPane();
		
		panneau.getChildren().add(grilleVainqueurs);
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();
		
		/// TEST ///
		List <Vainqueur> listeVainqueursTest = new ArrayList<Vainqueur>();
		listeVainqueursTest.add(new Vainqueur("Real de Madrid", "20/01/1989", "Zidane", "Robinho"));
		listeVainqueursTest.add(new Vainqueur("Liverpool", "02/07/1989", "Ancelotti", "Gerrard"));
		this.afficherListeVainqueurs(listeVainqueursTest); 
			
			
		}
		
		public void afficherListeVainqueurs(List<Vainqueur> listeVainqueurs)
		{
			int numero = 0;
			this.grilleVainqueurs.add(new Label("Nom Equipe"), 0, numero);
			this.grilleVainqueurs.add(new Label("Date"), 1, numero);
			this.grilleVainqueurs.add(new Label("Entraineur"), 2, numero);
			this.grilleVainqueurs.add(new Label("Capitaine"), 3, numero);
			for(Vainqueur vainqueur : listeVainqueurs)
			{
				numero++;
				this.grilleVainqueurs.add(new Label(vainqueur.getNomEquipe()), 0, numero);
				this.grilleVainqueurs.add(new Label(vainqueur.getDate()), 1, numero);	
				this.grilleVainqueurs.add(new Label(vainqueur.getEntraineur()), 2, numero);			
				this.grilleVainqueurs.add(new Label(vainqueur.getCapitaine()), 3, numero);			

			}
		}
}
 