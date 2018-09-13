package vue;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import modele.Vainqueur;

import java.util.List;

import javafx.scene.control.Label;


 public class VueListeVainqueur extends Scene {
 	
	 protected GridPane grilleVainqueurs;
	 
	public VueListeVainqueur() {
		super(new GridPane(), 600,500);
		grilleVainqueurs = (GridPane) this.getRoot();
		}
		
		public void afficherListeVainqueurs(List<Vainqueur> listeVainqueurs)
		{
			this.grilleVainqueurs.getChildren().clear();
			int numero = 0;
			this.grilleVainqueurs.add(new Label("Nom Equipe"), 0, numero);
			this.grilleVainqueurs.add(new Label("Date"), 1, numero);
			for(Vainqueur vainqueur : listeVainqueurs)
			{
				numero++;
				this.grilleVainqueurs.add(new Label(vainqueur.getNomEquipe()), 0, numero);
				this.grilleVainqueurs.add(new Label(vainqueur.getDate()), 1, numero);				
			}
		}
}
 