package chapter10.change_window.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {
	@FXML AnchorPane paneAnchor;
	@FXML Button btToMain;
	@FXML Button btLogin;
	@FXML Button btCancle;
	@FXML TextField tfId;
	@FXML TextField tfPassoword;
	@FXML TextArea textArea;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btToMain.setOnAction((e) -> {
			buttonToMainAction(e);
		});
		
		btLogin.setOnAction((e1) -> {
			String id = tfId.getText();
			String password = tfPassoword.getText();
			textArea.setText(id + "\n" + password);
		});
		
	}// end of initialize

	private void buttonToMainAction(ActionEvent e) {
		StackPane paneStack = (StackPane) btToMain.getScene().getRoot();
		paneStack.getChildren().remove(paneAnchor);
	}

}// end of LoginController
