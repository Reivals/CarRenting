package dialogs;


import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Dialogs {
	
	public static void errorDialogMessage(String contentText, String header)
	{
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(contentText);
		alert.setHeaderText(header);
		alert.showAndWait();
	}
	
	public static void informationDialogMessage(String contentText, String header)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(contentText);
		alert.setHeaderText(header);
		alert.showAndWait();
	}

	


}
