package vue;

import action.ControleurVainqueur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import modele.Distinction;

public class VueAjouterDistinction extends Scene {
	protected TextField valeurTitre;
	protected TextField valeurDescription;
	protected TextField valeurPrix;
	private ControleurVainqueur controleur = null;
	protected Button actionEnregistrerVainqueur = null;
	

	public VueAjouterDistinction() {
		super(new VBox(), 600, 500);
		VBox panneau = (VBox) this.getRoot();
		GridPane grilleVainqueur = new GridPane();
		
		this.actionEnregistrerVainqueur = new Button("Enregistrer");
		
		this.actionEnregistrerVainqueur.setOnAction(new EventHandler<ActionEvent>() {
 			@Override
			public void handle(ActionEvent arg0) {
				
				controleur.notifierEnregistrerNouveauVainqueur();
				
			}});
		
		valeurTitre = new TextField();
		grilleVainqueur.add(new Label("Titre : "), 0, 0);
		grilleVainqueur.add(valeurTitre, 1, 0);
		
		valeurDescription = new TextField("");
		grilleVainqueur.add(new Label("Description : "), 0, 1);
		grilleVainqueur.add(valeurDescription, 1, 1);
		valeurPrix = new TextField("");
		grilleVainqueur.add(new Label("Prix : "), 0, 2);
		grilleVainqueur.add(valeurPrix, 1, 2);		
		
		panneau.getChildren().add(new Label("Ajouter un vainqueur")); 
		panneau.getChildren().add(grilleVainqueur);
		panneau.getChildren().add(this.actionEnregistrerVainqueur);		
	}
	
	public Distinction demanderVainqueur()
	{
		Distinction distinction = new Distinction(
				this.valeurTitre.getText(), 
				this.valeurDescription.getText(), 
				this.valeurPrix.getText(),
				1);
				return distinction ;
	}
	public void setControleur(ControleurVainqueur controleur) {
		this.controleur = controleur;
	}
 }
