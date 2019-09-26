package chapter10.button_tool;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
	@FXML
	private CheckBox checkBoxGlasses;
	@FXML
	private CheckBox checkBoxHat;
	@FXML
	private ImageView checkBoxImage;
	@FXML
	private RadioButton radioButtonBubble;
	@FXML
	private RadioButton radioButtonBar;
	@FXML
	private RadioButton radioButtonArea;
	@FXML
	private ImageView radioButtonImage;
	@FXML
	private Button exitButton;
	@FXML
	private ImageView exitImage;
	@FXML
	private Separator separator;
	@FXML
	private ToggleGroup group;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//
//			@Override
//			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
//				Image image = new Image(getClass().getResource("images/" + newValue.getUserData().toString() + ".png").toString());
//				radioButtonImage.setImage(image);
//			}
//		});
	}
	
	public void handlerExitButtonAction(ActionEvent event) {
		Platform.exit();
	}

	public void handlerCheckBoxAction(ActionEvent event) {
		
		if(checkBoxGlasses.isSelected() && checkBoxHat.isSelected()) {
			checkBoxImage.setImage(new Image(getClass().getResource("images/geek-glasses-hair.gif").toString()));
		} else if(checkBoxGlasses.isSelected()) {
			checkBoxImage.setImage(new Image(getClass().getResource("images/geek-glasses.gif").toString()));
		} else if(checkBoxHat.isSelected()) {
			checkBoxImage.setImage(new Image(getClass().getResource("images/geek-hair.gif").toString()));
		} else {
			checkBoxImage.setImage(new Image(getClass().getResource("images/geek.gif").toString()));
		}
	}//end of handlerCheckBoxAction
	
	public void handlerRadioButtonAction(ActionEvent e) {
		if(radioButtonBubble.isSelected()) {
			radioButtonImage.setImage(new Image(getClass().getResource("images/" + radioButtonBubble.getUserData().toString() + ".png").toString()));
		}else if(radioButtonBar.isSelected()) {
			radioButtonImage.setImage(new Image(getClass().getResource("images/" + radioButtonBar.getUserData().toString() + ".png").toString()));
		}else {
			radioButtonImage.setImage(new Image(getClass().getResource("images/" + radioButtonArea.getUserData().toString() + ".png").toString()));
		}
	}
	
}
