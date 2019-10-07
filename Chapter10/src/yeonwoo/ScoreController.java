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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class ScoreController implements Initializable {
	@FXML
	private AnchorPane anP;
	@FXML
	private TextField tfKor;
	@FXML
	private TextField tfEng;
	@FXML
	private TextField tfMath;
	@FXML
	private TextField tfTotal;
	@FXML
	private TextField tfAver;
	@FXML
	private Button btTotal;
	@FXML
	private Button btAver;
	@FXML
	private Button btRe;
	@FXML
	private Button btLogin;
	@FXML
	private Button btMain;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btTotal.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int sum = Integer.parseInt(tfKor.getText()) + Integer.parseInt(tfEng.getText())
						+ Integer.parseInt(tfMath.getText());
				tfTotal.setText(String.valueOf(sum));

			}
		});

		btAver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				int sum = Integer.parseInt(tfKor.getText()) + Integer.parseInt(tfEng.getText())
						+ Integer.parseInt(tfMath.getText());
				tfTotal.setText(String.valueOf(sum));
				int aver = sum / 3;
				tfAver.setText(String.valueOf(aver));

			}
		});
		btRe.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tfKor.setText(null);
				tfEng.setText(null);
				tfMath.setText(null);
				tfTotal.setText(null);
				tfAver.setText(null);

			}
		});
		btMain.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				StackPane stack = (StackPane) btMain.getScene().getRoot();
				stack.getChildren().remove(anP);

			}
		});
		btLogin.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				AnchorPane log = null;
				StackPane sta = null;
				try {
					log = (AnchorPane) FXMLLoader.load(getClass().getResource("login.fxml"));
					sta = (StackPane) btLogin.getScene().getRoot();
					sta.getChildren().add(log);
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});

	}

}
