package vue;
import action.ControleurVainqueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import modele.Vainqueur;


public class VueEditerVainqueur extends Scene {
 	protected TextField valeurNomEquipe;
	protected TextField valeurDate;
	protected TextField valeurEntraineur;
	protected TextField valeurCapitaine;
	
	private ControleurVainqueur controleur = null;
	protected Button actionEnregistrerVainqueur = null;
	
	public VueEditerVainqueur()  {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleVainqueur = new GridPane();
		this.actionEnregistrerVainqueur = new Button("Enregistrer");
		
		this.actionEnregistrerVainqueur.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerVainqueur();
				
			}});
		
		valeurNomEquipe = new TextField();
		grilleVainqueur.add(new Label("Nom de l'equipe : "), 0, 0);
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

		panneau.getChildren().add(new Label("Editer un vainqueur"));
		panneau.getChildren().add(grilleVainqueur);
		panneau.getChildren().add(this.actionEnregistrerVainqueur);
	}
	
	public void afficherVainqueur(Vainqueur vainqueur)
	{
		this.valeurNomEquipe.setText(vainqueur.getNomEquipe());
		this.valeurDate.setText(vainqueur.getDate());
		this.valeurEntraineur.setText(vainqueur.getEntraineur());
		this.valeurCapitaine.setText(vainqueur.getCapitaine());
	}
	
	public Vainqueur demanderVainqueur()
	{
		Vainqueur vainqueur = new Vainqueur(this.valeurNomEquipe.getText(), 
								this.valeurDate.getText(), 
								this.valeurEntraineur.getText(), 
								this.valeurCapitaine.getText());
		return vainqueur;
	}
	
	public void setControleur(ControleurVainqueur controleur) {
		this.controleur = controleur;
	}
	
 }
