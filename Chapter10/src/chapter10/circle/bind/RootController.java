package chapter10.circle.bind;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class RootController implements Initializable{
	@FXML
	private AnchorPane anchorPaneDivide;
	@FXML
	private Circle circle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		circle.centerXProperty().bind(Bindings.divide(anchorPaneDivide.widthProperty(), 2));
		circle.centerYProperty().bind(Bindings.divide(anchorPaneDivide.heightProperty(), 2));
		
	}
}
