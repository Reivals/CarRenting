package controller;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import model.Deal;

public class DealListController {
	
	private Deal modelDeal;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ListView<Deal> listView;

    

	public void initData(Deal dealModel) {
		this.modelDeal=dealModel;
		listView.setItems(modelDeal.getObservableList());
		
	}

}
