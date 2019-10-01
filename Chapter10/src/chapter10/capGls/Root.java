package chapter10.capGls;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Root implements Initializable {

	@FXML private CheckBox glasses;
	@FXML private CheckBox cap;
	@FXML private ImageView imageV;
	@FXML private ImageView imageVV;
	@FXML private RadioButton radOne;
	@FXML private RadioButton radTwo;
	@FXML private RadioButton radTh;
	@FXML private Button button;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
				
			}
		});
	
		
	}
	public  void handleCheckBoxAction(ActionEvent e) {
		if(glasses.isSelected() &&cap.isSelected()) {
			imageV.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
		}else if(glasses.isSelected()) {
			imageV.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
		}else if(cap.isSelected()) {
			imageV.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
		}else {
			imageV.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
		}
	}
	public void handleGroupAction() {
		if(radOne.isSelected()) {
			imageVV.setImage(new Image(getClass().getResource("images/bubbleChart.png").toString()));
		}else if(radTwo.isSelected()) {
			imageVV.setImage(new Image(getClass().getResource("images/barChart.png").toString()));
		}else {
			imageVV.setImage(new Image(getClass().getResource("images/areaChart.png").toString()));
		}
	}
	
	

}
