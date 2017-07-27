package controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Car;
import model.Customer;
import model.Deal;
import pdf.CreatingPDF;

public class MainController {
	
	private Car carModel = new Car();
	private Customer customerModel = new Customer();
	private Deal dealModel = new Deal();
	@FXML
    private Button addVehicleButton;
	
	@FXML
	private BorderPane borderPane;

    @FXML
    private Button showClientDatabaseButton;

    @FXML
    private TableColumn<Car, Integer> idColumn;

    @FXML
    private TableColumn<Car, String> brandColumn;

    @FXML
    private TableColumn<Car, String> engineColumn;

    @FXML
    private TableColumn<Car, Boolean> naviColumn;

    @FXML
    private TableColumn<Car, Double> fuelColumn;

    @FXML
    private TableColumn<Car, Integer> powerColumn;

    @FXML
    private TableColumn<Car, Boolean> availableColumn;

    @FXML
    private TableView<Car> tableView;
    @FXML
    private TextField nameTextField;
    
    @FXML
    private Button openCarListButton;

    @FXML
    private TextField surnameTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField localNumberTextField;
    
    @FXML
    private Button showContractsButton;

    @FXML
    private TextField postCodeTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private Button acceptButton;

    @FXML
    private Button clearButton;
    

    @FXML
    void acceptButtonClicked(ActionEvent event) throws DocumentException, IOException {
    	try {
    	CreatingPDF.doc(tableView.getSelectionModel().getSelectedItem().getId(), 
    			tableView.getSelectionModel().getSelectedItem().getBrand(), 
    			tableView.getSelectionModel().getSelectedItem().getEngine(), 
    			tableView.getSelectionModel().getSelectedItem().getNavi(), 
    			tableView.getSelectionModel().getSelectedItem().getAvailable(), 
    			tableView.getSelectionModel().getSelectedItem().getLiters(),
    			tableView.getSelectionModel().getSelectedItem().getPower(), 
    			customerModel.getName(), 
    			customerModel.getSurname(), 
    			customerModel.getCity(),
    			customerModel.getStreet(), 
    			customerModel.getLocalNumber(), 
    			customerModel.getPostCode(),
    			customerModel.getId() );
    	
    	Car car = new Car(tableView.getSelectionModel().getSelectedItem().getId(), 
    			tableView.getSelectionModel().getSelectedItem().getBrand(), 
    			tableView.getSelectionModel().getSelectedItem().getEngine(), 
    			tableView.getSelectionModel().getSelectedItem().getNavi().toString(), 
    			tableView.getSelectionModel().getSelectedItem().getAvailable().toString(), 
    			tableView.getSelectionModel().getSelectedItem().getLiters(),
    			tableView.getSelectionModel().getSelectedItem().getPower());
    	
    	if(customerModel.getName()==null || customerModel.getSurname()==null || customerModel.getCity()==null || customerModel.getStreet()==null ||
    			customerModel.getLocalNumber()==null ||	customerModel.getPostCode()==null || customerModel.getId()==null)
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("You may left some data empty!");
    		alert.setHeaderText("Empty data!");
    		alert.showAndWait();
    	}
    	else {
    			Desktop desktop = Desktop.getDesktop();
    			File file = new File(customerModel.getName()+"_"+customerModel.getSurname()+"_"+"Contract.pdf");
    			desktop.open(file);
    			Customer newCustomer = new Customer(customerModel.getName(),
    					customerModel.getSurname(),
    					customerModel.getCity(),
    					customerModel.getStreet(),
    					customerModel.getLocalNumber(),
    					customerModel.getPostCode(),
    					customerModel.getId());
    			customerModel.getObservableList().add(newCustomer);
    			Deal deal = new Deal(newCustomer,car);
    			dealModel.getObservableList().add(deal);
    		}
    	}
    	catch(Exception e)
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("Please select car you want to rent");
    		alert.showAndWait();
    		
    	}
    }

    @FXML
    void clearButtonClicked(ActionEvent event) {
    	nameTextField.setText("");
    	surnameTextField.setText("");
    	cityTextField.setText("");
    	streetTextField.setText("");
    	localNumberTextField.setText("");
    	postCodeTextField.setText("");
    	idTextField.setText("");

    }
    
    @FXML
    public void initialize()
    {
    	
    	idColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("id"));
    	engineColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("engine"));
    	brandColumn.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
    	naviColumn.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("navi"));
    	availableColumn.setCellValueFactory(new PropertyValueFactory<Car, Boolean>("available"));
    	powerColumn.setCellValueFactory(new PropertyValueFactory<Car, Integer>("power"));
    	fuelColumn.setCellValueFactory(new PropertyValueFactory<Car, Double>("liters"));
    	carModel.getObservableList().add(new Car(213,"FIAT","1.9 JTD",true,true,32.4,132));
    	
    	
    	nameTextField.textProperty().bindBidirectional(customerModel.getNameSimpleStringProp());
    	surnameTextField.textProperty().bindBidirectional(customerModel.getSurnameSimpleStringProp());
    	cityTextField.textProperty().bindBidirectional(customerModel.getCitySimpleStringProp());
    	streetTextField.textProperty().bindBidirectional(customerModel.getStreetSimpleStringProp());
    	localNumberTextField.textProperty().bindBidirectional(customerModel.getLocalNumberSimpleStringProp());
    	postCodeTextField.textProperty().bindBidirectional(customerModel.getPostCodeSimpleStringProp());
    	idTextField.textProperty().bindBidirectional(customerModel.getIdSimpleStringProp());
    	
    	
    	
    	tableView.setItems(carModel.getObservableList());
    	
    }
    @FXML
    public void addNewVehicleButtonClicked() throws IOException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddNewCar.fxml"));
    	Stage stage = new Stage();
    	Scene scene = new Scene((Pane)loader.load());
    	stage.setScene(scene);
    	stage.show();
    	AddNewCarController addNewCarController = loader.getController();
    	addNewCarController.initData(carModel);
    	addNewCarController.comboBoxSelectedInitialialy();
    	
    }
    @FXML
    public void showClientDatabaseButtonClicked() throws IOException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CustomerList.fxml"));
    	Scene scene = new Scene((Pane)loader.load());
    	CustomerListController customerListController = loader.getController();
    	customerListController.initData(customerModel);
    	customerListController.asad();
    	borderPane.setLeft(customerListController.getTableView());
    }
    @FXML
    public void openCarList()
    {
    	if(!borderPane.getLeft().equals(tableView))
    	{
    		borderPane.setLeft(tableView);
    	}
    }
    @FXML
    public void showContractsButtonClicked() throws IOException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/DealsList.fxml"));
    	Scene scene = new Scene((Pane)loader.load());
    	DealListController dealListController = loader.getController();
    	dealListController.initData(dealModel);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	
    }


}
