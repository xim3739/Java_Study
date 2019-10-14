package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Input_emp_VO;
import model.Login_VO;
import model.Product_VO;
import model.Sales_VO;

public class Main_m_Controller implements Initializable {

	// is �ǸŽ����Է�
	@FXML
	Tab tab_input_sales;
	@FXML
	Button is_btn_sales;
	@FXML
	TextField is_txt_eNo;
	@FXML
	TextField is_txt_stNo;
	@FXML
	TextField is_txt_Memo;
	@FXML
	TextField is_txt_proPrice;
	@FXML
	TextField is_txt_ac_price;
	@FXML
	TextField is_txt_ac_num;
	@FXML
	TextField is_txt_SalesTime;
	@FXML
	TextField is_txt_proName;
	@FXML
	Button is_btn_reset;
	@FXML
	DatePicker is_salesDate;
	@FXML
	ComboBox<String> is_combo_ProNo;
	@FXML
	ComboBox<String> is_combo_ProNum;
	@FXML
	Button is_btn_select;
	@FXML
	TextField is_txt_salesPrice;
	@FXML
	TextField is_txt_eName;

	// ss �ǸŽ�����ȸ
	@FXML
	Tab tab_select_sales;
	@FXML
	TableView<Sales_VO> ss_tv_all;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_time;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_proNo;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_proName;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_proNum;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_proPrice;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_acNum;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_acPrice;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_memo;
	@FXML
	TableColumn<Sales_VO, String> ss_tv_date;
	@FXML
	TextField ss_txt_proName;
	@FXML
	Button ss_btn_select_pname;
	@FXML
	Button ss_btn_select_memo;
	@FXML
	Button ss_btn_edit;
	@FXML
	TextField ss_txt_Memo;
	@FXML
	DatePicker ss_salesDate;
	@FXML
	Button ss_btn_delete;
	@FXML
	Button ss_btn_select_date;
	@FXML
	Button ss_btn_select_all;

	// ��ǰ����
	@FXML
	TextField txt_proName;
	@FXML
	Button btn_proInput;
	@FXML
	TextField txt_proPrice;
	@FXML
	Button btn_reset;
	@FXML
	TableView<Product_VO> tv_all;
	@FXML
	TableColumn<Product_VO, String> tv_proNo;
	@FXML
	TableColumn<Product_VO, String> tv_proName;
	@FXML
	TableColumn<Product_VO, String> tv_proPrice;
	@FXML
	Button btn_edit;
	@FXML
	Button btn_delete;
	@FXML
	TextField txt_proNo;
	@FXML
	ComboBox cb_proNO;
	@FXML
	Button btn_select;

	ObservableList<Product_VO> p_data = FXCollections.observableArrayList();
	ArrayList<Product_VO> p_no_list; // �ڵ��ȣ �ּ�list
	int p_select_index; // ������ �ε�����ȣ
	ObservableList<Product_VO> p_select_list;
	ArrayList<Product_VO> p_select_proNO_list;
	String[] p_pro_no_list;
	@FXML
	Button btn_select_all;

	Main_m_Controller m_con = null;

	// im ������
	@FXML
	Tab tab_info_my;
	@FXML
	TextField im_txt_eName;
	@FXML
	PasswordField im_txt_pw;
	@FXML
	ComboBox im_cb_spot;
	@FXML
	Button im_btn_edit;
	@FXML
	TextField im_txt_eNo;
	@FXML
	TextField im_txt_age;
	@FXML
	TextField im_txt_mNo;
	@FXML
	TextField im_txt_stNo;
	@FXML
	TextField im_txt_phone;
	@FXML
	PasswordField im_txt_m_pw;
	@FXML
	TextField im_txt_m_id;
	@FXML
	Button im_btn_m_edit;
	@FXML
	Label label_select;

	// sal ������ȸ
	@FXML
	TextField sal_txt_eNo;
	@FXML
	PasswordField sal_txt_pw;
	@FXML
	TextField sal_txt_turesal;
	@FXML
	Button sal_btn_reset;
	@FXML
	Button sal_btn_sum;
	@FXML
	TextField sal_txt_tax;
	@FXML
	TextField sal_txt_sal;
	@FXML
	TextField sal_txt_acPrice;
	@FXML
	TextField sal_txt_gPrice;
	@FXML
	TextField sal_txt_ratePrice;
	@FXML
	TextField sal_txt_rateNum;
	@FXML
	TextField sal_txt_gNum;
	@FXML
	TextField sal_txt_acNum;
	@FXML
	TextField sal_txt_incentive;
	@FXML
	Button sal_btn_select_sal;
	@FXML
	Button sal_btn_select_ok;

	// c ����
	@FXML
	Tab tab_close;
	@FXML
	DatePicker c_dp_closedate;
	@FXML
	TextField c_txt_stNo;
	@FXML
	TextField c_txt_eNo;
	@FXML
	Button btn_close;// ������ư
	@FXML
	Label c_label;
	@FXML
	TextField c_txt_name;

	// vo�� �ν��Ͻ� ������ Ʋ
	Sales_VO s_vo = null;
	Login_VO l_vo = null;
	Product_VO p_vo = null;
	Input_emp_VO ie_vo = null;

	// dao�� �ν��Ͻ� ������ Ʋ
	Main_DAO m_dao = null;
	Input_emp_DAO ie_dao = null;
	Product_DAO p_dao = null;
	Login_DAO l_dao = null;

	// ��Ʈ�ѷ�
	Login_Controller login_con = null;

	// List
	ArrayList<Product_VO> no_list; // ��ǰ
	ArrayList<Input_emp_VO> emp_list; // ���� ����Ʈ
	String[] pro_no_list; // �迭 (��ǰ�ڵ��ȣ)
	ObservableList<Product_VO> select_list; // ��ǰ�ڵ�
	ObservableList<Sales_VO> select_sales_list; // �ǸŸ���Ʈ
	ObservableList<Sales_VO> select_memo_list; // �޸�
	ObservableList<Sales_VO> data = FXCollections.observableArrayList(); // ��ü

	// ����
	String e_no = null; // �����ȣ
	int sum = 0;
	int ac_num = 0;
	int sal_ac_price = 0;
	int sal_ac_num = 0;
	int pro_num = 0;
	int pro_price = 0;
	int select_index;

	String emp_name = null;
	String emp_eno = null;
	String emp_age = null;
	String emp_phone = null;
	String emp_mag = null;
	String emp_pw = null;
	String emp_st_no = null;
	String emp_spot = null;
	int emp_sal = 0;

	String mag_id = null;
	String mag_pw = null;

	int sal_g_num = 0;
	int sal_g_price = 0;
	double sal_rate_num = 0;
	double sal_rate_price = 0;
	double sal_tax = 0;
	double sal_incen_num = 0;
	double sal_incen_price = 0;
	int sal_true_sal = 0;

	// ���̵�����ġ�˱����� �����Ѻ���
	String sal_id = null;
	String sal_pw = null;

	// �ʵ弱�� (�� �������� ����)
	// �������� �� �ʿ�
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		// ���� ȣ��ȴ�.
		this.id = id;
		// tabȣ��
		e_no = id;
		get_tab_is(id);
	}

	// -----------------initialize-----------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// �ǸŽ����Է�
		is_btn_select.setOnMousePressed(event -> ac_select(event));
		is_btn_sales.setOnAction(event -> is_ac_input(event));
		is_btn_reset.setOnAction(event -> is_ac_reset(event));

		// �ǸŽ�����ȸ
		ss_btn_select_pname.setOnAction(event -> ss_ac_select_proNo(event));
		ss_btn_select_memo.setOnAction(event -> ss_ac_select_memo(event));
		ss_btn_delete.setOnAction(event -> ss_ac_delete(event));
		ss_btn_select_all.setOnAction(event -> ss_ac_select_all(event));
		ss_btn_select_date.setOnAction(event -> ss_ac_select_date(event));

		// ��ǰ����
		p_dao = new Product_DAO();
		p_vo = new Product_VO();

		// ------------��ǰ��ư
		btn_proInput.setOnAction(event -> ac_input_pro(event));
		btn_reset.setOnAction(event -> ac_reset(event));
		btn_edit.setOnAction(event -> ac_edit(event));
		btn_delete.setOnAction(event -> ac_delete(event));
		btn_select.setOnMousePressed(event -> p_ac_select(event));
		btn_select_all.setOnMousePressed(event -> p_ac_select_all(event));

		// ���̺��
		tv_proNo.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_no"));
		tv_proName.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_name"));
		tv_proPrice.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_price"));

		// ��ü���̱�
		product_list();
		tv_all.setItems(p_data);

		// ���̺�� ���� ��, �ؽ�Ʈâ�� ������
		get_select();

		// �޺��ڽ�
		// �������� �ؽ�Ʈ ����
		p_no_list = p_dao.get_list_proNo(); // Į���� �������� �ڵ��ȣ ��������
		p_pro_no_list = new String[p_no_list.size()];
		for (int i = 0; i < p_no_list.size(); i++) {
			p_pro_no_list[i] = p_no_list.get(i).getPro_no();
		}
		cb_proNO.setItems(FXCollections.observableArrayList(p_pro_no_list));
		// �ʱⰪ ����
		cb_proNO.setPromptText("�ڵ��ȣ ����");

		// ��ǰ��----------------------------------

		// im ������
		im_btn_edit.setOnAction(event -> im_ac_edit(event)); // ����
		im_btn_m_edit.setOnAction(event -> im_ac_manager(event));

		// sal ������ȸ
		sal_btn_select_sal.setOnAction(event -> sal_ac_select(event));
		sal_btn_sum.setOnAction(event -> sal_ac_sum(event));
		sal_btn_reset.setOnAction(event -> sal_ac_reset(event));
		sal_btn_select_ok.setOnAction(event -> sal_ac_ok(event));

		// �ݱ�
		btn_close.setOnAction(event -> close_ac_close(event));
	}

	// is_�ǸŽ����Է�tab
	public void get_tab_is(String id) {
		// �� ã�ƿ���
		is_salesDate.setValue(LocalDate.now());
		is_txt_stNo.setText("00123");
		is_txt_eNo.setText(id);

		// �޺��ڽ�
		p_dao = new Product_DAO();
		no_list = p_dao.get_list_proNo();

		pro_no_list = new String[no_list.size()];
		// �迭�� �� ����
		for (int i = 0; i < pro_no_list.length; i++) {
			pro_no_list[i] = no_list.get(i).getPro_no();
		}
		// �޺��ڽ��� ���ֱ�
		is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
		is_combo_ProNo.setPromptText("��ǰ�ڵ��ȣ");

		// ��ǰ���� �޺��ڽ�
		is_combo_ProNum.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
		is_combo_ProNum.setValue("1"); // �ʱⰪ 1

		// �������� �ݾ� ã�ƿ���
		m_dao = new Main_DAO();
		s_vo = m_dao.get_ac_num_price(is_txt_eNo.getText());
		is_txt_ac_num.setText(s_vo.getAc_sales_num() + "");
		is_txt_ac_price.setText(s_vo.getAc_sales_price() + "");

		// tabȣ��
		get_tab_ss();
		// �� �Ѱ���
		ss_total_list(id);

		// tabȣ��
		get_tab_im();

		// tabȣ��
		// ����������
		sal_ac_price = Integer.parseInt(is_txt_ac_price.getText());
		sal_ac_num = Integer.parseInt(is_txt_ac_num.getText());
		get_tab_sal();

		// tabȣ��
		get_tab_close();

		is_txt_eName.setText(im_txt_eName.getText());
		label_select.setText(im_txt_eName.getText() + "�� ���� ��ȸ");

	}

	// is_�˻���ư������ �޺��ڽ� �� ��������
	@FXML
	public void ac_select(MouseEvent event) {
		if (is_combo_ProNo.getValue() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ǰ �̼���");
			alert.setHeaderText("��ǰ �׸� �����Ͻÿ�.");
			alert.setContentText("�Ǹ��Ͻ� ��ǰ�� ���� ��, ���ù�ư�� �����ּ���");

			alert.showAndWait();
			return;
		} else {
			// ���ð�
			is_combo_ProNo.getSelectionModel().getSelectedItem();
			// �� ��������
			String pro_no = (String) is_combo_ProNo.getValue();
			try {
				p_dao = new Product_DAO();
				select_list = p_dao.get_select(pro_no);
				// �� ��������
				String name = select_list.get(0).getPro_name();
				int price = select_list.get(0).getPro_price();
				is_txt_proName.setText(name);
				is_txt_proPrice.setText(price + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// �ǸŽð��ҷ�����
		LocalDate ld = is_salesDate.getValue();
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

		String time = c.getTime().getHours() + ":" + c.getTime().getMinutes();
		is_txt_SalesTime.setText(time);

	}

	// is_�Ǹ��߰���ư
	public void is_ac_input(ActionEvent event) {
		if (is_txt_proName.getText().equals("") || is_txt_SalesTime.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ���Է�");
			alert.setHeaderText("��ǰ �׸� �Է��Ͻÿ�.");
			alert.setContentText("�Է¾��� �׸��� �ֽ��ϴ�. Ȯ�� ��, �ٽ��Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		// ���Ȱ�(�⺻�ݾ�*����)
		sum = Integer.parseInt(is_txt_proPrice.getText()) * Integer.parseInt(is_combo_ProNum.getValue());
		is_txt_salesPrice.setText(sum + "");

		// �����ݾ� (�����ݾ�+���Ȱ�)
		int ac_price = Integer.parseInt(is_txt_ac_price.getText()) + sum;
		// �������� (��������+�޺��ڽ����ð���)
		int ac_num = Integer.parseInt(is_combo_ProNum.getValue()) + Integer.parseInt(is_txt_ac_num.getText());

		s_vo = new Sales_VO(is_txt_eNo.getText().trim(), is_txt_stNo.getText().trim(), ac_num, ac_price,
				is_txt_Memo.getText().trim(), is_txt_SalesTime.getText().trim(), is_combo_ProNo.getValue(),
				Integer.parseInt(is_txt_proPrice.getText()), Integer.parseInt(is_combo_ProNum.getValue()),
				is_salesDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		m_dao = new Main_DAO();

		try {
			m_dao.is_input_p(s_vo);
			// �߰��Ǹ� �ؽ�Ʈ��ȭ
			is_txt_ac_num.setText(s_vo.getAc_sales_num() + "");
			is_txt_ac_price.setText(s_vo.getAc_sales_price() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// �߰��ϸ� ���̺�信 ���ΰ�ħ
		// ss_���ΰ�ħ
		data.removeAll(data);
		ss_total_list(e_no);
		ss_tv_all.setItems(data);
	}

	// is_�ʱ�ȭ��ư
	public void is_ac_reset(ActionEvent event) {
		is_txt_Memo.setText("");
		is_txt_proName.setText("");
		is_txt_proPrice.setText("");
		is_txt_SalesTime.setText("");
		is_combo_ProNum.setValue("1");
	}

	// �ǸŽ�����ȸ tab
	public void get_tab_ss() {
		// �Ǹ����� date
		// ��¥����
		ss_salesDate.setValue(LocalDate.now());

		// ���̺��
		// �⺻(8��)
		ss_tv_time.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("sales_time"));
		ss_tv_proNo.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_no"));
		ss_tv_proNum.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_num"));
		ss_tv_proPrice.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_price"));
		ss_tv_acNum.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("ac_sales_num"));
		ss_tv_acPrice.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("ac_sales_price"));
		ss_tv_memo.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("memo"));
		ss_tv_date.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("sales_date"));
		// ��ü���̱�
		ss_tv_all.setItems(data);
	}

	// ss_���̺� �� ��ü����Ʈ
	public void ss_total_list(String e_no) {
		// ���߹迭
		Object[][] totalData;

		// �ν��Ͻ�
		m_dao = new Main_DAO();
		s_vo = new Sales_VO();

		// ArrayList
		ArrayList<String> title;
		ArrayList<Sales_VO> list;

		// Į������
		title = m_dao.get_Column_num(e_no);
		int num = title.size();
		// ����Ʈ
		list = m_dao.get_sales(e_no);
		int row = list.size();

		// �迭 ũ�����
		totalData = new Object[row][num];

		// �� ã�ƿ���
		for (int i = 0; i < row; i++) {
			s_vo = list.get(i);
			data.add(s_vo);
		}
	}

	// ss_��ü�˻� ��ư�̺�Ʈ
	public void ss_ac_select_all(ActionEvent event) {
		// ss_���ΰ�ħ
		data.removeAll(data);
		ss_total_list(e_no);
		ss_tv_all.setItems(data);
	}

	// ss_��¥�˻� ��ư�̺�Ʈ
	public void ss_ac_select_date(ActionEvent event) {
		String date = ss_salesDate.getValue().format(DateTimeFormatter.ofPattern("yy/MM/dd"));

		// ����â
		try {
			m_dao = new Main_DAO();
			select_sales_list = m_dao.get_select_date(date, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_sales_list);

	}

	// ss_��ǰ��ȣ�˻� ��ư�̺�Ʈ
	public void ss_ac_select_proNo(ActionEvent event) {
		ss_get_select_proNo(e_no);
	}

	// ss_�޸�˻� ��ư�̺�Ʈ
	public void ss_ac_select_memo(ActionEvent event) {
		ss_get_select_memo(e_no);
	}

	// ss_��ǰ��ȣ list
	public void ss_get_select_proNo(String e_no) {
		// ����â
		String pro_no = ss_txt_proName.getText();
		try {
			m_dao = new Main_DAO();
			select_sales_list = m_dao.get_select(pro_no, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_sales_list);
	}

	// ss_�޸� list
	public void ss_get_select_memo(String e_no) {
		// ����â
		String memo = ss_txt_Memo.getText();
		try {
			m_dao = new Main_DAO();
			select_memo_list = m_dao.get_select_memo(memo, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_memo_list);
	}

	// ss_����
	public void ss_ac_delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
		alert.setTitle("����");
		alert.setHeaderText("�����Ͻðڽ��ϱ�?");
		alert.setContentText("Ok��ư Ŭ����, �����Ͻ� �ǸŽ�������� �����˴ϴ�. " + "\n �����Ͻðڽ��ϱ�?");

		Optional<ButtonType> result = alert.showAndWait();
		// Ok�� ������
		if (result.get() == ButtonType.OK) {

			select_index = ss_tv_all.getSelectionModel().getSelectedIndex();
			pro_price = ss_tv_all.getSelectionModel().getSelectedItem().getPro_price();
			// ���� dao��
			m_dao = new Main_DAO();
			// �ִ밪 �޼ҵ� ȣ��
			int a = m_dao.get_ac_num(e_no);

			ac_num = data.get(select_index).getAc_sales_num();
			pro_num = data.get(select_index).getPro_num();
			data.remove(select_index);

			if (ac_num < a) {
				// �����޼ҵ�
				m_dao.get_delete(ac_num, e_no);
				// �ִ밪���� ���� ��츸 ����
				// ������ŭ �����Ƕ� update��
				try {
					m_dao.get_update_delect(pro_num, pro_price, e_no, ac_num);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ac_num >= a) {
				// �����޼ҵ�
				m_dao.get_delete(ac_num, e_no);
			}
			// ss_���ΰ�ħ
			data.removeAll(data);
			ss_total_list(e_no);
			ss_tv_all.setItems(data);
		}
	}

	// -----------------��ǰ����!
	// ��ǰ�߰���ư
	public void ac_input_pro(ActionEvent event) {
		if (txt_proName.getText().equals("") || txt_proNo.getText().equals("") || txt_proPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ���Է�");
			alert.setHeaderText("��ǰ �׸� �Է��Ͻÿ�.");
			alert.setContentText("�Է¾��� �׸��� �ֽ��ϴ�. Ȯ�� ��, �ٽ��Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}

		try {
			p_vo = new Product_VO(txt_proNo.getText(), txt_proName.getText(), Integer.parseInt(txt_proPrice.getText()),
					10000);
			p_dao = new Product_DAO();
			p_dao.input_pro(p_vo);
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("�����Է�");
			alert.setHeaderText("'��ǰ�ݾ�'�� ���ڸ� �Է°����մϴ�.");
			alert.setContentText("���ڿ��� �Է��ϼ̽��ϴ�. ���ڸ� �Է����ּ���.");

			alert.showAndWait();
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���ΰ�ħ
		p_data.removeAll(p_data);
		product_list();
		tv_all.setItems(p_data);
		
		//�޺��ڽ� ���ΰ�ħ
		no_list = p_dao.get_list_proNo();

		pro_no_list = new String[no_list.size()];
		// �迭�� �� ����
		for (int i = 0; i < pro_no_list.length; i++) {
			pro_no_list[i] = no_list.get(i).getPro_no();
		}
		
		is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
		cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
	}

	// ��ü����Ʈ
	// select�� �ٰ�������
	public void product_list() {
		// ���߹迭
		Object[][] totalData;

		// �ν��Ͻ�
		p_dao = new Product_DAO();
		p_vo = new Product_VO();

		// ArrayList
		ArrayList<String> title;
		ArrayList<Product_VO> list;

		// Į������
		title = p_dao.get_Column_num();
		int num = title.size();
		// ����Ʈ
		list = p_dao.get_pro();
		int row = list.size();

		// �迭 ũ�����
		totalData = new Object[row][num];

		// �� ã�ƿ���
		for (int i = 0; i < row; i++) {
			p_vo = list.get(i);
			p_data.add(p_vo);
		}
	}

	// �ʱ�ȭ
	// �ʱ�ȭ �׼�
	public void ac_reset(ActionEvent event) {
		txt_proName.setText("");
		txt_proNo.setText("");
		txt_proPrice.setText("");
		txt_proNo.setDisable(false);
		btn_proInput.setDisable(false);
	}

	// ����
	public void ac_edit(ActionEvent event) {
		if (txt_proName.getText().equals("") || txt_proNo.getText().equals("") || txt_proPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ǰ���� ���Է�");
			alert.setHeaderText("�����Ͻ� �׸��� �����Ͻÿ�.");
			alert.setContentText("TableView���� �����Ͻ� �׸��� ���� ��," + "\n �ٽ� �����ϼ���");

			alert.showAndWait();
			return;
		} else {
			p_vo = new Product_VO(txt_proNo.getText(), txt_proName.getText(), Integer.parseInt(txt_proPrice.getText()));
			p_dao = new Product_DAO();
			try {
				p_dao.edit_product(p_vo);
				txt_proNo.setDisable(false);
				btn_proInput.setDisable(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// ���ΰ�ħ
			p_data.removeAll(p_data);
			product_list();
			tv_all.setItems(p_data);
			
			//�޺��ڽ� ���ΰ�ħ
			no_list = p_dao.get_list_proNo();

			pro_no_list = new String[no_list.size()];
			// �迭�� �� ����
			for (int i = 0; i < pro_no_list.length; i++) {
				pro_no_list[i] = no_list.get(i).getPro_no();
			}
			
			is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
			cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
		}

	}

	// ���ÿɼ� ������ ȭ�� �ؽ�Ʈâ�� ���̱�
	public void get_select() { // ���̺� �� ���� �ɼ�
		tv_all.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1) {
					// ���õ� list =���̺��.getselectionModel().������
					p_select_list = tv_all.getSelectionModel().getSelectedItems(); // ���õ�
					// �ε�������������
					p_select_index = tv_all.getSelectionModel().getSelectedIndex();
					// �ؽ�Ʈ�ʵ�.settext(������ ����Ʈ.get(�����Ѱ� 0��°).get����ƮĮ��)
					txt_proNo.setText(p_select_list.get(0).getPro_no());
					txt_proName.setText(p_select_list.get(0).getPro_name());
					txt_proPrice.setText(p_select_list.get(0).getPro_price() + ""); // ����+���ڿ�
					txt_proNo.setDisable(true);
					btn_proInput.setDisable(true);
				}
			}
		});
	}

	// ���� �׼�
	public void ac_delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
		alert.setTitle("����");
		alert.setHeaderText("�����Ͻðڽ��ϱ�?");
		alert.setContentText("Ok��ư Ŭ����, '" + txt_proName.getText() + "' ��ǰ�� �����˴ϴ�. " + "\n �����Ͻðڽ��ϱ�?");

		// Ok�� ������
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			String pro_no = txt_proNo.getText();
			p_data.remove(p_select_index);
			// ���� dao��
			p_dao.get_delete(pro_no);

			// ���ΰ�ħ
			p_data.removeAll(p_data);
			product_list();
			tv_all.setItems(p_data);
			
			//�޺��ڽ� ���ΰ�ħ
			no_list = p_dao.get_list_proNo();

			pro_no_list = new String[no_list.size()];
			// �迭�� �� ����
			for (int i = 0; i < pro_no_list.length; i++) {
				pro_no_list[i] = no_list.get(i).getPro_no();
			}
			
			is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
			cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
		}
	}

	// �˻���ư������ �޺��ڽ� �� ��������
	@FXML
	public void p_ac_select(MouseEvent event) {
		// ���ð�
		cb_proNO.getSelectionModel().getSelectedItem();
		// �� ��������
		String pro_no = (String) cb_proNO.getValue();
		try {
			p_dao = new Product_DAO();
			p_select_list = p_dao.get_select(pro_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tv_all.setItems(p_select_list);
	}

	// ��ü��ư ������ ��ü����Ʈ �ҷ�����
	@FXML
	public void p_ac_select_all(MouseEvent event) {
		// ������ �ȿ��ִ� �����͸� �� �����.
		p_data.removeAll(p_data);
		product_list();
		tv_all.setItems(p_data);
		return;
	}

	// ��ǰ����!-----------------

	// im_������ tab
	public void get_tab_im() {
		m_dao = new Main_DAO();
		emp_list = m_dao.get_im(e_no);

		emp_name = emp_list.get(0).getE_name();
		emp_age = emp_list.get(0).getAge();
		emp_eno = emp_list.get(0).getE_no();
		emp_mag = emp_list.get(0).getMag();
		emp_phone = emp_list.get(0).getPhone();
		emp_pw = emp_list.get(0).getPw();
		emp_st_no = emp_list.get(0).getSt_no();
		emp_spot = emp_list.get(0).getSpot();
		if (emp_spot.equals("�Ŵ���")) {
			emp_sal = 2500000;
		}
		if (emp_spot.equals("�Ϲ�����")) {
			emp_sal = 1700000;
		}

		im_txt_eName.setText(emp_name);
		im_txt_eNo.setText(emp_eno);
		im_txt_age.setText(emp_age);
		im_txt_phone.setText(emp_phone);
		im_txt_mNo.setText(emp_mag);
		im_txt_pw.setText(emp_pw);
		im_txt_stNo.setText(emp_st_no);
		im_cb_spot.setValue(emp_spot);

	}

	// im_���� ��ư�̺�Ʈ
	public void im_ac_edit(ActionEvent event) {
		m_dao = new Main_DAO();
		if (im_txt_eName.getText().equals("") || im_txt_eNo.getText().equals("") || im_txt_age.getText().equals("")
				|| im_txt_pw.getText().equals("") || im_txt_phone.getText().equals("")
				|| im_txt_stNo.getText().equals("") || im_cb_spot.getValue().equals("")) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("�����Է�â �� �Է�");
			alert.setHeaderText("�����׸� ���Է�");
			alert.setContentText("�ʼ��׸��� �Է��� ���ϼ̽��ϴ�." + "\n Ȯ�� ��, �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}

		if (!im_txt_stNo.getText().equals("00123")) {

			// alertâ
			Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
			alert.setTitle("���庯��");
			alert.setHeaderText("�����ڵ带 �����Ͻðڽ��ϱ�?");
			alert.setContentText("ok��ư Ŭ����, ������忡 ��������� �����Ǹ� ȭ���� �����ϴ�. \n �α����� �ȵǸ� ��ü����� �����˴ϴ�. �Ͻðڽ��ϱ�?");

			// Ok�� ������
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				try {
					m_dao.get_im_delete(im_txt_eNo.getText());
					m_dao.get_sales_delete(im_txt_eNo.getText());
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			return;
		}

		// alertâ
		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
		alert.setTitle("�������� ����");
		alert.setHeaderText("�����Ͻ� ������ �����Ͻðڽ��ϱ�?");
		alert.setContentText("ok��ư Ŭ����, ���� �α����� �� ����� ������ �α��� �˴ϴ�.");

		// Ok�� ������
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			try {
				m_dao.get_im_edit(im_txt_eName.getText(), im_txt_age.getText(), im_txt_phone.getText(),
						im_cb_spot.getSelectionModel().getSelectedItem().toString(), im_txt_pw.getText(),
						im_txt_mNo.getText(), emp_sal, im_txt_eNo.getText());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			im_txt_eNo.setDisable(true);
			im_txt_mNo.setDisable(true);
			im_txt_stNo.setDisable(true);
			im_cb_spot.setDisable(true);
		}

	}

	// im_���� ��ư�̺�Ʈ
	public void im_ac_manager(ActionEvent event) {
		mag_id = im_txt_m_id.getText();
		mag_pw = im_txt_m_pw.getText();

		ie_dao = new Input_emp_DAO();
		// ����
		String a = null;
		String b = null;
		Alert alert;

		// ����޼ҵ� ȣ��
		ie_vo = new Input_emp_VO(mag_id);
		// ���Է�
		if (im_txt_m_id.getText().equals("") || im_txt_m_id.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ����");
			alert.setHeaderText("���� ���� �ʼ� ���Է�");
			alert.setContentText("�ʼ��Է�â �� �Է����� ���� �׸��� �ֽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		a = ie_dao.get_id_eNo(ie_vo, "�Ŵ���");
		// ����޼ҵ� ȣ��
		ie_vo = new Input_emp_VO(mag_pw);
		b = ie_dao.get_pw(ie_vo, "�Ŵ���");

		if (a == null || b == null) {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ���� ����");
			alert.setHeaderText("�Ŵ��� ���, ��й�ȣ ����ġ");
			alert.setContentText("�Ŵ��� ��� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			// ���� disableó�� false�� ����
			alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
			alert.setTitle("���Ѻο�");
			alert.setHeaderText("������ �ο��ƽ��ϴ�.");
			alert.setContentText("�Ŵ��� ���Ѹ� ����Ͻ� �� �ֽ��ϴ�." + "\n �Ŵ����� �����ø� ok��ư�� Ŭ���ϼ���");

			// Ok�� ������
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				im_txt_eNo.setDisable(false);
				im_txt_mNo.setDisable(false);
				im_txt_stNo.setDisable(false);
				im_cb_spot.setDisable(false);
				im_cb_spot.setItems(FXCollections.observableArrayList("�Ϲ�����", "�Ŵ���"));
			}
		} else {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("���� ���� ����");
			alert.setHeaderText("�Ŵ��� ���, ��й�ȣ ����ġ");
			alert.setContentText("�Ŵ��� ��� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
		}

	}

	// sal_tabȣ��
	public void get_tab_sal() {
		sal_txt_eNo.setText(e_no);
	}

	// sal_txtȣ��
	public void sal_txtall() {
		// ��ǥ�ǸŰ��� �ݾ�����
		if (emp_spot.equals("�Ŵ���")) {
			sal_g_num = 3000;
			sal_g_price = 15000000;
		}
		if (emp_spot.equals("�Ϲ�����")) {
			sal_g_num = 2000;
			sal_g_price = 10000000;
		}
		// �⺻����
		sal_txt_sal.setText((int) emp_sal + "");
		// ��ǥ�Ǹ� �����ݾ�
		sal_txt_gNum.setText((int) sal_g_num + "");
		sal_txt_gPrice.setText((int) sal_g_price + "");
		// -----------�⺻���� ��ǥ�� ������ ���� �����Ȱſ��� ����Ұ� edit���X
		sal_txt_acNum.setDisable(false);
		sal_txt_acPrice.setDisable(false);
		sal_txt_rateNum.setDisable(false);
		sal_txt_ratePrice.setDisable(false);
		sal_txt_rateNum.setEditable(false);
		sal_txt_ratePrice.setEditable(false);

		// �����Ǹ� �����ݾ�
		sal_txt_acNum.setText(is_txt_ac_num.getText());
		sal_txt_acPrice.setText(is_txt_ac_price.getText());

		// ������ ����
		sal_rate_num = (Double.parseDouble(sal_txt_acNum.getText()) / Integer.parseInt(sal_txt_gNum.getText())) * 100.0;
		sal_rate_price = (Double.parseDouble(sal_txt_acPrice.getText()) / Integer.parseInt(sal_txt_gPrice.getText()))
				* 100.0;

		sal_txt_rateNum.setText((int) sal_rate_num + "");
		sal_txt_ratePrice.setText((int) sal_rate_price + "");

		// �μ�Ƽ�� ����
		// ����������
		if (sal_rate_num >= 90.0 && sal_rate_num < 100.0) {
			sal_incen_num = 0.05; // 5%
		}
		if (sal_rate_num >= 100.0 && sal_rate_num < 110.0) {
			sal_incen_num = 0.1; // 10%
		}
		if (sal_rate_num >= 110.0) {
			sal_incen_num = 0.15; // 15%
		}

		// ����������
		if (sal_rate_price >= 90.0 && sal_rate_price < 100.0) {
			sal_incen_price = 0.05; // 5%
		}
		if (sal_rate_price >= 100.0 && sal_rate_price < 110.0) {
			sal_incen_price = 0.1; // 10%
		}
		if (sal_rate_price >= 110.0) {
			sal_incen_price = 0.15; // 15%
		}

		// �μ�Ƽ�� �ݾװ�� ( �μ�Ƽ��=�⺻����*�μ�Ƽ�꼺���� )
		double incen_num = 0;
		double incen_price = 0;

		incen_num = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_num;
		incen_price = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_price;

		// �μ�Ƽ��޼��ݾ� (�μ�Ƽ��(����)+�μ�Ƽ��(����))
		double sum = incen_num + incen_price;
		sal_txt_incentive.setText((int) sum + "");

		// ���� (�⺻����+�ǸŰ����μ�+�Ǹűݾ��μ�)�� 10%
		sal_tax = (Integer.parseInt(sal_txt_sal.getText()) + sum) * 0.1;
		sal_txt_tax.setText((int) sal_tax + "");

		// �� ���ɱ޿� (�⺻����+�ǸŰ����μ�+�Ǹűݾ��μ�-����)
		sal_true_sal = (int) (Integer.parseInt(sal_txt_sal.getText()) + sum - sal_tax);

		String a = String.format("%,d", sal_true_sal);
		sal_txt_turesal.setText(a);
	}

	// sal_�˻� ��ư�̺�Ʈ
	public void sal_ac_select(ActionEvent event) {
		sal_id = sal_txt_eNo.getText();
		sal_pw = sal_txt_pw.getText();

		ie_dao = new Input_emp_DAO();

		// �´�Ȯ�����ִº���
		String a = null;
		String b = null;
		Alert alert;

		// ����޼ҵ� ȣ��
		ie_vo = new Input_emp_VO(sal_id);

		// ���Է�
		if (sal_txt_pw.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ ���ѽ���");
			alert.setHeaderText("��й�ȣ ���Է�");
			alert.setContentText("��й�ȣâ�� �Է��� ���ϼ̽��ϴ�." + "\n Ȯ�� ��, �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		a = ie_dao.get_id_eNo2(ie_vo);

		// ����޼ҵ� ȣ��
		ie_vo = new Input_emp_VO(sal_pw);
		b = ie_dao.get_pw2(ie_vo);

		if (a == null || b == null) {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ ���ѽ���");
			alert.setHeaderText("��й�ȣ ����ġ");
			alert.setContentText("��� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			// ���� disableó�� false�� ����
			alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
			alert.setTitle("��ȸ ���Ѻο�");
			alert.setHeaderText("' " + emp_name + " '���� �½��ϱ�?");
			alert.setContentText("������ȸ�� ���θ� ����Ͻ� �� �ֽ��ϴ�." + "\n ������ �����ø� ok��ư�� �����ּ���.");

			// Ok�� ������
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ------------------------��ġ
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("��Ȯ��");
				alert.setHeaderText("��ȸ ��, ������ ���� '��ȸ�Ϸ�'��ư�� �����ּ���");
				alert.setContentText("���κ�ȣ�� ���� ��ȸ�Ͻ� ��, ��ȸ�ϷḦ �����ּ���");

				alert.showAndWait();
				sal_txtall();
			}
		} else {
			// ���̵��н����� Ȯ���϶�� â
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ ���ѽ���");
			alert.setHeaderText("��й�ȣ ����ġ");
			alert.setContentText("��� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�." + "\n �ٽ� ����� �Է��Ͻÿ�.");

			alert.showAndWait();
		}
	}

	// sal_�ʱ�ȭ ��ư�̺�Ʈ
	public void sal_ac_reset(ActionEvent event) {
		// ��������,�ݾ�, ������
		if (sal_txt_acNum.getText().equals("") || sal_txt_acPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ ���ѽ���");
			alert.setHeaderText("��й�ȣ ���Է�");
			alert.setContentText("��й�ȣâ�� �Է��� ���ϼ̽��ϴ�." + "\n Ȯ�� ��, �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("��Ȯ��");
		alert.setHeaderText("��ȸ ��, ������ ���� '��ȸ�Ϸ�'��ư�� �����ּ���");
		alert.setContentText("���κ�ȣ�� ���� ��ȸ�Ͻ� ��, ��ȸ�ϷḦ �����ּ���");

		alert.showAndWait();
		sal_txtall();
	}

	// sal_��� ��ư�̺�Ʈ
	public void sal_ac_sum(ActionEvent event) {
		// ��������,�ݾ�, ������
		if (sal_txt_acNum.getText().equals("") || sal_txt_acPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("��ȸ ���ѽ���");
			alert.setHeaderText("��й�ȣ ���Է�");
			alert.setContentText("��й�ȣâ�� �Է��� ���ϼ̽��ϴ�." + "\n Ȯ�� ��, �Է��Ͻÿ�.");

			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("��Ȯ��");
		alert.setHeaderText("��ȸ ��, ������ ���� '��ȸ�Ϸ�'��ư�� �����ּ���");
		alert.setContentText("���κ�ȣ�� ���� ��ȸ�Ͻ� ��, ��ȸ�ϷḦ �����ּ���");

		alert.showAndWait();

		try {
			// ������ ����
			sal_rate_num = (Double.parseDouble(sal_txt_acNum.getText()) / Integer.parseInt(sal_txt_gNum.getText()))
					* 100.0;
			sal_rate_price = (Double.parseDouble(sal_txt_acPrice.getText())
					/ Integer.parseInt(sal_txt_gPrice.getText())) * 100.0;

			sal_txt_rateNum.setText((int) sal_rate_num + "");
			sal_txt_ratePrice.setText((int) sal_rate_price + "");

			// �μ�Ƽ�� ����
			// ����������
			if (sal_rate_num >= 90.0 && sal_rate_num < 100.0) {
				sal_incen_num = 0.05; // 5%
			}
			if (sal_rate_num >= 100.0 && sal_rate_num < 110.0) {
				sal_incen_num = 0.1; // 10%
			}
			if (sal_rate_num >= 110.0) {
				sal_incen_num = 0.15; // 15%
			}

			// ����������
			if (sal_rate_price >= 90.0 && sal_rate_price < 100.0) {
				sal_incen_price = 0.05; // 5%
			}
			if (sal_rate_price >= 100.0 && sal_rate_price < 110.0) {
				sal_incen_price = 0.1; // 10%
			}
			if (sal_rate_price >= 110.0) {
				sal_incen_price = 0.15; // 15%
			}

			// �μ�Ƽ�� �ݾװ�� ( �μ�Ƽ��=�⺻����*�μ�Ƽ�꼺���� )
			double incen_num = 0;
			double incen_price = 0;

			incen_num = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_num;
			incen_price = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_price;

			// �μ�Ƽ��޼��ݾ� (�μ�Ƽ��(����)+�μ�Ƽ��(����))
			double sum = incen_num + incen_price;
			sal_txt_incentive.setText(sum + "");

			// ���� (�⺻����+�ǸŰ����μ�+�Ǹűݾ��μ�)�� 10%
			sal_tax = (Integer.parseInt(sal_txt_sal.getText()) + sum) * 0.1;
			sal_txt_tax.setText(sal_tax + "");

			// �� ���ɱ޿� (�⺻����+�ǸŰ����μ�+�Ǹűݾ��μ�-����)
			sal_true_sal = (int) (Integer.parseInt(sal_txt_sal.getText()) + sum - sal_tax);

			String a = String.format("%,d", sal_true_sal);
			sal_txt_turesal.setText(a);
		} catch (NumberFormatException e) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("�����Է�");
			alert.setHeaderText("�Է��׸��� ���ڸ� �Է°����մϴ�.");
			alert.setContentText("���ڿ��� �Է��ϼ̽��ϴ�. ���ڸ� �Է����ּ���.");

			alert.showAndWait();
			return;
		} catch (Exception e) {
		}

	}

	// sal_Ȯ�� ��ư�̺�Ʈ
	public void sal_ac_ok(ActionEvent event) {
		sal_txt_pw.setText("");
		sal_txt_acNum.setText("");
		sal_txt_acPrice.setText("");
		sal_txt_gNum.setText("");
		sal_txt_gPrice.setText("");
		sal_txt_rateNum.setText("");
		sal_txt_ratePrice.setText("");
		sal_txt_sal.setText("");
		sal_txt_tax.setText("");
		sal_txt_incentive.setText("");
		sal_txt_turesal.setText("");

		sal_txt_acNum.setDisable(true);
		sal_txt_acPrice.setDisable(true);
		sal_txt_rateNum.setDisable(true);
		sal_txt_ratePrice.setDisable(true);
	}

	// close_tabȣ��
	public void get_tab_close() {
		// ����������
		c_txt_name.setText(emp_name);
		c_txt_stNo.setText(emp_st_no);
		c_txt_eNo.setText(emp_eno);
		c_dp_closedate.setValue(LocalDate.now());
	}

	// close_�ݱ� ��ư�̺�Ʈ
	public void close_ac_close(ActionEvent event) {

		// ������ư Ŭ����, �� ���� �޾ƿ��� 1���̸� �ʱ�ȭ
		String date = c_dp_closedate.getValue().format(DateTimeFormatter.ofPattern("dd"));

		LocalDate ld = c_dp_closedate.getValue();
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
		// ��������¥
		int maxdate = c.getActualMaximum(Calendar.DATE);
		
		// ������ ���ڰ� ���������ڿ�����
		if (date.equals(maxdate + "")) {
			Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
			alert.setTitle("����");
			alert.setHeaderText(emp_name + "�� �����Ͻðڽ��ϱ�?");
			alert.setContentText("���� ���������ڸ�, ��� �ǸŽ����� �ʱ�ȭ�˴ϴ�.");

			// Ok�� ������
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
				alert.setTitle("������ ����");
				alert.setHeaderText("�������ڰ� �̹����� ���������� �Դϱ�?");
				alert.setContentText("������, �̹��� �ǸŽ�������� �����˴ϴ�. \n�����ϰ� �����Ͻÿ�.");

				// Ok�� ������
				Optional<ButtonType> w = alert.showAndWait();
				if (w.get() == ButtonType.OK) {
					m_dao = new Main_DAO();
					try {
						m_dao.get_sales_delete(e_no);
						m_dao.get_commit();
						Platform.exit();
					} catch (Exception e) {
					}
				}
			}
			return;
		}

		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
		alert.setTitle("����");
		alert.setHeaderText(emp_name + "�� �����Ͻðڽ��ϱ�?");
		alert.setContentText("ok��ư Ŭ�� ��, ��� ������ ����ǰ� ����˴ϴ�.");

		// Ok�� ������
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			alert = new Alert(AlertType.CONFIRMATION); // Ȯ��Ÿ��
			alert.setTitle("��������");
			alert.setHeaderText("�����Ϸ�");
			alert.setContentText("*^^���� �Ϸ� �Ǹ����ּż� �����մϴ�^^*");

			// Ok�� ������
			Optional<ButtonType> w = alert.showAndWait();
			if (w.get() == ButtonType.OK) {
				m_dao = new Main_DAO();
				try {
					m_dao.get_commit();
					Platform.exit();
				} catch (Exception e) {
				}
			}
		}

	}

	// is_��ǰ����_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_proprice_c(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("��ǰ�ڵ��ȣ ���� ��, '����'��ư�� ��������.");
		alert.setContentText("��ǰ�ݾ� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// is_��ǰ��_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_proname_c(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("��ǰ�ڵ��ȣ ���� ��, '����'��ư�� ��������.");
		alert.setContentText("��ǰ�� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// is_�����ݾ�_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_txt_acPrice(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� ���˴ϴ�.");
		alert.setContentText("�����Ǹűݾ� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// is_��������_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_txt_acnum(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� ���˴ϴ�.");
		alert.setContentText("�����ǸŰ��� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// is_�ð�_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_timetxt(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� �Էµ˴ϴ�.");
		alert.setContentText("��ǰ�ڵ��ȣ ���� ��, '����'��ư�� ��������.\n�ǸŽð� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// is_�Ǹűݾ�_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void is_ac_txt_sum(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� ���˴ϴ�.");
		alert.setContentText("'�Ǹ�'��ư�� ��������. \n�Ǹűݾ� �� ���Ƿ� �Է°� ������ �Ұ��մϴ�.");
		alert.showAndWait();
	}

	// sal_�ݾ׼�����_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void sal_ac_txt_priceRate(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� ���˴ϴ�.");
		alert.setContentText("'�����Ǹűݾ�'�Է� �� '���'��ư�� ��������.");
		alert.showAndWait();
	}

	// sal_����������_�ؽ�Ʈ�ʵ� Ŭ����
	@FXML
	public void sal_ac_txt_numRate(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // Ȯ��Ÿ��
		alert.setTitle("�ԷºҰ�");
		alert.setHeaderText("�ڵ����� ���˴ϴ�.");
		alert.setContentText("'�����ǸŰ���'�Է� �� '���'��ư�� ��������.");
		alert.showAndWait();
	}
}
