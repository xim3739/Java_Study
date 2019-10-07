package yeonwoo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class LoginController implements Initializable {
	@FXML
	private AnchorPane anPL;
	@FXML
	private Button btMain;
	@FXML
	private Button btScore;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btMain.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane stack = (StackPane) btMain.getScene().getRoot();
				stack.getChildren().remove(anPL);
			}
		});

		btScore.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane stack = (StackPane) btMain.getScene().getRoot();
				stack.getChildren().remove(anPL);
			}
		});
	}

}
