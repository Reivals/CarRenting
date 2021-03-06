package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Customer;

public class CustomerListController {

	private Customer customerModel;
	 	@FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private TableView<Customer> tableView;

	    @FXML
	    private TableColumn<Customer, String> nameTableColumn;

	    @FXML
	    private TableColumn<Customer, String> surnameTableColumn;

	    @FXML
	    private TableColumn<Customer, String> cityTableColumn;

	    @FXML
	    private TableColumn<Customer, String> streetTableColumn;

	    @FXML
	    private TableColumn<Customer, String> localNumberTableColumn;

	    @FXML
	    private TableColumn<Customer, String> postCodeTableColumn;

	    @FXML
	    private TableColumn<Customer, String> idTableColumn;

		public TableView<Customer> getTableView() {
			return tableView;
		}

		public void setTableView(TableView<Customer> tableView) {
			this.tableView = tableView;
		}
		
	    public CustomerListController(Customer customerModel)
	    {
			this.customerModel=customerModel;
	    	
	    }
		
		@FXML
		public void initialize()
		{
			tableView.setItems(customerModel.getObservableList());
			nameTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
			surnameTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("surname"));
			cityTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("city"));
			streetTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("street"));
			localNumberTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("localNumber"));
			postCodeTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("postCode"));
			idTableColumn.setCellValueFactory(new PropertyValueFactory<Customer, String>("id"));
		}
		

}
