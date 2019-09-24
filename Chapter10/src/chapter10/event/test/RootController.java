package chapter10.event.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RootController implements Initializable {
	@FXML private Label labelMessage;
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;
	//멤버 변수 선언한다. 화면에서 설계한 모든 객체는 여기 선언되어야 한다.
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				String text = button1.getText();
				labelMessage.setText(text);
			}
		});
		//임시 객체 방식
		
		button2.setOnAction((e) -> {
			String text = button2.getText();
			labelMessage.setText(text);
		});
		//람다식 방식
		
		button3.setOnAction((e) -> handlerButton3Action(e));
		//핸들러 처리 방식
		
	}
	//여기서 이벤트 처리 하면 된다.
	
	public void handlerButton3Action(ActionEvent e) {
		String text = button3.getText();
		labelMessage.setText(text);
	}
}
