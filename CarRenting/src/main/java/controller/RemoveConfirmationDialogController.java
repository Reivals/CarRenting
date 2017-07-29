package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import model.Deal;

public class RemoveConfirmationDialogController {
		
		private Deal dealModel;
		private Deal dealToRemove;
		@FXML
	    private BorderPane borderPane;

		@FXML
		private Label labalIncorrectData;
	    @FXML
	    private Button yesButton;

	    @FXML
	    private Button noButton;
	    
	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private Button acceptButton;
	    
	    public RemoveConfirmationDialogController(Deal dealModel, Deal dealToRemove)
	    {
	    	this.dealModel=dealModel;
	    	this.dealToRemove=dealToRemove;
	    }

	    @FXML
	    void acceptButtonPressed(ActionEvent event) {
	    	if(passwordField.getText().equals("admin"))
	    	{
	    		dealModel.getObservableList().remove(dealToRemove);
	    		acceptButton.getScene().getWindow().hide();
	    	}
	    	else
	    	{
	    		labalIncorrectData.setVisible(true);
	    	}

	    }

	    @FXML
	    void noButtonPressed(ActionEvent event) {
	    	noButton.getScene().getWindow().hide();

	    }

	    @FXML
	    void yesButtonPressed(ActionEvent event) {
	    	passwordField.setVisible(true);
	    	acceptButton.setVisible(true);
	    
	    }
	    

}
