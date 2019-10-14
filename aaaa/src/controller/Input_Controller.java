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
	// observableList ���� �ܿ��
	ObservableList<Input_emp_VO> data = FXCollections.observableArrayList();

	// �ν��Ͻ� �� Ʋ�����
	Input_emp_VO vo = null;
	Input_emp_DAO dao = null;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_insert.setOnAction(event -> ev_insert(event));
		btn_cancel.setOnAction(event -> ev_cancel(event));

		// ���� �޺��ڽ��� ������
		cb_spots.setItems(FXCollections.observableArrayList("�Ϲ�����", "�Ŵ���"));
		cb_spots.setPromptText("����");

		// ���޿����� �޿�����
		if (cb_spots.getValue() == "�Ŵ���") {
			txt_sal = 2500000;
		} else {
			txt_sal = 1700000;
		}
		date_sales_date.setValue(LocalDate.now());
	}

	// �߰���ư �޼ҵ�
	public void ev_insert(ActionEvent event) {
		dao = new Input_emp_DAO();
		try {
			// �޼ҵ� ȣ�� ���̵�������Ʈ ������
			eNoPw_list = dao.get_uniq_enoPw();

			// �ߺ� ���̵�Ǵ� ��� �Է��� ���
			for (int i = 0; i < eNoPw_list.size(); i++) {
				if (txt_e_no.getText().equals(eNoPw_list.get(i).getE_no()) ) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("���Խ���");
					alert.setHeaderText("�����ȣ �ߺ�");
					alert.setContentText("�ٸ������ �ߺ��Ǵ� �����ȣ�Դϴ�." + "\n �ٸ� �����ȣ�� �Է��Ͻÿ�.");
					alert.showAndWait();
					return;
				}
			}
			for (int i = 0; i < eNoPw_list.size(); i++) {
				if (txt_pw.getText().equals(eNoPw_list.get(i).getPw()) ) {
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("���Խ���");
					alert.setHeaderText("��й�ȣ �ߺ�");
					alert.setContentText("�ٸ������ �ߺ��Ǵ� ��й�ȣ�Դϴ�." + "\n �ٸ� ��й�ȣ�� �Է��Ͻÿ�.");
					alert.showAndWait();
					return;
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// �����ڵ� �������� ��ġ�ؾ� ���Լ���
		if (txt_stNo.getText().equals("00123") && txt_st_pw.getText().equals("1234")) {
			try {

				vo = new Input_emp_VO(txt_e_no.getText(), txt_eName.getText(), txt_age.getText(), txt_phone.getText(),
						cb_spots.getValue().toString(), txt_pw.getText(), txt_stNo.getText(), txt_mag.getText(),
						txt_sal, date_sales_date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

				dao = new Input_emp_DAO();
				Optional<ButtonType> result;
				result=dao.input_e(vo);
				// Ok�� ������
				if (result.get() == ButtonType.OK) {
					Stage da = (Stage) btn_cancel.getScene().getWindow();
					da.close();
				}
				

			} catch (Exception e) {
				alert_null();
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("�α��ν���");
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

	// ���Է½� ���� â
	public void alert_null() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("���� ���Է�");
		alert.setHeaderText("�ʼ��׸� �Է��Ͻÿ�.");
		alert.setContentText("�Է¾��Ͻ� �ʼ��׸��� �ֽ��ϴ�. Ȯ�� ��,�Է��ϼ���");

		alert.showAndWait();
	}

}
