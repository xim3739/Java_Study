package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.SpringLayout.Constraints;

import javafx.fxml.Initializable;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import model.Input_emp_VO;
import model.Login_VO;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPaneBuilder;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;

public class Login_Controller implements Initializable {

	@FXML
	TextField txt_id;
	@FXML
	PasswordField txt_pw;
	@FXML
	Button btn_cancel;
	@FXML
	Button btn_login;
	@FXML
	Button btn_input_emp;
	@FXML
	Button btn_select_idpw;

	// observableList 생성 외우기
	ObservableList<Login_VO> data = FXCollections.observableArrayList();

	// 인스턴스 할 틀잡아줌
	Login_VO lvo = null;
	Login_DAO ldao = null;
	Input_emp_VO vo = null;
	Input_emp_DAO dao = null;

	// list
	ArrayList<Input_emp_VO> list;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_login.setOnAction(event -> ev_test(event));
		btn_cancel.setOnAction(event -> ev_cancel(event));
		btn_input_emp.setOnAction(event -> ev_input(event));
		btn_select_idpw.setOnAction(event -> ev_select(event));
	}

	// id=pw 일치해야 로그인가능 (일치 = 메인뷰로 넘어감)
	public void ev_test(ActionEvent event) {
		dao = new Input_emp_DAO();
		// 직급
		String a = null;
		String b = null;
		Alert alert;

		// 사번메소드 호출
		vo = new Input_emp_VO(txt_id.getText());

		// 미입력
		if (txt_id.getText().equals("") || txt_pw.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인실패");
			alert.setHeaderText("사원번호 미입력");
			alert.setContentText("사원번호와 비밀번호 중 입력하지 않은 항목이 있습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
			return;
		}

		a = dao.get_id_eNo2(vo);

		// 비번메소드 호출
		vo = new Input_emp_VO(txt_pw.getText());
		b = dao.get_pw2(vo);

		if (a == null || b == null) {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인실패");
			alert.setHeaderText("사원번호와 비밀번호 불일치");
			alert.setContentText("사원번호와 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			try {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_manager.fxml"));
				Parent input_emp = loader.load();

				// 씬
				Scene s = new Scene(input_emp);

				// parent가아닌 main컨트롤러에게 권한(주인)
				// Main컨트롤러 주소를main컨트롤러권한
				Main_m_Controller main = loader.getController();
				// 메인컨트롤러에 값을 보낸다.
				main.setId(txt_id.getText());
				// 스테이지
				stage.setTitle("Main창");
				stage.setScene(s);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("오류" + e);
			}
		} else {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인실패");
			alert.setHeaderText("사원번호와 비밀번호 불일치");
			alert.setContentText("사원번호와 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
		}

	}

	// 취소버튼 메소드
	public void ev_cancel(ActionEvent event) {
		Platform.exit();
	}

	// 직원가입 버튼 메소드
	public void ev_input(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent input_emp = FXMLLoader.load(getClass().getResource("/view/input_emp.fxml"));

			// 씬
			Scene s = new Scene(input_emp);
			// 스테이지
			stage.setTitle("직원가입");
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("오류" + e);
		}

	}

	// 아이디비번찾기 버튼 메소드
	public void ev_select(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent input_emp = FXMLLoader.load(getClass().getResource("/view/input_emp2.fxml"));

			// 씬
			Scene s = new Scene(input_emp);
			// 스테이지
			stage.setTitle("사원번호/비번 찾기");
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			System.err.println("오류" + e);
		}

	}

	// 미입력시 주의 창
	public void alert_null() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("정보 미입력");
		alert.setHeaderText("항목 입력하시오.");
		alert.setContentText("입력안한 항목이 있습니다. 입력하세요");

		alert.showAndWait();
	}

}
