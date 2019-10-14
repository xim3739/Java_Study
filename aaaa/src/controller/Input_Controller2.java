package controller;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Input_emp_VO;
import javafx.scene.control.ComboBox;

public class Input_Controller2 implements Initializable {

	@FXML
	TextField txt_stNo;
	@FXML
	TextField txt_eName;
	@FXML
	TextField txt_age;
	@FXML
	TextField txt_phone;
	@FXML
	TextField txt_e_no;
	@FXML
	TextField txt_pw1;
	@FXML
	PasswordField txt_st_pw;
	@FXML
	Button btn_select;
	@FXML
	Button btn_cancel;

	// 인스턴스할 틀
	Input_emp_DAO dao = null;
	Input_emp_VO vo = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_cancel.setOnAction(event -> ev_cancel(event));
		btn_select.setOnAction(event -> ev_select(event));
	}

	// 검색버튼
	public void ev_select(ActionEvent event) {
		// 5개의 텍스트 미입력시 검색안됨
		if (txt_age.getText().equals("") || txt_eName.getText().equals("") || txt_phone.getText().equals("")
				|| txt_st_pw.getText().equals("") || txt_stNo.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("정보 미입력");
			alert.setHeaderText("필수항목 입력하시오.");
			alert.setContentText("입력안하신 필수항목이 있습니다. 확인 후,입력하세요");

			alert.showAndWait();
			return;
		}

		// 맞아야 찾기가능
		if (txt_stNo.getText().equals("00123") && txt_st_pw.getText().equals("1234")) {
			vo = new Input_emp_VO(txt_eName.getText(), txt_age.getText(), txt_phone.getText());
			dao = new Input_emp_DAO();
			try {
				String e_no = dao.get_select_eNo(vo);
				String pw = dao.get_select_pw(vo);
				if (e_no.equals("") || pw.equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("조회실패");
					alert.setHeaderText("미가입 직원입니다.");
					alert.setContentText("입력사항과 일치하는 직원이 없습니다.\n 새로 가입하시오.");
					alert.showAndWait();
					return;
				}
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("조회성공");
				alert.setHeaderText("'" + e_no + "' 직원이 맞습니까?");
				alert.setContentText("ok버튼을 클릭하시면 사원번호와 비밀번호를 불러옵니다.");

				Optional<ButtonType> result = alert.showAndWait();
				// Ok를 누를때
				if (result.get() == ButtonType.OK) {
					txt_e_no.setDisable(false);
					txt_pw1.setDisable(false);
					txt_e_no.setText(e_no);
					txt_pw1.setText(pw);
				}
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("조회실패");
				alert.setHeaderText("미가입 직원입니다.");
				alert.setContentText("입력사항과 일치하는 직원이 없습니다.\n 새로 가입하시오.");
				alert.showAndWait();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회실패");
			alert.setHeaderText("매장코드와 비밀번호를 다시 확인하시오.");
			alert.setContentText("매장코드와 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");
			alert.showAndWait();
		}
	}

	// 취소버튼 메소드
	public void ev_cancel(ActionEvent event) {
		Stage da = (Stage) btn_cancel.getScene().getWindow();
		da.close();
	}

}
