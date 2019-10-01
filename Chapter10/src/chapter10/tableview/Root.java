package chapter10.tableview;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class Root implements Initializable {

	@FXML private ImageView imageview;
	@FXML private ListView<String> listview;
	@FXML private TableView<Number> tableview;
	@FXML private Button buttonS;
	@FXML private Button buttonE;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		ObservableList<String> listviewData = FXCollections.observableArrayList();
		listviewData.add("갤럭시 s1");
		listviewData.add("갤럭시 s2");
		listviewData.add("갤럭시 s3");
		listviewData.add("갤럭시 s4");
		listviewData.add("갤럭시 s5");
		listviewData.add("갤럭시 s6");
		listviewData.add("갤럭시 s7");
		listview.setItems(listviewData);
		
		
		
	}
	public void handlerStartAction() {
		
	}
	public void handlerCloseAction() {
		
	}

}
