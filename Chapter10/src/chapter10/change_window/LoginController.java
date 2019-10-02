package chapter10.change_window;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {

	@FXML
	private Button buttonToMain;
	@FXML
	private AnchorPane paneAnchor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonToMain.setOnAction((e) -> {

			handleButtonToMainAction(e);

		});// end of setOnAction

	}// end of initialize

	public void handleButtonToMainAction(ActionEvent e) {

		StackPane paneStack = (StackPane) buttonToMain.getScene().getRoot();
		paneStack.getChildren().remove(paneAnchor);

	}// end of handleButtonToMainAction

}// end of LoginController
