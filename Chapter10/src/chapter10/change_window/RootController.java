package chapter10.change_window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {

	@FXML
	private Button buttonLogin;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonLogin.setOnAction((e) -> {

			handleButtonLoginAction(e);

		});// end of setOnAction

	} // end of initialize
	// 로그인 화면을 보여주는 이벤트 처리 방식

	public void handleButtonLoginAction(ActionEvent e) {

		StackPane paneStack = null; 
		AnchorPane paneAnchor = null;
		try {
			
			paneStack = (StackPane) buttonLogin.getScene().getRoot();
			paneAnchor = FXMLLoader.load(getClass().getResource("login.fxml"));
			paneStack.getChildren().add(paneAnchor);
			
		} catch (IOException e1) {
			
			e1.printStackTrace();
			
		}// end of catch

	}// end of handleButtonLoginAction

}// end of RootController
