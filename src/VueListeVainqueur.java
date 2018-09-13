import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import java.util.List;
import javafx.scene.control.Label;


 public class VueListeVainqueur extends Scene {
 	
	 protected GridPane grilleVainqueurs;
	 
	public VueListeVainqueur() {
		super(new Pane(), 600,500);
		Pane panneau = (Pane) this.getRoot();
		grilleVainqueurs = new GridPane();		
		
		panneau.getChildren().add(grilleVainqueurs);
		}
		
		public void afficherListeVainqueurs(List<Vainqueur> listeVainqueurs)
		{
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
 