package chapter10.view_ontroll.copy;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RootContrller implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TableView<Phone> tableView;
	@FXML
	private ImageView imageView;
	@FXML
	private Button buttonOk;
	@FXML
	private Button buttonCancle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		insertListViewItemAndEventProcess();
		// listView 항목 삽입하고 이벤트 처리

		insertTableViewItemAndEventProcess();
		// tableView
	}

	private void insertTableViewItemAndEventProcess() {

		ObservableList<Phone> tableViewData = FXCollections.observableArrayList();
		tableViewData.add(new Phone("갤럭시 s1", "phone01.png"));
		tableViewData.add(new Phone("갤럭시 s2", "phone02.png"));
		tableViewData.add(new Phone("갤럭시 s3", "phone03.png"));
		tableViewData.add(new Phone("갤럭시 s4", "phone04.png"));
		tableViewData.add(new Phone("갤럭시 s5", "phone05.png"));
		tableViewData.add(new Phone("갤럭시 s6", "phone06.png"));
		tableViewData.add(new Phone("갤럭시 s7", "phone07.png"));

		TableColumn tcPhoneName = tableView.getColumns().get(0);
		tcPhoneName.setCellValueFactory(new PropertyValueFactory("phoneName"));
		tcPhoneName.setStyle("-fx-alignmetn: CENTER;");

		TableColumn tcPhoneImage = tableView.getColumns().get(1);
		tcPhoneImage.setCellValueFactory(new PropertyValueFactory("phoneImage"));
		tcPhoneImage.setStyle("-fx-alignmetn: CENTER;");

		tableView.setItems(tableViewData);

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone phone) {
				Image imageData = new Image(getClass().getResource("images/" + phone.getPhoneImage()).toString());
				imageView.setImage(imageData);
			}
		});

	}

	private void insertListViewItemAndEventProcess() {
		ObservableList<String> listViewData = FXCollections.observableArrayList();
		listViewData.add("갤럭시 s1");
		listViewData.add("갤럭시 s2");
		listViewData.add("갤럭시 s3");
		listViewData.add("갤럭시 s4");
		listViewData.add("갤럭시 s5");
		listViewData.add("갤럭시 s6");
		listViewData.add("갤럭시 s7");

		listView.setItems(listViewData);

		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
				tableView.scrollTo(newValue.intValue());
			}
		});

	}

	public void handlerButtonOkAction(ActionEvent e) {
		String data = listView.getSelectionModel().getSelectedItem();
		System.out.println(data);
		Phone phone = tableView.getSelectionModel().getSelectedItem();
		System.out.println(phone);
	}

	public void handlerButtonCancleAction(ActionEvent e) {
		Platform.exit();
	}
}
