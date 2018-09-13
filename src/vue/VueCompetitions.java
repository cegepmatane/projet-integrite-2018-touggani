package vue;


import javafx.application.Application;
import javafx.stage.Stage;
import modele.Competitions;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VueCompetitions extends Application{
 	
	protected Label valeurNomCompetition;
	protected Label valeurAmpleurCompetition;

	
	public void start(Stage stade) throws Exception {
	 	Pane panneau = new Pane();	
		GridPane grilleCompetition = new GridPane();
		valeurNomCompetition = new Label("");
		grilleCompetition.add(new Label("Competition "), 0, 0);
		grilleCompetition.add(valeurNomCompetition, 0, 1);
		
		valeurAmpleurCompetition = new Label("");
		
		grilleCompetition.add(new Label(" Ampleur de la competition "), 2, 0);
		grilleCompetition.add(valeurAmpleurCompetition, 2, 1);
		
		
		panneau.getChildren().add(grilleCompetition);

		stade.setScene(new Scene(panneau, 600, 500));
		stade.show();
		
		Competitions competition = new Competitions("Ligue des Champions", "Européen");
		this.afficherCompetitions(competition);
	}
	
	public void afficherCompetitions(Competitions competition)
	{
		this.valeurNomCompetition.setText(competition.getNomCompetition());
		this.valeurAmpleurCompetition.setText(competition.getAmpleurCompetition());
	}
}