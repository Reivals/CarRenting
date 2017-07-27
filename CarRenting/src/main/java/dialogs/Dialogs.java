package dialogs;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Dialogs {
	
	public static void emptyFileOrIncorrectDataMessage()
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText("Empty file / Incorrect data format. Please correct yourself!");
		alert.setHeaderText("Ooops. Something goes wrong.");
		alert.showAndWait();
	}

}
