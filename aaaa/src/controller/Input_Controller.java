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

public class Input_Controller implements Initializable {

	@FXML
	TextField txt_stNo;
	@FXML
	TextField txt_mag;
	@FXML
	TextField txt_eName;
	@FXML
	TextField txt_age;
	@FXML
	TextField txt_phone;
	@FXML
	TextField txt_e_no;
	@FXML
	ComboBox cb_spots;
	@FXML
	PasswordField txt_pw;
	@FXML
	DatePicker date_sales_date;
	@FXML
	PasswordField txt_st_pw;
	@FXML
	Button btn_insert;
	@FXML
	Button btn_cancel;
	int txt_sal;

	List<Input_emp_VO> list;
	ArrayList<Input_emp_VO> eNoPw_list;
	// observableList 생성 외우기
	ObservableList<Input_emp_VO> data = FXCollections.observableArrayList();

	// 인스턴스 할 틀잡아줌
	Input_emp_VO vo = null;
	Input_emp_DAO dao = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_insert.setOnAction(event -> ev_insert(event));
		btn_cancel.setOnAction(event -> ev_cancel(event));

		// 직급 콤보박스에 값설정
		cb_spots.setItems(FXCollections.observableArrayList("일반직원", "매니저"));
		cb_spots.setPromptText("선택");

		// 직급에따라 급여설정
		if (cb_spots.getValue() == "매니저") {
			txt_sal = 2500000;
		} else {
			txt_sal = 1700000;
		}
		date_sales_date.setValue(LocalDate.now());
	}

	// 추가버튼 메소드
	public void ev_insert(ActionEvent event) {
		dao = new Input_emp_DAO();
		try {
			// 메소드 호출 아이디비번리스트 가져옴
			eNoPw_list = dao.get_uniq_enoPw();

			// 중복 아이디또는 비번 입력한 경우
			for (int i = 0; i < eNoPw_list.size(); i++) {
				if (txt_e_no.getText().equals(eNoPw_list.get(i).getE_no()) ) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("가입실패");
					alert.setHeaderText("사원번호 중복");
					alert.setContentText("다른사원과 중복되는 사원번호입니다." + "\n 다른 사원번호를 입력하시오.");
					alert.showAndWait();
					return;
				}
			}
			for (int i = 0; i < eNoPw_list.size(); i++) {
				if (txt_pw.getText().equals(eNoPw_list.get(i).getPw()) ) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("가입실패");
					alert.setHeaderText("비밀번호 중복");
					alert.setContentText("다른사원과 중복되는 비밀번호입니다." + "\n 다른 비밀번호를 입력하시오.");
					alert.showAndWait();
					return;
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// 매장코드 매장비번이 일치해야 가입성공
		if (txt_stNo.getText().equals("00123") && txt_st_pw.getText().equals("1234")) {
			try {

				vo = new Input_emp_VO(txt_e_no.getText(), txt_eName.getText(), txt_age.getText(), txt_phone.getText(),
						cb_spots.getValue().toString(), txt_pw.getText(), txt_stNo.getText(), txt_mag.getText(),
						txt_sal, date_sales_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

				dao = new Input_emp_DAO();
				Optional<ButtonType> result;
				result=dao.input_e(vo);
				// Ok를 누를때
				if (result.get() == ButtonType.OK) {
					Stage da = (Stage) btn_cancel.getScene().getWindow();
					da.close();
				}
				

			} catch (Exception e) {
				alert_null();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("로그인실패");
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

	// 미입력시 주의 창
	public void alert_null() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("정보 미입력");
		alert.setHeaderText("필수항목 입력하시오.");
		alert.setContentText("입력안하신 필수항목이 있습니다. 확인 후,입력하세요");

		alert.showAndWait();
	}

}
