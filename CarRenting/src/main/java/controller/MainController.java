package controller;

import java.io.IOException;
import com.itextpdf.text.DocumentException;
import dialogs.Dialogs;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ListChangeListener.Change;
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
import pdf.Open;

public class MainController {
	
	private Car carModel;
	private Customer customerModel;
	private Deal dealModel;
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
    
    public MainController(Car carModel,Customer customerModel,Deal dealModel)
    {
		this.carModel=carModel;
		this.customerModel=customerModel;
		this.dealModel=dealModel;
    	
    }

    @FXML
    void acceptButtonClicked(ActionEvent event) throws DocumentException, IOException {
    	try
    	{
    	if(tableView.getSelectionModel().getSelectedItem().getAvailable()=="YES")
    	{
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

    	if(customerModel.getName()==null || customerModel.getSurname()==null || customerModel.getCity()==null || customerModel.getStreet()==null ||
    			customerModel.getLocalNumber()==null ||	customerModel.getPostCode()==null || customerModel.getId()==null)
    	{
    		Alert alert = new Alert(Alert.AlertType.ERROR);
    		alert.setContentText("You may left some data empty!");
    		alert.setHeaderText("Empty data!");
    		alert.showAndWait();
    	}
    	else {
    		Open.openPdfFile(customerModel.getName()+"_"+customerModel.getSurname()+"_Contract.pdf");
    			Customer newCustomer = new Customer(customerModel.getName(),
    					customerModel.getSurname(),
    					customerModel.getCity(),
    					customerModel.getStreet(),
    					customerModel.getLocalNumber(),
    					customerModel.getPostCode(),
    					customerModel.getId());
    			customerModel.getObservableList().add(newCustomer);
    			Car car = tableView.getSelectionModel().getSelectedItem();
    			Deal deal = new Deal(newCustomer,car);
    			dealModel.getObservableList().add(deal);
    			car.setAvailable(false);
    			tableView.refresh();
    		}
    	}
    	catch(Exception e)
    	{
    		Dialogs.errorDialogMessage("Please select car you want to rent", "");
    		
    	}
    	}
    	else
    	{
    		Dialogs.informationDialogMessage("This vehicle is already taken. If you want to set it free delete contract from system", "Vehicle is already taken");
    	}
    	}
    	catch(Exception e)
    	{
    		Dialogs.errorDialogMessage("Please select car you want to rent", "");
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
    	availableColumn.setCellValueFactory(cellData -> cellData.getValue().getAvailableProperty()); // TEZ TAK MOZNA!! -> Powiazanie bezposrednie
    	//ale wyswietli nam true/false zamiast "YES"/"NO" dlatego zostawiam ponizsze rozwiazanie
    	
    	tableView.setItems(carModel.getObservableList());
    	carModel.getObservableList().addListener((Change<? extends Car> c) -> {
    		tableView.refresh();
         });
    	
    	
    }
    @FXML
    public void addNewVehicleButtonClicked() throws IOException, InterruptedException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AddNewCar.fxml"));
    	AddNewCarController addNewCarController = new AddNewCarController(carModel);
    	loader.setController(addNewCarController);
    	Stage stage = new Stage();
    	Scene scene = new Scene((Pane)loader.load());
    	stage.setScene(scene);
    	stage.sizeToScene();
    	stage.show();
    	
    	
    }
    @FXML
    public void showClientDatabaseButtonClicked() throws IOException
    {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/CustomerList.fxml"));
    	CustomerListController customerListController = new CustomerListController(customerModel);
    	loader.setController(customerListController);
    	Scene scene = new Scene((Pane)loader.load());
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
    	DealListController dealListController = new DealListController(dealModel);
    	loader.setController(dealListController);
    	Scene scene = new Scene((Pane)loader.load());
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.show();
    	
    }


}
