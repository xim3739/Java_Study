package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BordController implements Initializable {
	
	@FXML private AnchorPane anchoPane;
	@FXML private GridPane bord;
	@FXML private MouseEvent mouseEvent;
	private Circle circle = new Circle();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		anchoPane.setOnMouseClicked(e -> bordClickAciont(e));
		
	}

	private void bordClickAciont(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
		
		circle.setRadius(20.0);
		circle.setLayoutX(e.getX());
		circle.setLayoutX(e.getY());
		circle.setFill(Color.BLACK);
		//circle.setVisible(true);
		
		anchoPane.setShape(circle);
		
		
		
	
	}

}
