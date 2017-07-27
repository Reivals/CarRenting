package app;

import controller.AddNewCarController;
import controller.CustomerListController;
import controller.DealListController;
import controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Car;
import model.Customer;
import model.Deal;

public class Main extends Application {

	
	private Car carModel = new Car();
	private Customer customerModel = new Customer();
	private Deal dealModel = new Deal();
	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Managment System");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Main.fxml"));
		MainController mainController = new MainController(carModel, customerModel, dealModel);
		loader.setController(mainController);
		Scene scene = new Scene((Pane)loader.load(),1800,900);
		stage.setScene(scene);
		stage.show();
		
	}

}
