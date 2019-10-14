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

	// is 판매실적입력
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

	// ss 판매실적조회
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

	// 상품관리
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
	ArrayList<Product_VO> p_no_list; // 코드번호 주소list
	int p_select_index; // 선택한 인덱스번호
	ObservableList<Product_VO> p_select_list;
	ArrayList<Product_VO> p_select_proNO_list;
	String[] p_pro_no_list;
	@FXML
	Button btn_select_all;

	Main_m_Controller m_con = null;

	// im 내정보
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

	// sal 월급조회
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

	// c 마감
	@FXML
	Tab tab_close;
	@FXML
	DatePicker c_dp_closedate;
	@FXML
	TextField c_txt_stNo;
	@FXML
	TextField c_txt_eNo;
	@FXML
	Button btn_close;// 마감버튼
	@FXML
	Label c_label;
	@FXML
	TextField c_txt_name;

	// vo문 인스턴스 시켜줄 틀
	Sales_VO s_vo = null;
	Login_VO l_vo = null;
	Product_VO p_vo = null;
	Input_emp_VO ie_vo = null;

	// dao문 인스턴스 시켜줄 틀
	Main_DAO m_dao = null;
	Input_emp_DAO ie_dao = null;
	Product_DAO p_dao = null;
	Login_DAO l_dao = null;

	// 컨트롤러
	Login_Controller login_con = null;

	// List
	ArrayList<Product_VO> no_list; // 상품
	ArrayList<Input_emp_VO> emp_list; // 직원 리스트
	String[] pro_no_list; // 배열 (상품코드번호)
	ObservableList<Product_VO> select_list; // 상품코드
	ObservableList<Sales_VO> select_sales_list; // 판매리스트
	ObservableList<Sales_VO> select_memo_list; // 메모
	ObservableList<Sales_VO> data = FXCollections.observableArrayList(); // 전체

	// 변수
	String e_no = null; // 사원번호
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

	// 아이디비번일치알기위해 간단한변수
	String sal_id = null;
	String sal_pw = null;

	// 필드선언 (값 가져오기 위해)
	// 값가져올 때 필요
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		// 먼저 호출된다.
		this.id = id;
		// tab호출
		e_no = id;
		get_tab_is(id);
	}

	// -----------------initialize-----------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// 판매실적입력
		is_btn_select.setOnMousePressed(event -> ac_select(event));
		is_btn_sales.setOnAction(event -> is_ac_input(event));
		is_btn_reset.setOnAction(event -> is_ac_reset(event));

		// 판매실적조회
		ss_btn_select_pname.setOnAction(event -> ss_ac_select_proNo(event));
		ss_btn_select_memo.setOnAction(event -> ss_ac_select_memo(event));
		ss_btn_delete.setOnAction(event -> ss_ac_delete(event));
		ss_btn_select_all.setOnAction(event -> ss_ac_select_all(event));
		ss_btn_select_date.setOnAction(event -> ss_ac_select_date(event));

		// 상품관리
		p_dao = new Product_DAO();
		p_vo = new Product_VO();

		// ------------상품버튼
		btn_proInput.setOnAction(event -> ac_input_pro(event));
		btn_reset.setOnAction(event -> ac_reset(event));
		btn_edit.setOnAction(event -> ac_edit(event));
		btn_delete.setOnAction(event -> ac_delete(event));
		btn_select.setOnMousePressed(event -> p_ac_select(event));
		btn_select_all.setOnMousePressed(event -> p_ac_select_all(event));

		// 테이블뷰
		tv_proNo.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_no"));
		tv_proName.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_name"));
		tv_proPrice.setCellValueFactory(new PropertyValueFactory<Product_VO, String>("pro_price"));

		// 전체보이기
		product_list();
		tv_all.setItems(p_data);

		// 테이블뷰 선택 시, 텍스트창에 보내기
		get_select();

		// 콤보박스
		// 보여지는 텍스트 설정
		p_no_list = p_dao.get_list_proNo(); // 칼럼값 가져오기 코드번호 가져오기
		p_pro_no_list = new String[p_no_list.size()];
		for (int i = 0; i < p_no_list.size(); i++) {
			p_pro_no_list[i] = p_no_list.get(i).getPro_no();
		}
		cb_proNO.setItems(FXCollections.observableArrayList(p_pro_no_list));
		// 초기값 설정
		cb_proNO.setPromptText("코드번호 선택");

		// 상품끝----------------------------------

		// im 내정보
		im_btn_edit.setOnAction(event -> im_ac_edit(event)); // 수정
		im_btn_m_edit.setOnAction(event -> im_ac_manager(event));

		// sal 월급조회
		sal_btn_select_sal.setOnAction(event -> sal_ac_select(event));
		sal_btn_sum.setOnAction(event -> sal_ac_sum(event));
		sal_btn_reset.setOnAction(event -> sal_ac_reset(event));
		sal_btn_select_ok.setOnAction(event -> sal_ac_ok(event));

		// 닫기
		btn_close.setOnAction(event -> close_ac_close(event));
	}

	// is_판매실적입력tab
	public void get_tab_is(String id) {
		// 값 찾아오기
		is_salesDate.setValue(LocalDate.now());
		is_txt_stNo.setText("00123");
		is_txt_eNo.setText(id);

		// 콤보박스
		p_dao = new Product_DAO();
		no_list = p_dao.get_list_proNo();

		pro_no_list = new String[no_list.size()];
		// 배열에 값 넣음
		for (int i = 0; i < pro_no_list.length; i++) {
			pro_no_list[i] = no_list.get(i).getPro_no();
		}
		// 콤보박스에 값넣기
		is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
		is_combo_ProNo.setPromptText("상품코드번호");

		// 상품개수 콤보박스
		is_combo_ProNum.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
		is_combo_ProNum.setValue("1"); // 초기값 1

		// 누적개수 금액 찾아오기
		m_dao = new Main_DAO();
		s_vo = m_dao.get_ac_num_price(is_txt_eNo.getText());
		is_txt_ac_num.setText(s_vo.getAc_sales_num() + "");
		is_txt_ac_price.setText(s_vo.getAc_sales_price() + "");

		// tab호출
		get_tab_ss();
		// 값 넘겨줌
		ss_total_list(id);

		// tab호출
		get_tab_im();

		// tab호출
		// 누적값설정
		sal_ac_price = Integer.parseInt(is_txt_ac_price.getText());
		sal_ac_num = Integer.parseInt(is_txt_ac_num.getText());
		get_tab_sal();

		// tab호출
		get_tab_close();

		is_txt_eName.setText(im_txt_eName.getText());
		label_select.setText(im_txt_eName.getText() + "님 정보 조회");

	}

	// is_검색버튼누르면 콤보박스 값 가져오기
	@FXML
	public void ac_select(MouseEvent event) {
		if (is_combo_ProNo.getValue() == null) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("상품 미선택");
			alert.setHeaderText("상품 항목 선택하시오.");
			alert.setContentText("판매하신 상품을 선택 후, 선택버튼을 눌러주세요");

			alert.showAndWait();
			return;
		} else {
			// 선택값
			is_combo_ProNo.getSelectionModel().getSelectedItem();
			// 값 가져오기
			String pro_no = (String) is_combo_ProNo.getValue();
			try {
				p_dao = new Product_DAO();
				select_list = p_dao.get_select(pro_no);
				// 값 가져오기
				String name = select_list.get(0).getPro_name();
				int price = select_list.get(0).getPro_price();
				is_txt_proName.setText(name);
				is_txt_proPrice.setText(price + "");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// 판매시간불러오기
		LocalDate ld = is_salesDate.getValue();
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());

		String time = c.getTime().getHours() + ":" + c.getTime().getMinutes();
		is_txt_SalesTime.setText(time);

	}

	// is_판매추가버튼
	public void is_ac_input(ActionEvent event) {
		if (is_txt_proName.getText().equals("") || is_txt_SalesTime.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("정보 미입력");
			alert.setHeaderText("상품 항목 입력하시오.");
			alert.setContentText("입력안한 항목이 있습니다. 확인 후, 다시입력하시오.");

			alert.showAndWait();
			return;
		}
		// 계산된값(기본금액*개수)
		sum = Integer.parseInt(is_txt_proPrice.getText()) * Integer.parseInt(is_combo_ProNum.getValue());
		is_txt_salesPrice.setText(sum + "");

		// 누적금액 (누적금액+계산된값)
		int ac_price = Integer.parseInt(is_txt_ac_price.getText()) + sum;
		// 누적개수 (누적개수+콤보박스선택개수)
		int ac_num = Integer.parseInt(is_combo_ProNum.getValue()) + Integer.parseInt(is_txt_ac_num.getText());

		s_vo = new Sales_VO(is_txt_eNo.getText().trim(), is_txt_stNo.getText().trim(), ac_num, ac_price,
				is_txt_Memo.getText().trim(), is_txt_SalesTime.getText().trim(), is_combo_ProNo.getValue(),
				Integer.parseInt(is_txt_proPrice.getText()), Integer.parseInt(is_combo_ProNum.getValue()),
				is_salesDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		m_dao = new Main_DAO();

		try {
			m_dao.is_input_p(s_vo);
			// 추가되면 텍스트변화
			is_txt_ac_num.setText(s_vo.getAc_sales_num() + "");
			is_txt_ac_price.setText(s_vo.getAc_sales_price() + "");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 추가하면 테이블뷰에 새로고침
		// ss_새로고침
		data.removeAll(data);
		ss_total_list(e_no);
		ss_tv_all.setItems(data);
	}

	// is_초기화버튼
	public void is_ac_reset(ActionEvent event) {
		is_txt_Memo.setText("");
		is_txt_proName.setText("");
		is_txt_proPrice.setText("");
		is_txt_SalesTime.setText("");
		is_combo_ProNum.setValue("1");
	}

	// 판매실적조회 tab
	public void get_tab_ss() {
		// 판매일자 date
		// 날짜지정
		ss_salesDate.setValue(LocalDate.now());

		// 테이블뷰
		// 기본(8개)
		ss_tv_time.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("sales_time"));
		ss_tv_proNo.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_no"));
		ss_tv_proNum.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_num"));
		ss_tv_proPrice.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("pro_price"));
		ss_tv_acNum.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("ac_sales_num"));
		ss_tv_acPrice.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("ac_sales_price"));
		ss_tv_memo.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("memo"));
		ss_tv_date.setCellValueFactory(new PropertyValueFactory<Sales_VO, String>("sales_date"));
		// 전체보이기
		ss_tv_all.setItems(data);
	}

	// ss_테이블 뷰 전체리스트
	public void ss_total_list(String e_no) {
		// 이중배열
		Object[][] totalData;

		// 인스턴스
		m_dao = new Main_DAO();
		s_vo = new Sales_VO();

		// ArrayList
		ArrayList<String> title;
		ArrayList<Sales_VO> list;

		// 칼럼개수
		title = m_dao.get_Column_num(e_no);
		int num = title.size();
		// 리스트
		list = m_dao.get_sales(e_no);
		int row = list.size();

		// 배열 크기생성
		totalData = new Object[row][num];

		// 값 찾아오기
		for (int i = 0; i < row; i++) {
			s_vo = list.get(i);
			data.add(s_vo);
		}
	}

	// ss_전체검색 버튼이벤트
	public void ss_ac_select_all(ActionEvent event) {
		// ss_새로고침
		data.removeAll(data);
		ss_total_list(e_no);
		ss_tv_all.setItems(data);
	}

	// ss_날짜검색 버튼이벤트
	public void ss_ac_select_date(ActionEvent event) {
		String date = ss_salesDate.getValue().format(DateTimeFormatter.ofPattern("yy/MM/dd"));

		// 선택창
		try {
			m_dao = new Main_DAO();
			select_sales_list = m_dao.get_select_date(date, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_sales_list);

	}

	// ss_상품번호검색 버튼이벤트
	public void ss_ac_select_proNo(ActionEvent event) {
		ss_get_select_proNo(e_no);
	}

	// ss_메모검색 버튼이벤트
	public void ss_ac_select_memo(ActionEvent event) {
		ss_get_select_memo(e_no);
	}

	// ss_상품번호 list
	public void ss_get_select_proNo(String e_no) {
		// 선택창
		String pro_no = ss_txt_proName.getText();
		try {
			m_dao = new Main_DAO();
			select_sales_list = m_dao.get_select(pro_no, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_sales_list);
	}

	// ss_메모 list
	public void ss_get_select_memo(String e_no) {
		// 선택창
		String memo = ss_txt_Memo.getText();
		try {
			m_dao = new Main_DAO();
			select_memo_list = m_dao.get_select_memo(memo, e_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss_tv_all.setItems(select_memo_list);
	}

	// ss_삭제
	public void ss_ac_delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
		alert.setTitle("삭제");
		alert.setHeaderText("삭제하시겠습니까?");
		alert.setContentText("Ok버튼 클릭시, 선택하신 판매실적기록은 삭제됩니다. " + "\n 삭제하시겠습니까?");

		Optional<ButtonType> result = alert.showAndWait();
		// Ok를 누를때
		if (result.get() == ButtonType.OK) {

			select_index = ss_tv_all.getSelectionModel().getSelectedIndex();
			pro_price = ss_tv_all.getSelectionModel().getSelectedItem().getPro_price();
			// 삭제 dao문
			m_dao = new Main_DAO();
			// 최대값 메소드 호출
			int a = m_dao.get_ac_num(e_no);

			ac_num = data.get(select_index).getAc_sales_num();
			pro_num = data.get(select_index).getPro_num();
			data.remove(select_index);

			if (ac_num < a) {
				// 삭제메소드
				m_dao.get_delete(ac_num, e_no);
				// 최대값보다 작을 경우만 실행
				// 개수만큼 삭제되라 update문
				try {
					m_dao.get_update_delect(pro_num, pro_price, e_no, ac_num);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ac_num >= a) {
				// 삭제메소드
				m_dao.get_delete(ac_num, e_no);
			}
			// ss_새로고침
			data.removeAll(data);
			ss_total_list(e_no);
			ss_tv_all.setItems(data);
		}
	}

	// -----------------상품관리!
	// 상품추가버튼
	public void ac_input_pro(ActionEvent event) {
		if (txt_proName.getText().equals("") || txt_proNo.getText().equals("") || txt_proPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("정보 미입력");
			alert.setHeaderText("상품 항목 입력하시오.");
			alert.setContentText("입력안한 항목이 있습니다. 확인 후, 다시입력하시오.");

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
			alert.setTitle("문자입력");
			alert.setHeaderText("'상품금액'은 숫자만 입력가능합니다.");
			alert.setContentText("문자열을 입력하셨습니다. 숫자만 입력해주세요.");

			alert.showAndWait();
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 새로고침
		p_data.removeAll(p_data);
		product_list();
		tv_all.setItems(p_data);
		
		//콤보박스 새로고침
		no_list = p_dao.get_list_proNo();

		pro_no_list = new String[no_list.size()];
		// 배열에 값 넣음
		for (int i = 0; i < pro_no_list.length; i++) {
			pro_no_list[i] = no_list.get(i).getPro_no();
		}
		
		is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
		cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
	}

	// 전체리스트
	// select값 다가져오기
	public void product_list() {
		// 이중배열
		Object[][] totalData;

		// 인스턴스
		p_dao = new Product_DAO();
		p_vo = new Product_VO();

		// ArrayList
		ArrayList<String> title;
		ArrayList<Product_VO> list;

		// 칼럼개수
		title = p_dao.get_Column_num();
		int num = title.size();
		// 리스트
		list = p_dao.get_pro();
		int row = list.size();

		// 배열 크기생성
		totalData = new Object[row][num];

		// 값 찾아오기
		for (int i = 0; i < row; i++) {
			p_vo = list.get(i);
			p_data.add(p_vo);
		}
	}

	// 초기화
	// 초기화 액션
	public void ac_reset(ActionEvent event) {
		txt_proName.setText("");
		txt_proNo.setText("");
		txt_proPrice.setText("");
		txt_proNo.setDisable(false);
		btn_proInput.setDisable(false);
	}

	// 수정
	public void ac_edit(ActionEvent event) {
		if (txt_proName.getText().equals("") || txt_proNo.getText().equals("") || txt_proPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("상품정보 미입력");
			alert.setHeaderText("수정하실 항목을 선택하시오.");
			alert.setContentText("TableView에서 수정하실 항목을 선택 후," + "\n 다시 실행하세요");

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
			// 새로고침
			p_data.removeAll(p_data);
			product_list();
			tv_all.setItems(p_data);
			
			//콤보박스 새로고침
			no_list = p_dao.get_list_proNo();

			pro_no_list = new String[no_list.size()];
			// 배열에 값 넣음
			for (int i = 0; i < pro_no_list.length; i++) {
				pro_no_list[i] = no_list.get(i).getPro_no();
			}
			
			is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
			cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
		}

	}

	// 선택옵션 선택한 화면 텍스트창에 보이기
	public void get_select() { // 테이블 뷰 선택 옵션
		tv_all.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 1) {
					// 선택된 list =테이블뷰.getselectionModel().아이템
					p_select_list = tv_all.getSelectionModel().getSelectedItems(); // 선택된
					// 인덱스값가져오기
					p_select_index = tv_all.getSelectionModel().getSelectedIndex();
					// 텍스트필드.settext(선택한 리스트.get(선택한거 0번째).get리스트칼럼)
					txt_proNo.setText(p_select_list.get(0).getPro_no());
					txt_proName.setText(p_select_list.get(0).getPro_name());
					txt_proPrice.setText(p_select_list.get(0).getPro_price() + ""); // 숫자+문자열
					txt_proNo.setDisable(true);
					btn_proInput.setDisable(true);
				}
			}
		});
	}

	// 삭제 액션
	public void ac_delete(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
		alert.setTitle("삭제");
		alert.setHeaderText("삭제하시겠습니까?");
		alert.setContentText("Ok버튼 클릭시, '" + txt_proName.getText() + "' 상품은 삭제됩니다. " + "\n 삭제하시겠습니까?");

		// Ok를 누를때
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			String pro_no = txt_proNo.getText();
			p_data.remove(p_select_index);
			// 삭제 dao문
			p_dao.get_delete(pro_no);

			// 새로고침
			p_data.removeAll(p_data);
			product_list();
			tv_all.setItems(p_data);
			
			//콤보박스 새로고침
			no_list = p_dao.get_list_proNo();

			pro_no_list = new String[no_list.size()];
			// 배열에 값 넣음
			for (int i = 0; i < pro_no_list.length; i++) {
				pro_no_list[i] = no_list.get(i).getPro_no();
			}
			
			is_combo_ProNo.setItems(FXCollections.observableArrayList(pro_no_list));
			cb_proNO.setItems(FXCollections.observableArrayList(pro_no_list));
		}
	}

	// 검색버튼누르면 콤보박스 값 가져오기
	@FXML
	public void p_ac_select(MouseEvent event) {
		// 선택값
		cb_proNO.getSelectionModel().getSelectedItem();
		// 값 가져오기
		String pro_no = (String) cb_proNO.getValue();
		try {
			p_dao = new Product_DAO();
			p_select_list = p_dao.get_select(pro_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tv_all.setItems(p_select_list);
	}

	// 전체버튼 누르면 전체리스트 불러오기
	@FXML
	public void p_ac_select_all(MouseEvent event) {
		// 데이터 안에있는 데이터를 다 지운다.
		p_data.removeAll(p_data);
		product_list();
		tv_all.setItems(p_data);
		return;
	}

	// 상품관리!-----------------

	// im_내정보 tab
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
		if (emp_spot.equals("매니저")) {
			emp_sal = 2500000;
		}
		if (emp_spot.equals("일반직원")) {
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

	// im_수정 버튼이벤트
	public void im_ac_edit(ActionEvent event) {
		m_dao = new Main_DAO();
		if (im_txt_eName.getText().equals("") || im_txt_eNo.getText().equals("") || im_txt_age.getText().equals("")
				|| im_txt_pw.getText().equals("") || im_txt_phone.getText().equals("")
				|| im_txt_stNo.getText().equals("") || im_cb_spot.getValue().equals("")) {

			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("수정입력창 미 입력");
			alert.setHeaderText("수정항목 미입력");
			alert.setContentText("필수항목을 입력을 안하셨습니다." + "\n 확인 후, 입력하시오.");

			alert.showAndWait();
			return;
		}

		if (!im_txt_stNo.getText().equals("00123")) {

			// alert창
			Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
			alert.setTitle("매장변경");
			alert.setHeaderText("매장코드를 변경하시겠습니까?");
			alert.setContentText("ok버튼 클릭시, 현재매장에 직원기록은 삭제되며 화면이 꺼집니다. \n 로그인이 안되며 전체기록이 삭제됩니다. 하시겠습니까?");

			// Ok를 누를때
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

		// alert창
		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
		alert.setTitle("직원정보 수정");
		alert.setHeaderText("변경하신 내용대로 수정하시겠습니까?");
		alert.setContentText("ok버튼 클릭시, 다음 로그인할 때 변경된 정보로 로그인 됩니다.");

		// Ok를 누를때
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

	// im_권한 버튼이벤트
	public void im_ac_manager(ActionEvent event) {
		mag_id = im_txt_m_id.getText();
		mag_pw = im_txt_m_pw.getText();

		ie_dao = new Input_emp_DAO();
		// 직급
		String a = null;
		String b = null;
		Alert alert;

		// 사번메소드 호출
		ie_vo = new Input_emp_VO(mag_id);
		// 미입력
		if (im_txt_m_id.getText().equals("") || im_txt_m_id.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("수정 실패");
			alert.setHeaderText("직원 정보 필수 미입력");
			alert.setContentText("필수입력창 중 입력하지 않은 항목이 있습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
			return;
		}
		a = ie_dao.get_id_eNo(ie_vo, "매니저");
		// 비번메소드 호출
		ie_vo = new Input_emp_VO(mag_pw);
		b = ie_dao.get_pw(ie_vo, "매니저");

		if (a == null || b == null) {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("권한 접속 실패");
			alert.setHeaderText("매니저 사번, 비밀번호 불일치");
			alert.setContentText("매니저 사번 과 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			// 성공 disable처리 false로 변경
			alert = new Alert(AlertType.CONFIRMATION); // 확인타입
			alert.setTitle("권한부여");
			alert.setHeaderText("권한이 부여됐습니다.");
			alert.setContentText("매니저 권한만 사용하실 수 있습니다." + "\n 매니저가 맞으시면 ok버튼을 클릭하세요");

			// Ok를 누를때
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				im_txt_eNo.setDisable(false);
				im_txt_mNo.setDisable(false);
				im_txt_stNo.setDisable(false);
				im_cb_spot.setDisable(false);
				im_cb_spot.setItems(FXCollections.observableArrayList("일반직원", "매니저"));
			}
		} else {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("권한 접속 실패");
			alert.setHeaderText("매니저 사번, 비밀번호 불일치");
			alert.setContentText("매니저 사번 과 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
		}

	}

	// sal_tab호출
	public void get_tab_sal() {
		sal_txt_eNo.setText(e_no);
	}

	// sal_txt호출
	public void sal_txtall() {
		// 목표판매개수 금액지정
		if (emp_spot.equals("매니저")) {
			sal_g_num = 3000;
			sal_g_price = 15000000;
		}
		if (emp_spot.equals("일반직원")) {
			sal_g_num = 2000;
			sal_g_price = 10000000;
		}
		// 기본원금
		sal_txt_sal.setText((int) emp_sal + "");
		// 목표판매 개수금액
		sal_txt_gNum.setText((int) sal_g_num + "");
		sal_txt_gPrice.setText((int) sal_g_price + "");
		// -----------기본원금 목표는 직위에 따라 결정된거여서 변경불가 edit허용X
		sal_txt_acNum.setDisable(false);
		sal_txt_acPrice.setDisable(false);
		sal_txt_rateNum.setDisable(false);
		sal_txt_ratePrice.setDisable(false);
		sal_txt_rateNum.setEditable(false);
		sal_txt_ratePrice.setEditable(false);

		// 누적판매 개수금액
		sal_txt_acNum.setText(is_txt_ac_num.getText());
		sal_txt_acPrice.setText(is_txt_ac_price.getText());

		// 성과율 지정
		sal_rate_num = (Double.parseDouble(sal_txt_acNum.getText()) / Integer.parseInt(sal_txt_gNum.getText())) * 100.0;
		sal_rate_price = (Double.parseDouble(sal_txt_acPrice.getText()) / Integer.parseInt(sal_txt_gPrice.getText()))
				* 100.0;

		sal_txt_rateNum.setText((int) sal_rate_num + "");
		sal_txt_ratePrice.setText((int) sal_rate_price + "");

		// 인센티브 지정
		// 개수성과율
		if (sal_rate_num >= 90.0 && sal_rate_num < 100.0) {
			sal_incen_num = 0.05; // 5%
		}
		if (sal_rate_num >= 100.0 && sal_rate_num < 110.0) {
			sal_incen_num = 0.1; // 10%
		}
		if (sal_rate_num >= 110.0) {
			sal_incen_num = 0.15; // 15%
		}

		// 개수성과율
		if (sal_rate_price >= 90.0 && sal_rate_price < 100.0) {
			sal_incen_price = 0.05; // 5%
		}
		if (sal_rate_price >= 100.0 && sal_rate_price < 110.0) {
			sal_incen_price = 0.1; // 10%
		}
		if (sal_rate_price >= 110.0) {
			sal_incen_price = 0.15; // 15%
		}

		// 인센티브 금액계산 ( 인센티브=기본원금*인센티브성과율 )
		double incen_num = 0;
		double incen_price = 0;

		incen_num = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_num;
		incen_price = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_price;

		// 인센티브달성금액 (인센티브(개수)+인센티브(가격))
		double sum = incen_num + incen_price;
		sal_txt_incentive.setText((int) sum + "");

		// 세금 (기본원금+판매개수인센+판매금액인센)의 10%
		sal_tax = (Integer.parseInt(sal_txt_sal.getText()) + sum) * 0.1;
		sal_txt_tax.setText((int) sal_tax + "");

		// 실 수령급여 (기본원금+판매개수인센+판매금액인센-세금)
		sal_true_sal = (int) (Integer.parseInt(sal_txt_sal.getText()) + sum - sal_tax);

		String a = String.format("%,d", sal_true_sal);
		sal_txt_turesal.setText(a);
	}

	// sal_검색 버튼이벤트
	public void sal_ac_select(ActionEvent event) {
		sal_id = sal_txt_eNo.getText();
		sal_pw = sal_txt_pw.getText();

		ie_dao = new Input_emp_DAO();

		// 맞는확인해주는변수
		String a = null;
		String b = null;
		Alert alert;

		// 사번메소드 호출
		ie_vo = new Input_emp_VO(sal_id);

		// 미입력
		if (sal_txt_pw.getText().equals("")) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회 권한실패");
			alert.setHeaderText("비밀번호 미입력");
			alert.setContentText("비밀번호창을 입력을 안하셨습니다." + "\n 확인 후, 입력하시오.");

			alert.showAndWait();
			return;
		}
		a = ie_dao.get_id_eNo2(ie_vo);

		// 비번메소드 호출
		ie_vo = new Input_emp_VO(sal_pw);
		b = ie_dao.get_pw2(ie_vo);

		if (a == null || b == null) {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회 권한실패");
			alert.setHeaderText("비밀번호 불일치");
			alert.setContentText("사번 과 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
			return;
		}
		if (a.equals(b) && a != null) {
			// 성공 disable처리 false로 변경
			alert = new Alert(AlertType.CONFIRMATION); // 확인타입
			alert.setTitle("조회 권한부여");
			alert.setHeaderText("' " + emp_name + " '님이 맞습니까?");
			alert.setContentText("월급조회는 본인만 사용하실 수 있습니다." + "\n 본인이 맞으시면 ok버튼을 눌러주세요.");

			// Ok를 누를때
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				// ------------------------일치
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("재확인");
				alert.setHeaderText("조회 후, 보안을 위해 '조회완료'버튼을 눌러주세요");
				alert.setContentText("개인보호를 위해 조회하신 후, 조회완료를 눌러주세요");

				alert.showAndWait();
				sal_txtall();
			}
		} else {
			// 아이디패스워드 확인하라는 창
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회 권한실패");
			alert.setHeaderText("비밀번호 불일치");
			alert.setContentText("사번 과 비밀번호가 일치하지 않습니다." + "\n 다시 제대로 입력하시오.");

			alert.showAndWait();
		}
	}

	// sal_초기화 버튼이벤트
	public void sal_ac_reset(ActionEvent event) {
		// 누적개수,금액, 성과율
		if (sal_txt_acNum.getText().equals("") || sal_txt_acPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회 권한실패");
			alert.setHeaderText("비밀번호 미입력");
			alert.setContentText("비밀번호창을 입력을 안하셨습니다." + "\n 확인 후, 입력하시오.");

			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("재확인");
		alert.setHeaderText("조회 후, 보안을 위해 '조회완료'버튼을 눌러주세요");
		alert.setContentText("개인보호를 위해 조회하신 후, 조회완료를 눌러주세요");

		alert.showAndWait();
		sal_txtall();
	}

	// sal_계산 버튼이벤트
	public void sal_ac_sum(ActionEvent event) {
		// 누적개수,금액, 성과율
		if (sal_txt_acNum.getText().equals("") || sal_txt_acPrice.getText().equals("")) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("조회 권한실패");
			alert.setHeaderText("비밀번호 미입력");
			alert.setContentText("비밀번호창을 입력을 안하셨습니다." + "\n 확인 후, 입력하시오.");

			alert.showAndWait();
			return;
		}
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("재확인");
		alert.setHeaderText("조회 후, 보안을 위해 '조회완료'버튼을 눌러주세요");
		alert.setContentText("개인보호를 위해 조회하신 후, 조회완료를 눌러주세요");

		alert.showAndWait();

		try {
			// 성과율 지정
			sal_rate_num = (Double.parseDouble(sal_txt_acNum.getText()) / Integer.parseInt(sal_txt_gNum.getText()))
					* 100.0;
			sal_rate_price = (Double.parseDouble(sal_txt_acPrice.getText())
					/ Integer.parseInt(sal_txt_gPrice.getText())) * 100.0;

			sal_txt_rateNum.setText((int) sal_rate_num + "");
			sal_txt_ratePrice.setText((int) sal_rate_price + "");

			// 인센티브 지정
			// 개수성과율
			if (sal_rate_num >= 90.0 && sal_rate_num < 100.0) {
				sal_incen_num = 0.05; // 5%
			}
			if (sal_rate_num >= 100.0 && sal_rate_num < 110.0) {
				sal_incen_num = 0.1; // 10%
			}
			if (sal_rate_num >= 110.0) {
				sal_incen_num = 0.15; // 15%
			}

			// 개수성과율
			if (sal_rate_price >= 90.0 && sal_rate_price < 100.0) {
				sal_incen_price = 0.05; // 5%
			}
			if (sal_rate_price >= 100.0 && sal_rate_price < 110.0) {
				sal_incen_price = 0.1; // 10%
			}
			if (sal_rate_price >= 110.0) {
				sal_incen_price = 0.15; // 15%
			}

			// 인센티브 금액계산 ( 인센티브=기본원금*인센티브성과율 )
			double incen_num = 0;
			double incen_price = 0;

			incen_num = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_num;
			incen_price = Integer.parseInt(sal_txt_sal.getText()) * sal_incen_price;

			// 인센티브달성금액 (인센티브(개수)+인센티브(가격))
			double sum = incen_num + incen_price;
			sal_txt_incentive.setText(sum + "");

			// 세금 (기본원금+판매개수인센+판매금액인센)의 10%
			sal_tax = (Integer.parseInt(sal_txt_sal.getText()) + sum) * 0.1;
			sal_txt_tax.setText(sal_tax + "");

			// 실 수령급여 (기본원금+판매개수인센+판매금액인센-세금)
			sal_true_sal = (int) (Integer.parseInt(sal_txt_sal.getText()) + sum - sal_tax);

			String a = String.format("%,d", sal_true_sal);
			sal_txt_turesal.setText(a);
		} catch (NumberFormatException e) {
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("문자입력");
			alert.setHeaderText("입력항목은 숫자만 입력가능합니다.");
			alert.setContentText("문자열을 입력하셨습니다. 숫자만 입력해주세요.");

			alert.showAndWait();
			return;
		} catch (Exception e) {
		}

	}

	// sal_확인 버튼이벤트
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

	// close_tab호출
	public void get_tab_close() {
		// 값가져오기
		c_txt_name.setText(emp_name);
		c_txt_stNo.setText(emp_st_no);
		c_txt_eNo.setText(emp_eno);
		c_dp_closedate.setValue(LocalDate.now());
	}

	// close_닫기 버튼이벤트
	public void close_ac_close(ActionEvent event) {

		// 마감버튼 클릭시, 월 일자 받아오고 1일이면 초기화
		String date = c_dp_closedate.getValue().format(DateTimeFormatter.ofPattern("dd"));

		LocalDate ld = c_dp_closedate.getValue();
		Calendar c = Calendar.getInstance();
		c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
		// 마지막날짜
		int maxdate = c.getActualMaximum(Calendar.DATE);
		
		// 선택한 일자가 마지막일자였으면
		if (date.equals(maxdate + "")) {
			Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
			alert.setTitle("마감");
			alert.setHeaderText(emp_name + "님 마감하시겠습니까?");
			alert.setContentText("달의 마지막일자면, 모든 판매실적은 초기화됩니다.");

			// Ok를 누를때
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				alert = new Alert(AlertType.CONFIRMATION); // 확인타입
				alert.setTitle("마지막 일자");
				alert.setHeaderText("마감일자가 이번달의 마지막일자 입니까?");
				alert.setContentText("마감시, 이번달 판매실적기록은 삭제됩니다. \n신중하게 생각하시오.");

				// Ok를 누를때
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

		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인타입
		alert.setTitle("마감");
		alert.setHeaderText(emp_name + "님 마감하시겠습니까?");
		alert.setContentText("ok버튼 클릭 시, 모든 정보는 저장되고 종료됩니다.");

		// Ok를 누를때
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			alert = new Alert(AlertType.CONFIRMATION); // 확인타입
			alert.setTitle("마감성공");
			alert.setHeaderText("마감완료");
			alert.setContentText("*^^오늘 하루 판매해주셔서 감사합니다^^*");

			// Ok를 누를때
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

	// is_상품가격_텍스트필드 클릭시
	@FXML
	public void is_ac_proprice_c(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("상품코드번호 선택 후, '선택'버튼을 누르세요.");
		alert.setContentText("상품금액 은 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// is_상품명_텍스트필드 클릭시
	@FXML
	public void is_ac_proname_c(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("상품코드번호 선택 후, '선택'버튼을 누르세요.");
		alert.setContentText("상품명 은 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// is_누적금액_텍스트필드 클릭시
	@FXML
	public void is_ac_txt_acPrice(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 계산됩니다.");
		alert.setContentText("누적판매금액 은 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// is_누적개수_텍스트필드 클릭시
	@FXML
	public void is_ac_txt_acnum(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 계산됩니다.");
		alert.setContentText("누적판매개수 는 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// is_시간_텍스트필드 클릭시
	@FXML
	public void is_ac_timetxt(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 입력됩니다.");
		alert.setContentText("상품코드번호 선택 후, '선택'버튼을 누르세요.\n판매시간 은 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// is_판매금액_텍스트필드 클릭시
	@FXML
	public void is_ac_txt_sum(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 계산됩니다.");
		alert.setContentText("'판매'버튼을 누르세요. \n판매금액 은 임의로 입력과 수정이 불가합니다.");
		alert.showAndWait();
	}

	// sal_금액성과율_텍스트필드 클릭시
	@FXML
	public void sal_ac_txt_priceRate(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 계산됩니다.");
		alert.setContentText("'누적판매금액'입력 후 '계산'버튼을 누르세요.");
		alert.showAndWait();
	}

	// sal_개수성과율_텍스트필드 클릭시
	@FXML
	public void sal_ac_txt_numRate(MouseEvent event) {
		Alert alert = new Alert(AlertType.WARNING); // 확인타입
		alert.setTitle("입력불가");
		alert.setHeaderText("자동으로 계산됩니다.");
		alert.setContentText("'누적판매개수'입력 후 '계산'버튼을 누르세요.");
		alert.showAndWait();
	}
}
