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
	private Button btTotalSearch;
	@FXML
	private Button btSaleAdd;
	@FXML
	private Button btSaleEdit;
	@FXML
	private Button btSaleDelete;
	@FXML
	private Button btMenuCheck;
	@FXML
	private DatePicker datePicker;
	@FXML
	private TableView<SaleVO> tableView;
	// @FXML private BarChart<X, Y> barChart;

	// saleVO veriable
	private ObservableList<SaleVO> saleVOList = FXCollections.observableArrayList();
	private ObservableList<SaleVO> selectSaleVOList = FXCollections.observableArrayList();
	private SaleVO selectSaleVO = null;
	private SaleDAO saleDAO = null;
	private SaleVO saveSaleVO = null;;
	private LocalDate localDate = null;
	private String saveGoodsString = null;
	private int savePrice = 0;
	private int saveTotalPrice = 0;

	// goodsVO veriable
	private ArrayList<GoodsVO> goodsList = new ArrayList<GoodsVO>();
	private ObservableList<GoodsVO> goodsVOList = FXCollections.observableArrayList();
	private ObservableList<String> goodsNameList = null;
	private GoodsDAO goodsDVO = null;;
	private String editGoods = null;;

	// goodsVO selected tableView
	private ObservableList<GoodsVO> selectMenuEditGoodsVOList = FXCollections.observableArrayList();
	private GoodsVO selectMenuEditGoodsVO = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadTotalSaleDB();

		loadTotalGoodsDB();

		btSaleAdd.setOnAction(e -> handlerButtonSaleAddAction(e));

		btSaleEdit.setOnAction(e -> handlerButtonSaleEditAction(e));

		btSaleDelete.setOnAction(e -> handlerButtonSaleDelete(e));

		btMenuCheck.setOnAction(e -> handlerButtonMenuCheck(e));

	} // end of initialize

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
							tableView.getColumns().addAll(columnDate, columnGoods, columnPrice, columnCount,
									columnTotal, columnComents);

						}
					}
				}

			}); // end of tfSaleCount

			btSaleAdd.setOnAction(e2 -> {

				try {

					saleDAO = new SaleDAO();

					System.out.println(saleVOList.toString());

					for (int i = 0; i < saleVOList.size(); i++) {

						saleDAO.insertSaleDB(saleVOList.get(i));

					}

					AlertMessage.alertWarningDisplay(1, "매출등록", "매출 등록 성공", "매출을 등록했습니다.");

				} catch (Exception e3) {
					AlertMessage.alertWarningDisplay(1, "매출등록", "매출 등록 실패", "매출 등록에 실패했습니다. 다시 시도해주세요.");
					e3.printStackTrace();
				}

			});

			tableView.setOnMousePressed(e3 -> {

				selectSaleVO = tableView.getSelectionModel().getSelectedItem();
				selectSaleVOList = tableView.getSelectionModel().getSelectedItems();

			}); // end of tableView select

			btSaleDelete.setOnAction(e2 -> {

				if (selectSaleVO.equals(null)) {

					AlertMessage.alertWarningDisplay(1, "삭제 실패", "삭제 실패", "삭제에 실패 했습니다. 다시 확인 해 주세요.");

				} else {

					try {

						saleDAO = new SaleDAO();

						AlertMessage.alertWarningDisplay(5, "삭제 주의", "삭제하시겠습니까?", "삭제하시겠습니까?");

						if (AlertMessage.alert.getResult() == ButtonType.OK) {

							int i = saleDAO.deleteSale(selectSaleVO);

							if (i == 1) {

								AlertMessage.alertWarningDisplay(1, "삭제 완료", "삭제 완료", "삭제 완료");

							} else {

								AlertMessage.alertWarningDisplay(1, "삭제 오류", "삭제 오류", "삭제 오류");

							}

						} else {

						}

					} catch (Exception e3) {

						e3.printStackTrace();

					}

				}

			}); // end of btSaleDelete
			
			btSaleBack.setOnAction(e2 -> {
				
				saleAddStage.close();
				
			});

			Scene scene = new Scene(saleAddRoot);
			saleAddStage.setScene(scene);
			saleAddStage.show();

		} catch (Exception e2) {

			e2.printStackTrace();

		} // end of handlerButtonSaleAddAction

	} // end of handlerButtonSaleAddAction

	private void handlerButtonSaleEditAction(ActionEvent e) {

	} // end of handlerButtonSaleEditAction

	private void handlerButtonSaleDelete(ActionEvent e) {

	} // end of handlerButtonSaleDelete

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

			btSearch.setOnAction(e1 -> {

				ObservableList<GoodsVO> list = FXCollections.observableArrayList();
				goodsDVO = new GoodsDAO();

				try {

					list = goodsDVO.getCheckGoods(tfGoods.getText());
					tableView.setItems(list);

				} catch (Exception e2) {

					e2.printStackTrace();

				}

			}); // end of btSearch

			btMenuRefresh.setOnAction(e1 -> {

				goodsVOList.removeAll(goodsVOList);
				loadTotalGoodsDB();

				tableView.setItems(goodsVOList);

			});

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
					e2.printStackTrace();
				}

			}); // end of btAdd

			tableView.setOnMousePressed(e1 -> {

				selectMenuEditGoodsVO = tableView.getSelectionModel().getSelectedItem();
				selectMenuEditGoodsVOList = tableView.getSelectionModel().getSelectedItems();

			}); // end of tableView select

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

					btEditOk.setOnAction(e2 -> {

						goodsDVO = new GoodsDAO();

						if (tfEditGoods.getPromptText().equals(null)) {

							goodsDVO.updateGoods(selectMenuEditGoodsVO, tfEditGoods.getText(),
									Integer.parseInt(tfEditPrice.getText()));

						} else {

							goodsDVO.updateOnlyPrice(selectMenuEditGoodsVO, Integer.parseInt(tfEditPrice.getText()));

						}

					}); // end of btEditOk

					btEditBack.setOnAction(e2 -> {

						goodsVOList.removeAll(goodsVOList);
						loadTotalGoodsDB();

						tableView.setItems(goodsVOList);

						dialogEditStage.close();

					}); // end of btEditBack

					Scene scene = new Scene(menuEditRoot);
					dialogEditStage.setScene(scene);
					dialogEditStage.setResizable(false);
					dialogEditStage.show();

				} catch (Exception e3) {
					// TODO: handle exception
				}

			}); // end of btEdit

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

							AlertMessage.alertWarningDisplay(1, "삭제 오류", "삭제 오류", "삭제 오류");

						}

					} else {

					}

				} catch (Exception e2) {

					e2.printStackTrace();

				}

			}); // end of btEditDelete

			btBack.setOnAction(e1 -> {

				dialogStage.close();

			}); // end of btBack

			Scene scene = new Scene(menuCheckRoot);
			dialogStage.setScene(scene);
			dialogStage.setResizable(false);
			dialogStage.show();

		} catch (IOException e1) {

			e1.printStackTrace();

		}

	} // end of handlerButtonMenuCheck

	// end of handler method

	private void loadTotalSaleDB() {

		ArrayList<SaleVO> list = null;
		SaleVO saleVO = null;
		SaleDAO saleDVO = new SaleDAO();
		list = saleDVO.getSaleTotal();

		if (list == null) {

			AlertMessage.alertWarningDisplay(1, "empty", "empty", "empty");
			return;

		}

		for (int i = 0; i < list.size(); i++) {

			saleVO = list.get(i);
			saleVOList.add(saleVO);

		}

	} // end of loadTotalSaleDB

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

		tableView.setItems(saleVOList);
		tableView.getColumns().addAll(columnDate, columnGoods, columnPrice, columnCount, columnTotal, columnComents);

	} // end of tableViewSetting

}
