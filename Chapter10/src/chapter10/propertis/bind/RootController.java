package chapter10.propertis.bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
	@FXML
	private Label labelTextArea1;
	@FXML
	private Label labelTextArea2;
	@FXML
	private TextArea textArea1;
	@FXML
	private TextArea textArea2;
	@FXML
	private Button bindButton;
	@FXML
	private Button unBindButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bindButton.setOnAction((e) -> {
			Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		});
		// 바인드
		unBindButton.setOnAction((e) -> {
			Bindings.unbindBidirectional(textArea1.textProperty(), textArea2.textProperty());
		});
		// 언바인드

		// textArea2.textProperty().bindBidirectional(textArea1.textProperty());
		// Bindings.bindBidirectional(textArea1.textProperty(),
		// textArea2.textProperty());
		// 양방향 바인드

		// textArea2.textProperty().bind(textArea1.textProperty());
		// 한방향 바인드

//		textArea2.setOnKeyReleased(new EventHandler<Event>() {
//
//			@Override
//			public void handle(Event event) {
//				String sendData = textArea2.getText();
//				textArea1.setText(sendData);
//			}
//		});
//		익명객체

//		textArea1.setOnKeyReleased((e) -> {
//			int count = textArea1.getLength();
//			String sendData = textArea1.getText(count - 1, count);
//			textArea2.setText(sendData);
//		});
//		람다식

	}

}
