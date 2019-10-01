package chapter10.table_view.test;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootController implements Initializable {
	
	@FXML private ListView<String> listView;
	@FXML private TableView<Phone> tableView;
	@FXML private ImageView imageView;
	@FXML private TextArea textArea;
	public static Phone selectPhone;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		insertListViewAndAction();
		insertTableViewAndAction();

	}
	
	private void insertTableViewAndAction() {
		ObservableList<Phone> tableViewList = FXCollections.observableArrayList();
		tableViewList.add(new Phone("갤럭시 s1", "phone01.png"));
		tableViewList.add(new Phone("갤럭시 s2", "phone02.png"));
		tableViewList.add(new Phone("갤럭시 s3", "phone03.png"));
		tableViewList.add(new Phone("갤럭시 s4", "phone04.png"));
		tableViewList.add(new Phone("갤럭시 s5", "phone05.png"));
		tableViewList.add(new Phone("갤럭시 s6", "phone06.png"));
		tableViewList.add(new Phone("갤럭시 s7", "phone07.png"));
		
	
		TableColumn tcTableView1 = tableView.getColumns().get(0);
		tcTableView1.setCellValueFactory(new PropertyValueFactory("phoneName"));
		
		TableColumn tcTableView2 = tableView.getColumns().get(1);
		tcTableView2.setCellValueFactory(new PropertyValueFactory("image"));
		
		tableView.setItems(tableViewList);
		
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
				selectPhone = newValue;
				Image image = new Image(getClass().getResource("images/" + newValue.getImage()).toString());
				imageView.setImage(image);
			}
		});
	}

	private void insertListViewAndAction() {
		
		ObservableList<String> listViewList = FXCollections.observableArrayList();
		listViewList.add("갤럭시 s1");
		listViewList.add("갤럭시 s2");
		listViewList.add("갤럭시 s3");
		listViewList.add("갤럭시 s4");
		listViewList.add("갤럭시 s5");
		listViewList.add("갤럭시 s6");
		listViewList.add("갤럭시 s7");
		
		listView.setItems(listViewList);
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
			}
		});
		
	}

	public void handlerButtonCompleteAction() {
		textArea.setText(selectPhone.toString());
	}
	
	public void handlerButtonExitAction() {
		Platform.exit();
	}

}
