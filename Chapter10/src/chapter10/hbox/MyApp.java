package chapter10.hbox;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hBox = new HBox();
		//객체 생성
		hBox.setPrefHeight(120);
		//높이 설정
		hBox.setPrefWidth(300);
		//가로 설정
		hBox.setAlignment(Pos.CENTER);
		//위치 설정 Pos.CENTER 등등
		hBox.setSpacing(20);
		//컨트롤러들의 간격 설정
		//1. rootContainer를 만든다.


		TextField textField = new TextField();
		//컨트롤러 객체 생성 (텍스트 필드 객체 생성)
		textField.setPrefWidth(200);
		//텍스트 필드 사이즈 설정
		Button button = new Button();
		//컨트롤러 객체 생성 (버튼 객체 생성)
		button.setText("확인");
		//버튼에 표시할 텍스트 생성
		button.setOnAction((e) -> Platform.exit());
		//버튼에 이벤트 추가 (버튼을 누르면 종료)
		// 2.controller 를 만든다.

		ObservableList<Node> list = hBox.getChildren();
		//rootContainer 를 ObservableList 에 저장한다. 타입은 Node 이다. Node는 컨트롤러 객체들 이다.
		list.add(textField);
		//리스트에 컨트롤러를 추가한다. (텍스트 필드 컨트롤러를 추가)
		list.add(button);
		//리스트에 컨트롤러를 추가한다. (버튼 컨트롤러를 추가)
		// 3.rootContainer 에 controller 를 집어넣는다.

		Scene scene = new Scene(hBox);
		// 4.rootContainer 를 scene에 집어넣는다.
		
		primaryStage.setScene(scene);
		primaryStage.show();
		// 5.stage에 scene를 넣고 보여준다.
	}
}