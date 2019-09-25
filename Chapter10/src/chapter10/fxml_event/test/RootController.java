package chapter10.fxml_event.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	@FXML private Label labelMessage;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String text = button1.getText();
				labelMessage.setText(text);
			}
		});
		
		button2.setOnAction((e) -> {
			String text = button2.getText();
			labelMessage.setText(text);
		});
		button3.setOnAction((e) -> handlerButton3Action(e));
	}
	
	public void handlerButton3Action(ActionEvent e) {
		if(labelMessage.getText().equals(button2.getText())) {
			labelMessage.setText("안녕하세요");
		}
	}

}
