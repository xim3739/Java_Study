package chapter10.bind.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
	@FXML
	private Label textLabel1;
	@FXML
	private Label textLabel2;
	@FXML
	private TextArea textArea1;
	@FXML
	private TextArea textArea2;
	@FXML
	private Button bindButton;
	@FXML
	private Button unBindButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bindButton.setOnAction((e) -> {
				Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		});
		
		unBindButton.setOnAction((e) -> {
				Bindings.unbindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		});
	}

}
