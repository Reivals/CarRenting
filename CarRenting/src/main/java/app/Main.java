package app;

import databse.Connect;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Managment System");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		Scene scene = new Scene((Pane)loader.load(),1800,900);
		Connect.function();
		stage.setScene(scene);
		stage.show();
		
	}

}
