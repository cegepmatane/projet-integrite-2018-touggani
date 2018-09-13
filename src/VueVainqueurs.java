

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class VueVainqueurs extends Scene{
 	
	protected Label valeurNomEquipe;
	protected Label valeurEntraineur;
	protected Label valeurDate;
	protected Label valeurCapitaine;
	
	public VueVainqueurs() {
		super(new Pane(),600,500);
		Pane panneau = (Pane) this.getRoot();
		GridPane grilleVainqueur = new GridPane();
		valeurNomEquipe = new Label("");
		grilleVainqueur.add(new Label("Nom : "), 0, 0);
		grilleVainqueur.add(valeurNomEquipe, 1, 0);
		
		valeurEntraineur = new Label("");
		
		grilleVainqueur.add(new Label("Entraineur : "), 0, 1);
		grilleVainqueur.add(valeurEntraineur, 1, 1);
		
		valeurDate = new Label("");
		
		grilleVainqueur.add(new Label("Date : "), 0, 2);
		grilleVainqueur.add(valeurDate, 1, 2);
		
		valeurCapitaine = new Label("");
		
		grilleVainqueur.add(new Label("Capitaine : "), 0, 3);
		grilleVainqueur.add(valeurCapitaine, 1, 3);	
		
		panneau.getChildren().add(grilleVainqueur);		

	}
	
	public void afficherVainqueur(Vainqueur vainqueur)
	{
		this.valeurNomEquipe.setText(vainqueur.getNomEquipe());
		this.valeurEntraineur.setText(vainqueur.getEntraineur());
		this.valeurDate.setText(vainqueur.getDate());
		this.valeurCapitaine.setText(vainqueur.getCapitaine());	
		
	}
}