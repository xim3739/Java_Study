package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.GoodsDAO;
import model.GoodsVO;
import model.SaleDAO;
import model.SaleVO;
import util.AlertMessage;

public class MainController implements Initializable {

	@FXML
	private TextField tfGoodsName;
	@FXML
	private Button btSearch;
	@FXML
	private Button btSaleAdd;
	@FXML
	private Button btSaleDelete;
	@FXML
	private Button btMenuCheck;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TableView<SaleVO> tableView;
	// @FXML private BarChart<X, Y> barChart;

	/********************
	 * 기능 : 필요한 saleVO 모델의 변수 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */
	private ObservableList<SaleVO> saleVOList = FXCollections.observableArrayList();
	private ObservableList<SaleVO> addSaleVOList = FXCollections.observableArrayList();
	private ObservableList<SaleVO> selectSaleVOList = FXCollections.observableArrayList();
	private int selectSaleIndex = 0;
	private ArrayList<SaleVO> selectSaleVO = new ArrayList<SaleVO>();
	private ArrayList<SaleVO> searchDateSaleVO = new ArrayList<SaleVO>();
	private SaleVO selectSale = null;
	private SaleDAO saleDAO = null;
	private SaleVO saveSaleVO = null;;
	private String saveGoodsString = null;

	/*******************************
	 * 기능 : 필요한 goodsVO의 변수들 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */
	private ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
	private ObservableList<GoodsVO> goodsVOList = FXCollections.observableArrayList();
	private ObservableList<String> goodsNameList = FXCollections.observableArrayList();;
	private GoodsDAO goodsDVO = null;;
	private String editGoods = null;;
	private ObservableList<GoodsVO> selectMenuEditGoodsVOList = FXCollections.observableArrayList();
	private GoodsVO selectMenuEditGoodsVO = null;

	/**********************************
	 * 기능 : 필요한 그 외의 변수들 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */
	private LocalDate localDate = null;
	private int savePrice = 0;
	private int saveTotalPrice = 0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tableViewSetting();

		// loadTotalSaleDB();

		loadTotalGoodsDB();

		tableView.setOnMousePressed(e1 -> {

			selectSaleVOList = tableView.getSelectionModel().getSelectedItems();
			selectSale = tableView.getSelectionModel().getSelectedItem();
			selectSaleIndex = tableView.getSelectionModel().getSelectedIndex();
			System.out.println(selectSaleIndex);

		}); // end of tableView select

		btSearch.setOnAction(e -> handlerButtonSaleSearchAction(e));

		btSaleAdd.setOnAction(e -> handlerButtonSaleAddAction(e));

		btSaleDelete.setOnAction(e -> handlerButtonSaleDelete(e));

		btMenuCheck.setOnAction(e -> handlerButtonMenuCheck(e));

		datePicker.setOnAction(e -> handlerDatePicker(e));

	} // end of initialize

	private void handlerButtonSaleSearchAction(ActionEvent e) {
		try {
			String searchGoods = tfGoodsName.getText().trim();
			localDate = datePicker.getValue();
			String localDateStr = localDate.getYear() + "-" + localDate.getMonthValue() + "-"
					+ localDate.getDayOfMonth();

			ArrayList<SaleVO> list = new ArrayList<SaleVO>();

			saleDAO = new SaleDAO();
			list = saleDAO.searchGoodsVO(searchGoods, localDateStr);

			saleVOList = FXCollections.observableArrayList(list);
			tableView.setItems(saleVOList);

		} catch (Exception e1) {

			e1.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "오류", "오류입니다.", "다시 확인 해 주세요.");

		}
	}

	/*************************
	 * 기능 : datePicker의 날짜를 선택하면 선택한 날짜의 SaleVO를 가져와서 테이블뷰에 표시한다. 2019 10 월 18 일
	 * handlerDatePicker 메소드 작성자 : 심재현
	 * 
	 */
	private void handlerDatePicker(ActionEvent e) {
		try {
			localDate = datePicker.getValue();
			String localDateStr = localDate.getYear() + "-" + localDate.getMonthValue() + "-"
					+ localDate.getDayOfMonth();
			saleDAO = new SaleDAO();

			searchDateSaleVO = saleDAO.getListToDate(localDateStr);

			ObservableList<SaleVO> list = FXCollections.observableArrayList(searchDateSaleVO);

			tableView.setItems(list);

		} catch (Exception e1) {

			e1.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "오류", "오류입니다.", "다시 확인 해 주세요.");

		}
	} // end of handlerDatePicker

	/**************************
	 * 기능 : 등록 버튼을 누르면 등록 창을 연다. 2019 10월 18 일 handlerButtonSaleAddAction 메소드 작성자 :
	 * 심재현
	 * 
	 */
	private void handlerButtonSaleAddAction(ActionEvent e) {

		try {

			Parent saleAddRoot = FXMLLoader.load(getClass().getResource("/view/saleadd.fxml"));
			Stage saleAddStage = new Stage(StageStyle.UTILITY);
			saleAddStage.initModality(Modality.WINDOW_MODAL);
			saleAddStage.initOwner(btSaleAdd.getScene().getWindow());
			saleAddStage.setResizable(false);
			saleAddStage.setTitle("매출 등록");

			DatePicker dpSaleDate = (DatePicker) saleAddRoot.lookup("#dpSaleDate");
			ComboBox<String> cbGoodsList = (ComboBox<String>) saleAddRoot.lookup("#cbGoodsList");
			TextField tfSalePrice = (TextField) saleAddRoot.lookup("#tfSalePrice");
			TextField tfSaleCount = (TextField) saleAddRoot.lookup("#tfSaleCount");
			TextField tfSaleTotal = (TextField) saleAddRoot.lookup("#tfSaleTotal");
			TextField tfSaleComents = (TextField) saleAddRoot.lookup("#tfSaleComents");
			TableView<SaleVO> tableView = (TableView<SaleVO>) saleAddRoot.lookup("#tableView");
			Button btSaleAdd = (Button) saleAddRoot.lookup("#btSaleAdd");
			Button btSaleDelete = (Button) saleAddRoot.lookup("#btSaleDelete");
			Button btSaleBack = (Button) saleAddRoot.lookup("#btSaleBack");

			goodsDVO = new GoodsDAO();
			goodsList = goodsDVO.getGoodsTotal();

			ArrayList<String> saveGoodsName = new ArrayList<String>();

			for (int i = 0; i < goodsList.size(); i++) {

				saveGoodsName.add(goodsList.get(i).getGoods());

			}

			goodsNameList = FXCollections.observableArrayList(saveGoodsName);

			cbGoodsList.setItems(goodsNameList);

			/********************
			 * 2019 10 월 18일 cbGoodsList.setOnAction 이벤트 메소드 작성자 : 심재현
			 * 
			 * 기능 : comboBox의 값을 얻어서 해당 품목의 가격을 찾아 온다.
			 */
			cbGoodsList.setOnAction(e2 -> {

				saveGoodsString = cbGoodsList.getSelectionModel().getSelectedItem();

				for (int i = 0; i < goodsList.size(); i++) {

					if (goodsList.get(i).getGoods().equals(saveGoodsString)) {

						savePrice = goodsList.get(i).getPrice();
						tfSalePrice.setPromptText(String.valueOf(savePrice));
						break;

					}

				}

			}); // end of cbGoodsList

			/*********************
			 * 2019 10 월 18일 작성자 : 심재현
			 * 
			 * 기능 : 테이블 뷰 컬럼 생성 후 컬럼과 값 세팅
			 */
			tableView.setEditable(true);

			TableColumn columnDate = new TableColumn("날짜");
			columnDate.setMaxWidth(110);
			columnDate.setStyle("-fx-alignment: CENTER;");
			columnDate.setCellValueFactory(new PropertyValueFactory("date"));

			TableColumn columnGoods = new TableColumn("물품");
			columnGoods.setMaxWidth(110);
			columnGoods.setStyle("-fx-alignment: CENTER;");
			columnGoods.setCellValueFactory(new PropertyValueFactory("goods"));

			TableColumn columnPrice = new TableColumn("가격");
			columnPrice.setMaxWidth(110);
			columnPrice.setStyle("-fx-alignment: CENTER;");
			columnPrice.setCellValueFactory(new PropertyValueFactory("price"));

			TableColumn columnCount = new TableColumn("개수");
			columnCount.setMaxWidth(110);
			columnCount.setStyle("-fx-alignment: CENTER;");
			columnCount.setCellValueFactory(new PropertyValueFactory("count"));

			TableColumn columnTotal = new TableColumn("총액");
			columnTotal.setMaxWidth(110);
			columnTotal.setStyle("-fx-alignment: CENTER;");
			columnTotal.setCellValueFactory(new PropertyValueFactory("total"));

			TableColumn columnComents = new TableColumn("비고");
			columnComents.setMaxWidth(110);
			columnComents.setStyle("-fx-alignment: CENTER;");
			columnComents.setCellValueFactory(new PropertyValueFactory("coments"));

			tableView.setItems(saleVOList);

			tableView.getColumns().addAll(columnDate, columnGoods, columnPrice, columnCount, columnTotal,
					columnComents);

			/*************************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 비고 텍스트필드에서 키 이벤트 메소드를 걸어 놓
			 * 
			 */
			tfSaleComents.setOnKeyPressed(new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent ke) {

					KeyCode keyCode = ke.getCode();

					if (keyCode.equals(KeyCode.ENTER)) {

						int count = Integer.parseInt(tfSaleCount.getText().trim());
						int price = Integer.parseInt(tfSalePrice.getPromptText());
						saveTotalPrice = count * price;

						tfSaleTotal.setText(String.valueOf(saveTotalPrice));
						tfSaleTotal.setEditable(false);

						if ((!tfSaleTotal.equals(null)) && (!dpSaleDate.equals(null))) {

							saveSaleVO = new SaleVO(dpSaleDate.getValue().toString(), saveGoodsString,
									Integer.parseInt(tfSalePrice.getPromptText()),
									Integer.parseInt(tfSaleCount.getText().trim()), saveTotalPrice,
									tfSaleComents.getText());

							saleVOList.add(saveSaleVO);

							tableView.setItems(saleVOList);

						}
					}
				}

			}); // end of tfSaleCount key Event

			/*******************
			 * 2019 10 월 18일 작성자 : 심재현
			 * 
			 * 기능 : 등록 버튼을 누르면 테이블에 써있는 값들을 데이터베이스에 등록한다.
			 * 
			 */
			btSaleAdd.setOnAction(e2 -> {

				try {

					saleDAO = new SaleDAO();

					for (int i = 0; i < saleVOList.size(); i++) {

						saleDAO.insertSaleDB(saleVOList.get(i));

					}

					AlertMessage.alertWarningDisplay(1, "매출등록", "매출 등록 성공", "매출을 등록했습니다.");
					saleVOList.removeAll(saleVOList);
					tableView.setItems(selectSaleVOList);

				} catch (Exception e3) {
					AlertMessage.alertWarningDisplay(1, "매출등록", "매출 등록 실패", "매출 등록에 실패했습니다. 다시 시도해주세요.");
					e3.printStackTrace();
				}

			}); // end of btSaleAdd

			/***********************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 테이블 뷰를 클릭한 곳의 값을 저장한다. (인덱스 값은 포함하지 않았다.)
			 * 
			 */
			tableView.setOnMousePressed(e3 -> {

				selectSale = tableView.getSelectionModel().getSelectedItem();
				selectSaleVOList = tableView.getSelectionModel().getSelectedItems();

			}); // end of tableView select

			/***********************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 삭제 버튼을 누르면 항목이 삭제 된다. (테이블뷰에서 선택한 항목을 삭제함)
			 * 
			 */
			btSaleDelete.setOnAction(e2 -> {

				if (selectSaleVO.equals(null)) {

					AlertMessage.alertWarningDisplay(1, "삭제 실패", "삭제 실패", "삭제에 실패 했습니다. 다시 확인 해 주세요.");

				} else {

					try {

						saleDAO = new SaleDAO();

						AlertMessage.alertWarningDisplay(5, "삭제 주의", "삭제하시겠습니까?", "삭제하시겠습니까?");

						if (AlertMessage.alert.getResult() == ButtonType.OK) {
							addSaleVOList.addAll(saleVOList);
							saleVOList.remove(selectSale);
							tableView.setItems(saleVOList);

						}

					} catch (Exception e3) {

						AlertMessage.alertWarningDisplay(1, "오류", "오류입니다.", "다시 시도 해 주세요");
						e3.printStackTrace();

					}

				}

			}); // end of btSaleDelete

			/********************
			 * 2019 10 월 18일 작성자 : 심재현
			 * 
			 * 기능 : 버튼을 누르면 값을 초기화 하고 창을 닫는다.
			 * 
			 */
			btSaleBack.setOnAction(e2 -> {

				addSaleVOList.addAll(saleVOList);// 있어야하는지 기억안남...
				saleVOList.removeAll(saleVOList);

				saleAddStage.close();

			});

			Scene scene = new Scene(saleAddRoot);
			saleAddStage.setScene(scene);
			saleAddStage.show();

		} catch (Exception e2) {

			e2.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "오류", "오류입니다.", "다시 확인 해 주세요.");

		} // end of handlerButtonSaleAddAction

	} // end of handlerButtonSaleAddAction

	/************************************
	 * 기능 : 버튼을 누르면 항목을 지운다. 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */
	private void handlerButtonSaleDelete(ActionEvent e) {

		try {

			saleDAO = new SaleDAO();

			AlertMessage.alertWarningDisplay(5, "삭제 주의", "삭제하시겠습니까?", "삭제하시겠습니까?");
			// alert메세지의 버튼 값을 얻어와서 확인한다.
			if (AlertMessage.alert.getResult() == ButtonType.OK) {

				int i = saleDAO.deleteSale(selectSale);

				if (i == 1) {

					AlertMessage.alertWarningDisplay(1, "삭제 완료", "삭제 완료", "삭제 완료");

					// 삭제후 날짜 값은 선택했던 값 그대로를 유지 해야 하므로 현재의 값을 얻어와 다시 테이블뷰를 세팅한다.
					localDate = datePicker.getValue();
					String localDateStr = localDate.getYear() + "-" + localDate.getMonthValue() + "-"
							+ localDate.getDayOfMonth();

					saleDAO = new SaleDAO();
					searchDateSaleVO = saleDAO.getListToDate(localDateStr);
					saleVOList.removeAll(saleVOList);
					ObservableList<SaleVO> list2 = FXCollections.observableArrayList(searchDateSaleVO);
					tableView.setItems(list2);

				} else {

					AlertMessage.alertWarningDisplay(1, "삭제 오류", "삭제 오류", "삭제 오류");

				}

			}

		} catch (Exception e2) {

			AlertMessage.alertWarningDisplay(1, "오류", "오류입니다.", "다시 확인 해 주세요.");
			e2.printStackTrace();

		}

	} // end of handlerButtonSaleDelete

	/***************************
	 * 기능 : 버튼을 누르면 메뉴 확인 다이얼로그 창을 띄운다. 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */
	private void handlerButtonMenuCheck(ActionEvent e) {

		try {

			Parent menuCheckRoot = FXMLLoader.load(getClass().getResource("/view/menucheck.fxml"));
			Stage dialogStage = new Stage(StageStyle.UTILITY);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(btMenuCheck.getScene().getWindow());
			dialogStage.setTitle("수정");

			TableView<GoodsVO> tableView = (TableView<GoodsVO>) menuCheckRoot.lookup("#tableView");
			TextField tfGoods = (TextField) menuCheckRoot.lookup("#tfGoods");
			Button btSearch = (Button) menuCheckRoot.lookup("#btSearch");
			Button btMenuRefresh = (Button) menuCheckRoot.lookup("#btMenuRefresh");
			Button btAdd = (Button) menuCheckRoot.lookup("#btAdd");
			Button btEdit = (Button) menuCheckRoot.lookup("#btEdit");
			Button btEditDelete = (Button) menuCheckRoot.lookup("#btEditDelete");
			Button btBack = (Button) menuCheckRoot.lookup("#btBack");

			tableView.setEditable(false);

			TableColumn columnGoods = new TableColumn("물품");
			columnGoods.setMaxWidth(100);
			columnGoods.setStyle("-fx-alignment: CENTER;");
			columnGoods.setCellValueFactory(new PropertyValueFactory("goods"));

			TableColumn columnPrice = new TableColumn("가격");
			columnPrice.setMaxWidth(100);
			columnPrice.setStyle("-fx-alignment: CENTER;");
			columnPrice.setCellValueFactory(new PropertyValueFactory("price"));

			goodsVOList.removeAll(goodsVOList);
			loadTotalGoodsDB();

			tableView.setItems(goodsVOList);
			tableView.getColumns().addAll(columnGoods, columnPrice);

			/*******************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 검색버튼
			 * 
			 */
			btSearch.setOnAction(e1 -> {

				ObservableList<GoodsVO> list = FXCollections.observableArrayList();
				goodsDVO = new GoodsDAO();

				try {

					list = goodsDVO.getCheckGoods(tfGoods.getText());
					tableView.setItems(list);

				} catch (Exception e2) {

					AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "다시 시도 해 주세요.");
					e2.printStackTrace();

				}

			}); // end of btSearch

			/**********************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 테이블뷰 새로 고침 버튼
			 * 
			 */
			btMenuRefresh.setOnAction(e1 -> {

				goodsVOList.removeAll(goodsVOList);
				loadTotalGoodsDB();

				tableView.setItems(goodsVOList);

			});

			/******************************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 메뉴를 등록한다.
			 * 
			 */
			btAdd.setOnAction(e1 -> {

				try {

					Parent menuAddRoot = FXMLLoader.load(getClass().getResource("/view/menuadd.fxml"));
					Stage dialMenuAddStage = new Stage(StageStyle.UTILITY);
					dialMenuAddStage.initModality(Modality.WINDOW_MODAL);
					dialMenuAddStage.initOwner(btMenuCheck.getScene().getWindow());
					dialMenuAddStage.setTitle("메뉴 등록");

					TextField tfAddGoods = (TextField) menuAddRoot.lookup("#tfAddGoods");
					TextField tfAddPrice = (TextField) menuAddRoot.lookup("#tfAddPrice");
					Button btAddGoods = (Button) menuAddRoot.lookup("#btAddGoods");
					Button btAddCancle = (Button) menuAddRoot.lookup("#btAddCancle");

					btAddGoods.setOnAction(e3 -> {

						goodsDVO = new GoodsDAO();

						GoodsVO insertGoods = new GoodsVO(tfAddGoods.getText(), Integer.parseInt(tfAddPrice.getText()));

						goodsDVO.insertGoodsDB(insertGoods);

						AlertMessage.alertWarningDisplay(1, "메뉴 등록 성공", "메뉴 등록 성공", "메뉴를 등록했습니다.");

					});

					btAddCancle.setOnAction(e3 -> {

						dialMenuAddStage.close();

					});

					Scene scene = new Scene(menuAddRoot);
					dialMenuAddStage.setScene(scene);
					dialMenuAddStage.setResizable(false);
					dialMenuAddStage.show();

				} catch (Exception e2) {

					AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "다시 확인 해 주세요.");
					e2.printStackTrace();

				}

			}); // end of btAdd

			/**************************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 테이블뷰 선택 시 정보를 저장한다.
			 * 
			 */
			tableView.setOnMousePressed(e1 -> {

				selectMenuEditGoodsVO = tableView.getSelectionModel().getSelectedItem();
				selectMenuEditGoodsVOList = tableView.getSelectionModel().getSelectedItems();

			}); // end of tableView select

			/************************************
			 * 2019 10 월 18일 작성자 : 심재현
			 * 
			 * 기능 : 테이블 뷰에서 선택된 항목을 수정하는 창을 보여준다.
			 * 
			 */
			btEdit.setOnAction(e1 -> {

				try {

					Parent menuEditRoot = FXMLLoader.load(getClass().getResource("/view/menuedit.fxml"));
					Stage dialogEditStage = new Stage(StageStyle.UTILITY);
					dialogEditStage.initModality(Modality.WINDOW_MODAL);
					dialogEditStage.initOwner(btMenuCheck.getScene().getWindow());
					dialogEditStage.setTitle("메뉴 수정");

					TextField tfEditGoods = (TextField) menuEditRoot.lookup("#tfEditGoods");
					TextField tfEditPrice = (TextField) menuEditRoot.lookup("#tfEditPrice");
					Button btEditOk = (Button) menuEditRoot.lookup("#btEditOk");
					Button btEditBack = (Button) menuEditRoot.lookup("#btEditBack");

					editGoods = selectMenuEditGoodsVOList.get(0).getGoods();

					tfEditGoods.setPromptText(editGoods);
					tfEditGoods.setEditable(false);
					tfEditPrice.setPromptText(String.valueOf(selectMenuEditGoodsVOList.get(0).getPrice()));

					/********************************
					 * 2019 10 월 18 일 작성자 : 심재현
					 * 
					 * 기능 : 수정한 내용을 업데이트 한다.
					 * 
					 */
					btEditOk.setOnAction(e2 -> {
						try {
							goodsDVO = new GoodsDAO();

							if (tfEditGoods.getPromptText().equals(null)) {

								goodsDVO.updateGoods(selectMenuEditGoodsVO, tfEditGoods.getText(),
										Integer.parseInt(tfEditPrice.getText()));

							} else {

								goodsDVO.updateOnlyPrice(selectMenuEditGoodsVO,
										Integer.parseInt(tfEditPrice.getText()));

							}
						} catch (Exception e3) {
							e3.printStackTrace();
							AlertMessage.alertWarningDisplay(1, "오류", "수정 오류 입니다.", "다시 확인 해주세요.");
						}

					}); // end of btEditOk

					/********************************************
					 * 2019 10 월 18 일 작성자 : 심재현
					 * 
					 * 기능 : 수정 창을 닫는다.
					 * 
					 */
					btEditBack.setOnAction(e2 -> {
						try {
							goodsVOList.removeAll(goodsVOList);
							loadTotalGoodsDB();

							tableView.setItems(goodsVOList);

							dialogEditStage.close();
						} catch (Exception e3) {
							e3.printStackTrace();
							AlertMessage.alertWarningDisplay(1, "오류", "뒤로가기 오류 입니다.", "다시 확인 해 주세요.");
						}
					}); // end of btEditBack

					Scene scene = new Scene(menuEditRoot);
					dialogEditStage.setScene(scene);
					dialogEditStage.setResizable(false);
					dialogEditStage.show();

				} catch (Exception e3) {

					AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "다시 확인 해 주세요.");
					e3.printStackTrace();

				}

			}); // end of btEdit

			/***********************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 테이블 뷰에서 선택 된 항목을 테이블 뷰에서 삭제한다.
			 * 
			 */
			btEditDelete.setOnAction(e1 -> {

				try {

					goodsDVO = new GoodsDAO();

					AlertMessage.alertWarningDisplay(5, "삭제 주의", "삭제하시겠습니까?", "삭제하시겠습니까?");

					if (AlertMessage.alert.getResult() == ButtonType.OK) {

						int i = goodsDVO.deleteGoods(selectMenuEditGoodsVO.getGoods());
						System.out.println(selectMenuEditGoodsVO.getGoods());

						if (i == 1) {

							AlertMessage.alertWarningDisplay(1, "삭제 완료", "삭제 완료", "삭제 완료");

						} else {

							AlertMessage.alertWarningDisplay(1, "삭제 오류", "삭제 오류", "잘못 된 삭제입니다. 다시 확인 해 주세요.");

						}

					}

				} catch (Exception e2) {

					AlertMessage.alertWarningDisplay(1, "오류", "삭제 오류입니다.", "다시 확인 해 주세요.");
					e2.printStackTrace();

				}

			}); // end of btEditDelete
			/*****************
			 * 2019 10 월 18 일 작성자 : 심재현
			 * 
			 * 기능 : 메뉴 확인 창을 닫는다.
			 * 
			 */
			btBack.setOnAction(e1 -> {

				dialogStage.close();

			}); // end of btBack

			Scene scene = new Scene(menuCheckRoot);
			dialogStage.setScene(scene);
			dialogStage.setResizable(false);
			dialogStage.show();

		} catch (IOException e1) {

			e1.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "다시 확인 해 주세요.");
		}

	} // end of handlerButtonMenuCheck

	/************************************
	 * 기능 : 데이터 베이스에 저장된 goodsVO 정보를 모두 불러온다. 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */

	private void loadTotalGoodsDB() {

		ArrayList<GoodsVO> list = null;
		GoodsVO goodsVO = null;
		GoodsDAO goodsDVO = new GoodsDAO();
		list = goodsDVO.getGoodsTotal();

		if (list == null) {

			AlertMessage.alertWarningDisplay(1, "empty", "empty", "empty");
			return;

		}

		for (int i = 0; i < list.size(); i++) {

			goodsVO = list.get(i);
			goodsVOList.add(goodsVO);
			goodsList.add(goodsVO);

		}

	} // end of loadTotalGoodsDB

	/************************
	 * 기능 : 메인창의 테이블 뷰를 세팅한다. 2019 10 월 18 일 작성자 : 심재현
	 * 
	 */

	private void tableViewSetting() {

		tableView.setEditable(true);

		TableColumn columnDate = new TableColumn("날짜");
		columnDate.setMaxWidth(110);
		columnDate.setStyle("-fx-alignment: CENTER;");
		columnDate.setCellValueFactory(new PropertyValueFactory("date"));

		TableColumn columnGoods = new TableColumn("상품");
		columnGoods.setMaxWidth(70);
		columnGoods.setStyle("-fx-alignment: CENTER;");
		columnGoods.setCellValueFactory(new PropertyValueFactory("goods"));

		TableColumn columnPrice = new TableColumn("가격");
		columnPrice.setMaxWidth(80);
		columnPrice.setStyle("-fx-alignment: CENTER;");
		columnPrice.setCellValueFactory(new PropertyValueFactory("price"));

		TableColumn columnCount = new TableColumn("개수");
		columnCount.setMaxWidth(60);
		columnCount.setStyle("-fx-alignment: CENTER;");
		columnCount.setCellValueFactory(new PropertyValueFactory("count"));

		TableColumn columnTotal = new TableColumn("판매 금액");
		columnTotal.setMaxWidth(100);
		columnTotal.setStyle("-fx-alignment: CENTER;");
		columnTotal.setCellValueFactory(new PropertyValueFactory("total"));

		TableColumn columnComents = new TableColumn("비고");
		columnComents.setMaxWidth(200);
		columnComents.setStyle("-fx-alignment: CENTER;");
		columnComents.setCellValueFactory(new PropertyValueFactory("coments"));

		tableView.getColumns().addAll(columnDate, columnGoods, columnPrice, columnCount, columnTotal, columnComents);

	} // end of tableViewSetting

}
