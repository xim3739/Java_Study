package chapter10.propertis;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;

public class RootController implements Initializable {
	@FXML
	private Label label;
	@FXML
	private Slider slider;
	//id를 멤버로 가져온다.
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				
				label.setFont(new Font(newValue.doubleValue()));
			}
		});
		//slider 이벤트를 등록하고 정의한다.

	}

}
