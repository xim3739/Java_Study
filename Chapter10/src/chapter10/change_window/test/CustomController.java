package chapter10.change_window.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class CustomController implements Initializable{
	@FXML private Button btToMain;
	@FXML private Button btRemove;
	@FXML private Button btAvg;
	@FXML private Button btTotal;
	@FXML private TextField tfKorean;
	@FXML private TextField tfEnglish;
	@FXML private TextField tfMusic;
	@FXML private Label lbTotal;
	@FXML private Label lbAvg;
	@FXML private AnchorPane paneAnchor;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btToMain.setOnAction((e) -> {
			buttonToMain(e);
		});
		
		btTotal.setOnAction((e1) -> {
			int sum = Integer.parseInt(tfKorean.getText()) + Integer.parseInt(tfEnglish.getText()) + Integer.parseInt(tfMusic.getText());
			lbTotal.setText(String.valueOf(sum));
			
		});
		
		btAvg.setOnAction((e2) -> {
			int sum = Integer.parseInt(tfKorean.getText()) + Integer.parseInt(tfEnglish.getText()) + Integer.parseInt(tfMusic.getText());
			int avg = sum / 3;
			lbAvg.setText(String.valueOf(avg));
			
		});
		
		btRemove.setOnAction((e1) -> {
			tfKorean.setText("");
			tfEnglish.setText("");
			tfMusic.setText("");
			lbAvg.setText("");
			lbTotal.setText("");
		});
	}
	private void buttonToMain(ActionEvent e) {
		StackPane paneStack = (StackPane) btToMain.getScene().getRoot();
		paneStack.getChildren().remove(paneAnchor);
	}
	
	
}
