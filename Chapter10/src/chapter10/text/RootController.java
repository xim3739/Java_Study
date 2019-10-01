package chapter10.text;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class RootController implements Initializable{

	@FXML TextArea textA;
	@FXML TextArea textB;
	@FXML Button buttonOne;
	@FXML Button buttonTwo;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textA.textProperty().bindBidirectional(textB.textProperty());
		
	}
	public void onActionHandler() {
		
		buttonOne.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				textA.textProperty().bindBidirectional(textB.textProperty());
				
			}
		} );;
		
	}
	
	public void onActionHandlerTwo() {
		textA.textProperty().unbindBidirectional(textB.textProperty());
	}

}
