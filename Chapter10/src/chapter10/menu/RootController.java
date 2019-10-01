package chapter10.menu;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
	
	@FXML private TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void handlerNewFileAction(ActionEvent e) {
		textArea.appendText("new File \n");
	}

	public void handlerOpenFileAction(ActionEvent e) {
		textArea.appendText("open File \n");
	}

	public void handlerSaveFileAction(ActionEvent e) {
		textArea.appendText("save File \n");
	}
	
	public void handlerExitFileAction(ActionEvent e) {
		Platform.exit();
	}
}
