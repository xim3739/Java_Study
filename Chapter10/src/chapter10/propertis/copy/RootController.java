package chapter10.propertis.copy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
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
	private double value = 0;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		slider.setOnMouseDragged((e) -> {
				value = slider.getValue();
				label.setFont(new Font(value));
		});

	}

}
