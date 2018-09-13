import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


 public class VueAjouterVainqueur extends Scene{
 	protected TextField valeurNomEquipe;
	protected TextField valeurDate;
	protected TextField valeurEntraineur;
	protected TextField valeurCapitaine;
	

	public VueAjouterVainqueur() {
		super(new VBox(), 600, 500);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleVainqueur = new GridPane();
		valeurNomEquipe = new TextField();
		grilleVainqueur.add(new Label("Nom : "), 0, 0);
		grilleVainqueur.add(valeurNomEquipe, 1, 0);
		
		valeurDate = new TextField("");
		grilleVainqueur.add(new Label("Date : "), 0, 1);
		grilleVainqueur.add(valeurDate, 1, 1);
		valeurEntraineur = new TextField("");
		grilleVainqueur.add(new Label("Entraineur : "), 0, 2);
		grilleVainqueur.add(valeurEntraineur, 1, 2);		
		valeurCapitaine = new TextField("");
		grilleVainqueur.add(new Label("Capitaine : "), 0, 3);
		grilleVainqueur.add(valeurCapitaine, 1, 3);				
		panneau.getChildren().add(new Label("Ajouter un vainqueur")); 
		panneau.getChildren().add(grilleVainqueur);
		panneau.getChildren().add(new Button("Enregistrer"));		
	}
	
	public Vainqueur demanderVainqueur()
	{
		Vainqueur vainqueur = new Vainqueur(
				this.valeurNomEquipe.getText(), 
				this.valeurDate.getText(), 
				this.valeurEntraineur.getText(),
				this.valeurCapitaine.getText());
				return vainqueur;
	}
 }
