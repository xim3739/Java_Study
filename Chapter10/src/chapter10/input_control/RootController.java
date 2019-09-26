package chapter10.input_control;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	
	@FXML private TextField textFieldTitle;
	@FXML private PasswordField textFieldPassword;
	@FXML private ComboBox<String> comboBox;
	@FXML private DatePicker datePicker;
	@FXML private TextArea textArea;
	@FXML private Button buttonSave;
	@FXML private Button buttonCancle;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    ObservableList<String> list = FXCollections.observableArrayList();
	  //ArrayList<String> arr = new ArrayList<String>(); 똑같다. UI에선 ObservableList를 쓴다.
	    list.add("공개");
	    list.add("비공개");
	    
	    comboBox.setItems(list);
	    
	    comboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				String data = textArea.getText();
				textArea.setText(data + newValue);
			}
		});;
		
		buttonSave.setOnAction((e) -> {
			String title = textFieldTitle.getText();
			String password = textFieldPassword.getText();
			String comboBoxData = comboBox.getValue();
			LocalDate localDate = datePicker.getValue();
			String localDateData = localDate.toString();
			
			textArea.setText(title + "\n" + password + "\n" + localDateData + "\n" + comboBoxData);
		});
		
	}
	
	public void handlerButtonCancleAction(ActionEvent e) {
		textArea.setText(null);
	}

}
