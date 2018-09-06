import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VueVainqueurs extends Application{
 @Override
	public void start(Stage stade) throws Exception {
	 	Pane panneau = new Pane();	
		GridPane grilleVainqueur = new GridPane();
		Label valeurNomEquipe = new Label("Paris Saint Germain");
		grilleVainqueur.add(new Label("Nom : "), 0, 0);
		grilleVainqueur.add(valeurNomEquipe, 1, 0);
		
		Label valeurEntraineur = new Label("Unai Emery");
		
		grilleVainqueur.add(new Label("Entraineur : "), 0, 1);
		grilleVainqueur.add(valeurEntraineur, 1, 1);
		
		Label valeurDate = new Label("8 Mai 1980");
		
		grilleVainqueur.add(new Label("Date : "), 0, 2);
		grilleVainqueur.add(valeurDate, 1, 2);
		
		Label valeurCapitaine = new Label("Thiago Silva");
		
		grilleVainqueur.add(new Label("Capitaine : "), 0, 3);
		grilleVainqueur.add(valeurCapitaine, 1, 3);	
		
		panneau.getChildren().add(grilleVainqueur);

		stade.setScene(new Scene(panneau, 600, 500));
		stade.show();
	}
}