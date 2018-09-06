import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class VueVainqueurs extends Application{
 @Override
	public void start(Stage stade) throws Exception {
	 	Pane panneau = new Pane();
		stade.setScene(new Scene(panneau, 600, 500));
		stade.show();
	}
}