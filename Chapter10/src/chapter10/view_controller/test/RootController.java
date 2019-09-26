package chapter10.view_controller.test;

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

public class RootController implements Initializable {
	@FXML
	private ListView<String> listView;
	// ListView 를 만든다. ListView 에는 문자열로 된 리스트가 들어가므로 String으로 준다.
	@FXML
	private TableView<Phone> tableView;
	// TableView 를 만든다. TableView 에는 핸드폰의 정보가 들어가야한다. 그러므로 Phone 객체가
	@FXML
	private ImageView imageView;
	@FXML
	private Button buttonOk;
	@FXML
	private Button buttonCancle;
	// 나머지 객체를 만든다.

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		insertListViewAndProcess();
		// ListView

		insertTableViewAndProcess();
		// TabelView
	}

	private void insertListViewAndProcess() {
		ObservableList<String> listViewData = FXCollections.observableArrayList();
		// UI의 객체이므로 ObservableList<String> 으로 객체를 만든다.
		// (FXCollections는 그냥 Collections를 쓰는게 아니라 UI의 Collection을 사용하므로
		// FXCollections.observableArrayList()로 만든다.)
		listViewData.add("갤럭시 s1");
		listViewData.add("갤럭시 s2");
		listViewData.add("갤럭시 s3");
		listViewData.add("갤럭시 s4");
		listViewData.add("갤럭시 s5");
		listViewData.add("갤럭시 s6");
		listViewData.add("갤럭시 s7");
		// 만든 리스트에 객체를 넣는다.

		listView.setItems(listViewData);
		// listView 에 세팅 한다.

		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				tableView.getSelectionModel().select(newValue.intValue());
			}
		});
		// listView에 이벤트를 건다.
		// listView의 정보를 우선 가져와야한다. getSelectionModel()을 이용해서 선택된 모델? 형태?를 가져온다.
		// selectedIndexProperty() 함수를 이용해서 선택된 인덱스 번호의 속성을 감지한다.
		// addListener 함수를 이용해서 이벤트를 전달 할 리스너를 만든다.
		// new ChangeListener 바뀌는 이벤트를 전달 해야 하므로 ChangeListener를 만든다.
		// 속성감시로 현재 이벤트로 발생된 최근의 값을 tableView에서 표시한다.
		// getSelectionModel() 함수를 이용해서 tableView 의 모델을 가져온다.
		// select() 함수를 이용해서 선택한다. 안의 값은 인덱스 값이 들어간다.
		// newValue는 최근의 이벤트로 발생된 인덱스 값을 객체로 가지고 있다. 그래서 intValue()함수를 이용해서 기본타입으로 바꾼다.
		// 그러면 선택이 된다.
	}

	private void insertTableViewAndProcess() {
		ObservableList<Phone> tableViewData = FXCollections.observableArrayList();
		// UI의 객체이므로 ObservableList<Phone> 으로 객체를 만든다.
		// (FXCollections는 그냥 Collections를 쓰는게 아니라 UI의 Collection을 사용하므로
		// FXCollections.observableArrayList()로 만든다.)
		tableViewData.add(new Phone("갤럭시 s1", "phone01.png"));
		tableViewData.add(new Phone("갤럭시 s2", "phone02.png"));
		tableViewData.add(new Phone("갤럭시 s3", "phone03.png"));
		tableViewData.add(new Phone("갤럭시 s4", "phone04.png"));
		tableViewData.add(new Phone("갤럭시 s5", "phone05.png"));
		tableViewData.add(new Phone("갤럭시 s6", "phone06.png"));
		tableViewData.add(new Phone("갤럭시 s7", "phone07.png"));
		// 만든 리스트에 객체를 넣는다.(Phone객체가 들어가므로 객체를 생성해서 넣는다.)

		TableColumn tcPhoneName = tableView.getColumns().get(0);
		tcPhoneName.setCellValueFactory(new PropertyValueFactory("phoneName"));
		// TableColumn 과 객체 안의 멤버와 연결을 시켜야 하므로 TableColumn을 사용한다.
		// tableView.getColumns() 함수를 이용해서 column정보를 가져오고 get(0) 그 column의 인덱스를
		// 가져온다.(콜롬은 콜롬이 몇개있는지 가져오는것, get으로 정확한 콜롬을 가져온다.)
		TableColumn tcPhoneImage = tableView.getColumns().get(1);
		tcPhoneImage.setCellValueFactory(new PropertyValueFactory("phoneImage"));
		// TableColumn 과 객체 안의 멤버와 연결을 시켜야 하므로 TableColumn을 사용한다.
		// tableView.getColumns() 함수를 이용해서 column정보를 가져오고 get(0) 그 column의 인덱스를
		// 가져온다.(콜롬은 콜롬이 몇개있는지 가져오는것, get으로 정확한 콜롬을 가져온다.)

		tableView.setItems(tableViewData);
		// tableView에 세팅한다.

		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
				Image image = new Image(getClass().getResource("images/" + newValue.getPhoneImage()).toString());
				imageView.setImage(image);

			}
		});
		// tableView에 이벤트를 건다.
		// tableView의 정보를 우선 가져와야한다. getSelectionModel()을 이용해서 선택된 모델? 형태?를 가져온다.
		// selectedItemProperty() 함수를 이용해서 선택된 아이템의 속성을 감지한다.
		// addListener 함수를 이용해서 이벤트를 전달 할 리스너를 만든다.
		// new ChangeListener 바뀌는 이벤트를 전달 해야 하므로 ChangeListener를 만든다.
		// tableView 는 변경된 사항을 가지고 이미지를 전달하는 동작을 해야하므로 이미지 객체를 만든다.
		// 이미지 객체의 주소는 getClass()를 가져오고 getResource()소스의 주소를 가져온다.
		//"images/" + newValue.getPhoneImage()).toString() 
		// images/ 는 주소의 시작이고 newValue.getPhoneImage()는 최근에 속성이 변경된 객체 newValue는 즉 Phone을 가지고 있다.
		//그 phone의 이미지를 가져온다. (get 사용)
		//toString으로 찍는다. 스트링으로 가져와야 하므로

	}

	public void handlerButtonOkAction(ActionEvent e) {
		Phone phone = tableView.getSelectionModel().getSelectedItem();
		System.out.println(phone);
	}

	public void handlerButtonCancleAction(ActionEvent e) {
		Platform.exit();
	}
}
