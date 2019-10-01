package chapter10.circletest;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane.Divider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable {

	@FXML private Circle circle;
	@FXML private AnchorPane ancPane;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		circle.centerXProperty().bind(Bindings.divide(ancPane.widthProperty(),2));
		circle.centerYProperty().bind(Bindings.divide(ancPane.heightProperty(),2));
		
		
	}

}
