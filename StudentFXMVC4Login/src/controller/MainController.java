package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class MainController implements Initializable {

	@FXML
	private TextField txtName;
	@FXML
	private Button btnInsert;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnEnd;
	@FXML
	private Button btnOk;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnInsert.setOnAction((e) -> {
			handlerButtonInsertAction(e);
		});
		btnDelete.setOnAction((e1) -> {
			handlerButtonDeletetAction(e1);
		});
		btnEnd.setOnAction((e2) -> {
			handlerButtonEndAction(e2);
		});
		btnOk.setOnAction((e3) -> {
			handlerButtonOkAction(e3);
		});
	}

	public void handlerButtonInsertAction(ActionEvent e) {

		alertWarningDisplay(3, "Insert Information", "Name Data Insert Sucess!!" + "\n" + txtName.getText(), "welcome");

	}// end of handlerButtonInsertAction

	public void handlerButtonDeletetAction(ActionEvent e1) {

		alertWarningDisplay(5, "Delete Name", "Delete" + "\n" + txtName.getText(), "Delete");

	}// end of handlerButtonDeletetAction

	public void handlerButtonEndAction(ActionEvent e2) {

		alertWarningDisplay(5, "End Login", "END" + "\n" + txtName.getText(), "Bye");

	}// end of handlerButtonEndAction

	public void handlerButtonOkAction(ActionEvent e3) {

		alertWarningDisplay(5, "확인", "확인" + "\n" + txtName.getText(), "확인");

	}// end of handlerButtonOkAction

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

	}// end of alertWarningDisplay

}
