package chapter10.change_window.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class RootController implements Initializable {
	@FXML private StackPane paneStack;
	@FXML private Button buttonScore;
	@FXML private Button buttonLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonLogin.setOnAction((e)->{
			buttonLoginAction(e);	
		});
		//buttonLogin 에 대한 event를 정의한다.
		buttonScore.setOnAction((e1)-> {
			buttonScoreAction(e1);	
		});
		//buttonScore 에 대한 event를 정의한다.
		
	} // end of initialize
	// 로그인 화면을 보여주는 이벤트 처리 방식

	public void buttonScoreAction(ActionEvent e1) {
		AnchorPane paneAnchorScore = null;
		StackPane paneStack = null;
		try {
			paneStack = (StackPane) buttonScore.getScene().getRoot();
			paneAnchorScore = FXMLLoader.load(getClass().getResource("custom_window.fxml"));
			paneStack.getChildren().add(paneAnchorScore);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//priamaeyStage에 있는 StackPane의 컨테이너를 찾아온다.
		//buttonScore를 통해 가져온다. buttonScore는 StackPane에 있기 때문에 먼저 getScene()을 통해 Scene을 가져오고
		//getRoot()를 통해 Scene안에 있는 컨테이너를 가져온다.
		//사용해야할 컨테이너를 가져와야 하므로 FXMLLoader를 통해 해당 fxml파일을 로더한다.
		//가져온 StackPane에 사용할 컨테이너를 넣어준다. getChildren()을 통해 StackPane에 들어간 하위 객체를 가져오고
		//add()를 통해서 새로운 하위 객체를 추가한다.
	}

	public void buttonLoginAction(ActionEvent e) {
		AnchorPane panAnchorLogin = null;
		StackPane paneStack = null;
		try {
			paneStack = (StackPane) buttonLogin.getScene().getRoot();
			panAnchorLogin = FXMLLoader.load(getClass().getResource("login_window.fxml"));
			paneStack.getChildren().add(panAnchorLogin);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}// end of RootController
