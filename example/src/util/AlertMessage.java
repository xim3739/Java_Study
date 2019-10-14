package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertMessage {
	
	public static void alertWarningDisplay(int type, String title, String headerText, String contentText) {

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


