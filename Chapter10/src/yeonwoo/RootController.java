package yeonwoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {

	@FXML
	private Button score;
	@FXML
	private Button login;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		score.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane stP = null;
				AnchorPane anP = null;
				try {
					anP = FXMLLoader.load(getClass().getResource("score.fxml"));
					stP = (StackPane) score.getScene().getRoot();
					stP.getChildren().add(anP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		login.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane stP = null;
				AnchorPane anP = null;
				try {
					anP = FXMLLoader.load(getClass().getResource("login.fxml"));
					stP = (StackPane) login.getScene().getRoot();
					stP.getChildren().add(anP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
