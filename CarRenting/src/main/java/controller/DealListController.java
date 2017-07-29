package controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Deal;
import pdf.Open;

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
		listView.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {

            if( e.isPrimaryButtonDown()) {
            	if(listView.getSelectionModel().getSelectedItem() != null)
            	{
	        	Open.openPdfFile(listView.getSelectionModel().getSelectedItem().getCustomer().getName()+"_"+
	        	listView.getSelectionModel().getSelectedItem().getCustomer().getSurname()+"_Contract.pdf");
            	}
            } 

        });
		
				listView.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
		      if(key.getCode()==KeyCode.DELETE) {
		    	  removeDealConfirmationMessage();
		    	  listView.getSelectionModel().getSelectedItem().getCar().setAvailable(true);
		      }
		});

    }
    
	public  void removeDealConfirmationMessage()
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RemoveConfirmationDialog.fxml"));
		Stage stage = new Stage();
		
		try {
			RemoveConfirmationDialogController removerConfirmationDialogController = new RemoveConfirmationDialogController(dealModel,listView.getSelectionModel().getSelectedItem());
			loader.setController(removerConfirmationDialogController);
			Scene scene = new Scene((Pane)loader.load());

			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
