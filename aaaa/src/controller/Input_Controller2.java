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

	// �ν��Ͻ��� Ʋ
	Input_emp_DAO dao = null;
	Input_emp_VO vo = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_cancel.setOnAction(event -> ev_cancel(event));
		btn_select.setOnAction(event -> ev_select(event));
	}

	// �˻���ư
	public void ev_select(ActionEvent event) {
		// 5���� �ؽ�Ʈ ���Է½� �˻��ȵ�
		if (txt_age.getText().equals("") || txt_eName.getText().equals("") || txt_phone.getText().equals("")
				|| txt_st_pw.getText().equals("") || txt_stNo.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ���Է�");
			alert.setHeaderText("�ʼ��׸� �Է��Ͻÿ�.");
			alert.setContentText("�Է¾��Ͻ� �ʼ��׸��� �ֽ��ϴ�. Ȯ�� ��,�Է��ϼ���");

			alert.showAndWait();
			return;
		}

		// �¾ƾ� ã�Ⱑ��
		if (txt_stNo.getText().equals("00123") && txt_st_pw.getText().equals("1234")) {
			vo = new Input_emp_VO(txt_eName.getText(), txt_age.getText(), txt_phone.getText());
			dao = new Input_emp_DAO();
			try {
				String e_no = dao.get_select_eNo(vo);
				String pw = dao.get_select_pw(vo);
				if (e_no.equals("") || pw.equals("")) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("��ȸ����");
					alert.setHeaderText("�̰��� �����Դϴ�.");
					alert.setContentText("�Է»��װ� ��ġ�ϴ� ������ �����ϴ�.\n ���� �����Ͻÿ�.");
					alert.showAndWait();
					return;
				}
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��ȸ����");
				alert.setHeaderText("'" + e_no + "' ������ �½��ϱ�?");
				alert.setContentText("ok��ư�� Ŭ���Ͻø� �����ȣ�� ��й�ȣ�� �ҷ��ɴϴ�.");

				Optional<ButtonType> result = alert.showAndWait();
				// Ok�� ������
				if (result.get() == ButtonType.OK) {
					txt_e_no.setDisable(false);
					txt_pw1.setDisable(false);
					txt_e_no.setText(e_no);
					txt_pw1.setText(pw);
				}
			} catch (NullPointerException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("��ȸ����");
				alert.setHeaderText("�̰��� �����Դϴ�.");
				alert.setContentText("�Է»��װ� ��ġ�ϴ� ������ �����ϴ�.\n ���� �����Ͻÿ�.");
				alert.showAndWait();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ����");
			alert.setHeaderText("�����ڵ�� ��й�ȣ�� �ٽ� Ȯ���Ͻÿ�.");
			alert.setContentText("�����ڵ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");
			alert.showAndWait();
		}
	}

	// ��ҹ�ư �޼ҵ�
	public void ev_cancel(ActionEvent event) {
		Stage da = (Stage) btn_cancel.getScene().getWindow();
		da.close();
	}

}
