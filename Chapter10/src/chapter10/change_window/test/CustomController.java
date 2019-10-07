package chapter10.change_window.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class CustomController implements Initializable {
	@FXML
	private Button btToMain;
	@FXML
	private Button btRemove;
	@FXML
	private Button btAvg;
	@FXML
	private Button btTotal;
	@FXML
	private TextField tfKorean;
	@FXML
	private TextField tfEnglish;
	@FXML
	private TextField tfMusic;
	@FXML
	private Label lbTotal;
	@FXML
	private Label lbAvg;
	@FXML
	private AnchorPane paneAnchor;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btToMain.setOnAction((e) -> {
			buttonToMain(e);
		});

		btTotal.setOnAction((e1) -> {
			int sum = Integer.parseInt(tfKorean.getText()) + Integer.parseInt(tfEnglish.getText())
					+ Integer.parseInt(tfMusic.getText());
			lbTotal.setText(String.valueOf(sum));

		});

		btAvg.setOnAction((e2) -> {
			int sum = Integer.parseInt(tfKorean.getText()) + Integer.parseInt(tfEnglish.getText())
					+ Integer.parseInt(tfMusic.getText());
			int avg = sum / 3;
			lbAvg.setText(String.valueOf(avg));

		});

		btRemove.setOnAction((e1) -> {
			tfKorean.setText("");
			tfEnglish.setText("");
			tfMusic.setText("");
			lbAvg.setText("");
			lbTotal.setText("");
		});
	}

	private void buttonToMain(ActionEvent e) {
		StackPane paneStack = (StackPane) btToMain.getScene().getRoot();
		paneStack.getChildren().remove(paneAnchor);
	}
	//현재의 루트 컨테이너를 가져온다.
	//루트 컨테이너에 속해있는 컨트롤들을 가지고 얻어온다.
	//buttonToMain 에서 getScene을 통해 버튼이 들어가 있는 해당 Scene을 가져오고 getRoot()를 통해서 루트 컨테이너를 가져온다.
	//구해온 루트 컨트롤러에서 getChildren()을 이용해서 StackPane에 있는 하위 컨테이너들을 선택하고 remove()를 통해서 지운다.

}
