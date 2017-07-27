package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Car;
import model.Customer;

public class AddNewCarController {
	
	private ObservableList<String> choiceBoxList = FXCollections.observableArrayList("YES","NO");
	@FXML
    private TextField idTextField;

    @FXML
    private TextField brandTextField;

    @FXML
    private TextField engineTextField;

    @FXML
    private TextField fuelTextField;

    @FXML
    private TextField powerTextField;

    @FXML
    private CheckBox autoIncrementChekBox;

    @FXML
    private Button acceptButton;

    @FXML
    private ComboBox<String> comboBox;

	private Car model;

    @FXML
    void acceptButtonClicked(ActionEvent event){
    	boolean didErrorOccured=false;
    	try {
    	Car item = new Car(Integer.parseInt(idTextField.getText()),brandTextField.getText(),engineTextField.getText(), choiceBoxWhatIsSelected(),true,Double.parseDouble(fuelTextField.getText()),Integer.parseInt(powerTextField.getText()));
    	model.getObservableList().add(item);
    	}
    	catch(Exception e)
    	{
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setContentText("Empty file / Incorrect data format. Please correct yourself!");
    		alert.setHeaderText("Ooops. Something goes wrong.");
    		alert.showAndWait();
    		didErrorOccured=true;
    	}
    	if(didErrorOccured==false)
    	{	
    	Stage stage = (Stage) comboBox.getScene().getWindow();
    	stage.close();
    	}

    }

	public void initData(Car model) {
		this.model = model;
		
	}
	
	public boolean choiceBoxWhatIsSelected()
	{
		if(comboBox.getSelectionModel().getSelectedItem()=="YES")
		{
			return true;
		}
		else
			return false;
	}
	
	public void comboBoxSelectedInitialialy()
	{
		autoIncrementChekBox.setSelected(true);
		if(autoIncrementChekBox.isSelected())
		{
			idTextField.setText(Integer.toString((model.getObservableList().size()+1)));
			idTextField.setDisable(true);
		}
		comboBox.setItems(choiceBoxList);
		comboBox.setValue("YES");
	}
	@FXML
	public void initialize()
	{
		autoIncrementChekBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    	if(newValue==false)
		    	{
		    		idTextField.setText("");
		    		idTextField.setDisable(false);
		    	}
		    	else
		    	{
		    		comboBoxSelectedInitialialy();
		    	}
		    }
		});

	}
	

}
