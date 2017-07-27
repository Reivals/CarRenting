package controller;

import dialogs.Dialogs;
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
import model.Deal;

public class AddNewCarController {
	
	private Car carModel;
	
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

	
	
    public AddNewCarController(Car carModel)
    {
		this.carModel=carModel;
    	
    }
	

	@FXML
    void acceptButtonClicked(ActionEvent event){
    	try {
    	Car item = new Car(Integer.parseInt(idTextField.getText()),brandTextField.getText(),engineTextField.getText(), choiceBoxWhatIsSelected()
    			,true,Double.parseDouble(fuelTextField.getText()),Integer.parseInt(powerTextField.getText()));
    	carModel.getObservableList().add(item);
    	Stage stage = (Stage) comboBox.getScene().getWindow();
    	stage.close();
    	}
    	catch(Exception e)
    	{
    		Dialogs.emptyFileOrIncorrectDataMessage();
    	}

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
	
	public void comboBoxSelectedFunctionality()
	{
			idTextField.setText(Integer.toString((carModel.getObservableList().size()+1)));
			idTextField.setDisable(true);
	}
		
	@FXML
	public void initialize()
	{
		autoIncrementChekBox.setSelected(true);
		comboBoxSelectedFunctionality();
		comboBox.setItems(choiceBoxList);
		comboBox.setValue("YES");
		autoIncrementChekBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
		    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
		    	if(autoIncrementChekBox.isSelected()==true)
		    	{
		    		
					comboBoxSelectedFunctionality();

		    	}
		    	else
		    	{
		    		idTextField.setText("");
		    		idTextField.setDisable(false);
		    	}
		    }
		});

	}
	

}
