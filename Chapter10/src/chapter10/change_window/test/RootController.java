package chapter10.change_window.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {
	@FXML private StackPane paneStack;
	@FXML private Button buttonScore;
	@FXML private Button buttonLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonLogin.setOnAction((e)->{
			buttonLoginAction(e);	
		});
		buttonScore.setOnAction((e1)-> {
			buttonScoreAction(e1);	
		});
		
	} // end of initialize
	// 로그인 화면을 보여주는 이벤트 처리 방식

	public void buttonScoreAction(ActionEvent e1) {
		AnchorPane paneAnchorScore = null;
		StackPane paneStack = null;
		try {
			paneStack = (StackPane) buttonScore.getScene().getRoot();
			paneAnchorScore = FXMLLoader.load(getClass().getResource("custom_window.fxml"));
			paneStack.getChildren().add(paneAnchorScore);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void buttonLoginAction(ActionEvent e) {
		AnchorPane panAnchorLogin = null;
		StackPane paneStack = null;
		try {
			paneStack = (StackPane) buttonLogin.getScene().getRoot();
			panAnchorLogin = FXMLLoader.load(getClass().getResource("login_window.fxml"));
			paneStack.getChildren().add(panAnchorLogin);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}// end of RootController
