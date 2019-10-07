package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField txtId;
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnCancel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(e -> {
			
			handlerButtonLoginAction(e);
			
		});

		btnCancel.setOnAction(e1 -> {
			
			handlerButtonCancleAction(e1);
			
		});
		
	}// end of initialize

	public void handlerButtonLoginAction(ActionEvent e) {
		if(txtId.getText().equals("") || txtPassword.getText().equals("")) {
			
			alertWarningDisplay(1, "Login False", "Not Input Id or Password", "Try again Id , Password");
			
		} else if(txtId.getText().equals("admin") && txtPassword.getText().equals("1234")) {
			Parent mainView = null;
			Stage mainStage = null;
			try {
				
				//mainView = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
				mainView = FXMLLoader.load(getClass().getResource("/view/view.fxml"));
				Scene scene = new Scene(mainView);
				mainStage = new Stage();
				mainStage.setTitle("MAIN");
				mainStage.setScene(scene);
				mainStage.setResizable(true);
				
				((Stage) btnCancel.getScene().getWindow()).close();
				
				mainStage.show();
				
			} catch (IOException e1) {
				alertWarningDisplay(1, "Main Window Error", "Main Window Load False", e1.toString());
			}
			
		}else {
			
			alertWarningDisplay(1, "Login False", "Not Matched Id or Password", "Try again Id , Password");
			
		}
	}// end of handlerButtonLoginAction


	public void handlerButtonCancleAction(ActionEvent e1) {
		((Stage) btnCancel.getScene().getWindow()).close();
	}// end of handlerButtonCancleAction
	
	public void alertWarningDisplay(int type, String title, String headerText, String contentText) {
		
		Alert alert = null;
		
		switch (type) {
		
		case 1:
			alert = new Alert(AlertType.WARNING);
			break;
		case 2: 
			alert = new Alert(AlertType.ERROR);
			break;
		case 3:
			alert = new Alert(AlertType.INFORMATION);
			break;
		case 4:
			alert = new Alert(AlertType.NONE);
			break;
		case 5:
			alert = new Alert(AlertType.CONFIRMATION);
			break;
		default:
			break;
			
		}
		
		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(headerText + "\n" + contentText);
		alert.setResizable(false);
		alert.showAndWait();
		
	}//end of alertWarningDisplay
}
