package chapte10.slidertest;

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
	@FXML private Label label;
	@FXML private Slider silder;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		silder.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			label.setFont(new Font(newValue.intValue()));
				
			}
		});

	}

}
