package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.Car;
import model.Customer;
import model.Deal;

public class DealListController {
	
	private Deal dealModel;
	
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ListView<Deal> listView;

    public DealListController(Deal dealModel)
    {
		this.dealModel=dealModel;
    	
    }
    @FXML
    public void initialize()
    {
		listView.setItems(dealModel.getObservableList());
    }


}
