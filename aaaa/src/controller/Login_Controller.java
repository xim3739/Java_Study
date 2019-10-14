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

	// observableList ���� �ܿ��
	ObservableList<Login_VO> data = FXCollections.observableArrayList();

	// �ν��Ͻ� �� Ʋ�����
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

	// id=pw ��ġ�ؾ� �α��ΰ��� (��ġ = ���κ�� �Ѿ)
	public void ev_test(ActionEvent event) {
		dao = new Input_emp_DAO();
		// ����
		String a = null;
		String b = null;
		Alert alert;

		// ����޼ҵ� ȣ��
		vo = new Input_emp_VO(txt_id.getText());

		// ���Է�
		if (txt_id.getText().equals("") || txt_pw.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("�α��ν���");
			alert.setHeaderText("�����ȣ ���Է�");
			alert.setContentText("�����ȣ�� ��й�ȣ �� �Է����� ���� �׸��� �ֽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}

		a = dao.get_id_eNo2(vo);

		// ����޼ҵ� ȣ��
		vo = new Input_emp_VO(txt_pw.getText());
		b = dao.get_pw2(vo);

		if (a == null || b == null) {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("�α��ν���");
			alert.setHeaderText("�����ȣ�� ��й�ȣ ����ġ");
			alert.setContentText("�����ȣ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			try {
				Stage stage = new Stage();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/main_manager.fxml"));
				Parent input_emp = loader.load();

				// ��
				Scene s = new Scene(input_emp);

				// parent���ƴ� main��Ʈ�ѷ����� ����(����)
				// Main��Ʈ�ѷ� �ּҸ�main��Ʈ�ѷ�����
				Main_m_Controller main = loader.getController();
				// ������Ʈ�ѷ��� ���� ������.
				main.setId(txt_id.getText());
				// ��������
				stage.setTitle("Mainâ");
				stage.setScene(s);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("����" + e);
			}
		} else {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("�α��ν���");
			alert.setHeaderText("�����ȣ�� ��й�ȣ ����ġ");
			alert.setContentText("�����ȣ�� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
		}

	}

	// ��ҹ�ư �޼ҵ�
	public void ev_cancel(ActionEvent event) {
		Platform.exit();
	}

	// �������� ��ư �޼ҵ�
	public void ev_input(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent input_emp = FXMLLoader.load(getClass().getResource("/view/input_emp.fxml"));

			// ��
			Scene s = new Scene(input_emp);
			// ��������
			stage.setTitle("��������");
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("����" + e);
		}

	}

	// ���̵���ã�� ��ư �޼ҵ�
	public void ev_select(ActionEvent event) {
		try {
			Stage stage = new Stage();
			Parent input_emp = FXMLLoader.load(getClass().getResource("/view/input_emp2.fxml"));

			// ��
			Scene s = new Scene(input_emp);
			// ��������
			stage.setTitle("�����ȣ/��� ã��");
			stage.setScene(s);
			stage.show();
		} catch (IOException e) {
			System.err.println("����" + e);
		}

	}

	// ���Է½� ���� â
	public void alert_null() {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("���� ���Է�");
		alert.setHeaderText("�׸� �Է��Ͻÿ�.");
		alert.setContentText("�Է¾��� �׸��� �ֽ��ϴ�. �Է��ϼ���");

		alert.showAndWait();
	}

}
