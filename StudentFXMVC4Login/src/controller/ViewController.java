package controller;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Student;

public class ViewController implements Initializable {

	@FXML
	private TextField txtName;
	@FXML
	private ComboBox<String> cbYear;
	@FXML
	private TextField txtBan;
	@FXML
	private TextField txtKo;
	@FXML
	private TextField txtEng;
	@FXML
	private TextField txtMath;
	@FXML
	private TextField txtSic;
	@FXML
	private TextField txtSoc;
	@FXML
	private TextField txtMusic;
	@FXML
	private TextField txtTotal;
	@FXML
	private TextField txtAvg;
	@FXML
	private TextField txtSearch;
	@FXML
	private Button btnTotal;
	@FXML
	private Button btnAvg;
	@FXML
	private Button btnInit;
	@FXML
	private Button btnOk;
	@FXML
	private Button btnExit;
	@FXML
	private Button btnSearch;
	@FXML
	private Button btnDelete;
	@FXML
	private Button btnEdit;
	@FXML
	private ToggleGroup genderGroup;
	@FXML
	private RadioButton rbMale;
	@FXML
	private RadioButton rbFemale;
	@FXML
	private TableView<Student> tableView;

	ObservableList<Student> studentData;

	private ObservableList<Student> selectStudent;
	private int selectStudentIndex;

	private boolean editDelete = false;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		buttonInitSetting(false, true, false, true, false, true, true);
		// button init Setting

		cbYear.setItems(FXCollections.observableArrayList("1", "2", "3", "4", "5", "6"));
		// comboBox init setting

		tableViewSetting();
		// tableView Setting

		btnTotal.setOnAction(e -> handlerButtonTotalAction(e));

		btnAvg.setOnAction(e1 -> handlerButtonAvgAction(e1));

		btnInit.setOnAction(e2 -> handlerButtonInitAction(e2));

		btnOk.setOnAction(e3 -> handlerButtonOkAction(e3));

		btnSearch.setOnAction(e4 -> handlerButtonSearchAction(e4));

		btnDelete.setOnAction(e5 -> handlerButtonDeleteAction(e5));

		btnEdit.setOnAction(e6 -> handlerButtonEditAction(e6));

		btnExit.setOnAction(e7 -> Platform.exit());

		tableView.setOnMousePressed(e6 -> handlerTableViewSelectEvent(e6));
		
		tableView.setOnMouseClicked(e7 -> handlerPieChartAction(e7));
		
		// button actions

	}// end of initialize

	private void buttonInitSetting(boolean total, boolean avg, boolean init, boolean ok, boolean exit, boolean edit,
			boolean delete) {

		btnTotal.setDisable(total);
		btnAvg.setDisable(avg);
		btnInit.setDisable(init);
		btnOk.setDisable(ok);
		btnExit.setDisable(exit);
		btnEdit.setDisable(edit);
		btnDelete.setDisable(delete);

	}// end of buttonInitSetting

	private void tableViewSetting() {

		studentData = FXCollections.observableArrayList();

		tableView.setEditable(false); // tableView 수정 x

		DecimalFormat format = new DecimalFormat("###");
		// 점수 입력시 길이 제한 이벤트 처리
		txtKo.setTextFormatter(new TextFormatter<>(event -> {

			if (event.getControlNewText().isEmpty()) {
				return event;
			}

			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {

				return null;

			} else {

				return event;

			}
		}));

		txtEng.setTextFormatter(new TextFormatter<>(event -> {
			if (event.getControlNewText().isEmpty()) {
				return event;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);
			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {
				return null;
			} else {
				return event;

			}
		}));

		txtMath.setTextFormatter(new TextFormatter<>(event -> {
			if (event.getControlNewText().isEmpty()) {
				return event;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);
			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {
				return null;
			} else {
				return event;
			}
		}));

		txtSic.setTextFormatter(new TextFormatter<>(event -> {
			if (event.getControlNewText().isEmpty()) {
				return event;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);
			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {
				return null;
			} else {
				return event;
			}
		}));

		txtSoc.setTextFormatter(new TextFormatter<>(event -> {
			if (event.getControlNewText().isEmpty()) {
				return event;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);

			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {
				return null;
			} else {
				return event;
			}
		}));

		txtMusic.setTextFormatter(new TextFormatter<>(event -> {
			if (event.getControlNewText().isEmpty()) {
				return event;
			}
			ParsePosition parsePosition = new ParsePosition(0);
			Object object = format.parse(event.getControlNewText(), parsePosition);
			if (object == null || parsePosition.getIndex() < event.getControlNewText().length()
					|| event.getControlNewText().length() == 4) {
				return null;
			} else {
				return event;
			}
		}));

		TableColumn columnName = new TableColumn("Name");
		columnName.setMaxWidth(50);
		columnName.setStyle("-fx-alignment: CENTER;");
		columnName.setCellValueFactory(new PropertyValueFactory("name"));

		TableColumn columnGender = new TableColumn("Gender");
		columnGender.setMaxWidth(50);
		columnGender.setStyle("-fx-alignment: CENTER;");
		columnGender.setCellValueFactory(new PropertyValueFactory("gender"));

		TableColumn columnGrade = new TableColumn("Level");
		columnGrade.setMaxWidth(50);
		columnGrade.setStyle("-fx-alignment: CENTER;");
		columnGrade.setCellValueFactory(new PropertyValueFactory("level"));

		TableColumn columnBan = new TableColumn("Ban");
		columnBan.setMaxWidth(50);
		columnBan.setStyle("-fx-alignment: CENTER;");
		columnBan.setCellValueFactory(new PropertyValueFactory("ban"));

		TableColumn columnKorean = new TableColumn("Korean");
		columnKorean.setMaxWidth(50);
		columnKorean.setStyle("-fx-alignment: CENTER;");
		columnKorean.setCellValueFactory(new PropertyValueFactory("korean"));

		TableColumn columnEnglish = new TableColumn("English");
		columnEnglish.setMaxWidth(50);
		columnEnglish.setStyle("-fx-alignment: CENTER;");
		columnEnglish.setCellValueFactory(new PropertyValueFactory("english"));

		TableColumn columnMath = new TableColumn("Math");
		columnMath.setMaxWidth(50);
		columnMath.setStyle("-fx-alignment: CENTER;");
		columnMath.setCellValueFactory(new PropertyValueFactory("math"));

		TableColumn columnScience = new TableColumn("Science");
		columnScience.setMaxWidth(50);
		columnScience.setStyle("-fx-alignment: CENTER;");
		columnScience.setCellValueFactory(new PropertyValueFactory("science"));

		TableColumn columnSocity = new TableColumn("Socity");
		columnSocity.setMaxWidth(50);
		columnSocity.setStyle("-fx-alignment: CENTER;");
		columnSocity.setCellValueFactory(new PropertyValueFactory("socity"));

		TableColumn columnMusic = new TableColumn("Music");
		columnMusic.setMaxWidth(50);
		columnMusic.setStyle("-fx-alignment: CENTER;");
		columnMusic.setCellValueFactory(new PropertyValueFactory("music"));

		TableColumn columnTotal = new TableColumn("Total");
		columnTotal.setMaxWidth(50);
		columnTotal.setStyle("-fx-alignment: CENTER;");
		columnTotal.setCellValueFactory(new PropertyValueFactory("total"));

		TableColumn columnAvg = new TableColumn("Avg");
		columnAvg.setMaxWidth(50);
		columnAvg.setStyle("-fx-alignment: CENTER;");
		columnAvg.setCellValueFactory(new PropertyValueFactory("avg"));

		tableView.setItems(studentData);
		tableView.getColumns().addAll(columnName, columnGender, columnGrade, columnBan, columnKorean, columnEnglish,
				columnMath, columnScience, columnSocity, columnMusic, columnTotal, columnAvg);

	}// end of tableViewSetting

	private void handlerButtonTotalAction(ActionEvent e) {

		try {

			if ((Integer.parseInt(txtKo.getText()) <= 100) && (Integer.parseInt(txtEng.getText()) <= 100)
					&& (Integer.parseInt(txtMath.getText()) <= 100) && (Integer.parseInt(txtSic.getText()) <= 100)
					&& (Integer.parseInt(txtSoc.getText()) <= 100) && (Integer.parseInt(txtMusic.getText()) <= 100)) {

				int sum = Integer.parseInt(txtKo.getText()) + Integer.parseInt(txtEng.getText())
						+ Integer.parseInt(txtMath.getText()) + Integer.parseInt(txtSic.getText())
						+ Integer.parseInt(txtSoc.getText()) + Integer.parseInt(txtMusic.getText());

				txtTotal.setText(String.valueOf(sum));

				btnAvg.setDisable(false);

			} else {

				throw new Exception("점수가 유효하지 않습니다.");

			}

		} catch (Exception e2) {

			alertWarningDisplay(1, "합계 실패", "계산 오류", e2.toString());

		}
	}

	private void handlerButtonAvgAction(ActionEvent e1) {

		txtAvg.setText(String.valueOf((Integer.parseInt(txtTotal.getText())) / 6.0));

		buttonInitSetting(true, true, false, false, false, true, true);

		textFieldInitSetting(true, true, true, true, true, true, true, true, true, true, true, true, true);

	}// end of handlerButtonAvgAction

	private void handlerButtonInitAction(ActionEvent e2) {

		buttonInitSetting(false, true, false, true, false, true, true);
		textFieldInitSetting(false, false, false, false, false, false, false, false, false, false, false, true, true);
		textFieldValueInitSetting();

	}// end of handlerButtonInitAction

	private void handlerButtonOkAction(ActionEvent e3) {

		try {

			if (txtTotal.getText().equals("") || txtAvg.getText().equals("")) {

				throw new Exception();

			} else {

				Student student = new Student(txtName.getText(),
						(genderGroup.getSelectedToggle().getUserData()).toString(),
						cbYear.getSelectionModel().getSelectedItem(), txtBan.getText(), txtKo.getText(),
						txtEng.getText(), txtMath.getText(), txtSic.getText(), txtSoc.getText(), txtMusic.getText(),
						txtTotal.getText(), txtAvg.getText());

				if (editDelete == true) {
					studentData.remove(selectStudentIndex);
					studentData.add(selectStudentIndex, student);
					editDelete = false;

				} else {

					studentData.add(student);

				} // end of if & else

				buttonInitSetting(false, true, false, true, false, true, true);

				alertWarningDisplay(1, "등록 성공", "테이블 등록 성공", "테이블에 등록 하였습니다.");

			} // end of if & else

		} catch (Exception e) {

			e.printStackTrace();
			// alertWarningDisplay(1, "등록 실패", "합계나 평균을 확인 바랍니다.", e.toString());
		} // end of try & catch

		handlerButtonInitAction(e3);

	}// end of handlerButtonOkAction

	private void handlerButtonSearchAction(ActionEvent e4) {

		for (Student studnet : studentData) {
			if (txtSearch.getText().equals(studnet.getName())) {
				tableView.getSelectionModel().select(studnet);
				return;
			}
		}

		alertWarningDisplay(1, "검색 결과", "정확한 이름을 입력해주세요.", "데이터를 찾을 수 없습니다.");
	}// end of handlerButtonSearchAction

	private void handlerTableViewSelectEvent(MouseEvent e6) {
		
		try {
		editDelete = true;
		buttonInitSetting(true, true, true, true, false, false, false);

		selectStudentIndex = tableView.getSelectionModel().getSelectedIndex();
		selectStudent = tableView.getSelectionModel().getSelectedItems();

		txtName.setText(selectStudent.get(0).getName());

		if (selectStudent.get(0).getGender().equals("남성")) {

			rbMale.setSelected(true);
			rbFemale.setSelected(false);

		} else {

			rbMale.setSelected(false);
			rbFemale.setSelected(true);

		} // end of if & else

		cbYear.setValue(selectStudent.get(0).getLevel());
		txtBan.setText(selectStudent.get(0).getBan());
		txtKo.setText(selectStudent.get(0).getKorean());
		txtEng.setText(selectStudent.get(0).getEnglish());
		txtMath.setText(selectStudent.get(0).getMath());
		txtSic.setText(selectStudent.get(0).getScience());
		txtSoc.setText(selectStudent.get(0).getSocity());
		txtMusic.setText(selectStudent.get(0).getMusic());
		txtTotal.setText(selectStudent.get(0).getTotal());
		txtAvg.setText(selectStudent.get(0).getAvg());

		textFieldInitSetting(true, true, true, true, true, true, true, true, true, true, true, true, true);
		
		} catch(Exception e2) {
			
			buttonInitSetting(false, true, false, true, false, true, true);
			editDelete = false;
			
		}// end of try catch
		
	}// end of handlerTableViewSelectEvent

	private void handlerButtonDeleteAction(ActionEvent e5) {

		studentData.remove(selectStudentIndex);

		buttonInitSetting(false, true, false, true, false, true, true);

		textFieldInitSetting(false, false, false, false, false, false, false, false, false, false, false, true, true);

		txtName.setText("");
		cbYear.setValue("");
		txtBan.setText("");
		rbMale.setSelected(false);
		rbFemale.setSelected(false);
		txtKo.setText("");
		txtEng.setText("");
		txtMath.setText("");
		txtSic.setText("");
		txtSoc.setText("");
		txtMusic.setText("");
		txtTotal.setText("");
		txtAvg.setText("");

	}// end ofhandlerButtonDeleteAction

	private void handlerButtonEditAction(ActionEvent e6) {

//		Parent formEditDialog = null;
//		Stage dialogStage = null;
//		Scene scene = null;

		try {

			buttonInitSetting(false, true, false, true, false, true, true);
			textFieldInitSetting(false, false, false, false, false, false, false, false, false, false, false, true,
					true);

			Parent formEditDialog = FXMLLoader.load(getClass().getResource("/view/formedit.fxml"));
			Stage dialogStage = new Stage(StageStyle.UTILITY);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(btnOk.getScene().getWindow());
			dialogStage.setTitle("수정");

			TextField editName = (TextField) formEditDialog.lookup("#txtName");
			TextField editYear = (TextField) formEditDialog.lookup("#txtYear");
			TextField editBan = (TextField) formEditDialog.lookup("#txtBan");
			TextField editGender = (TextField) formEditDialog.lookup("#txtGender");
			TextField editKorean = (TextField) formEditDialog.lookup("#txtKorean");
			TextField editEnglish = (TextField) formEditDialog.lookup("#txtEnglish");
			TextField editMath = (TextField) formEditDialog.lookup("#txtMath");
			TextField editSic = (TextField) formEditDialog.lookup("#txtSic");
			TextField editSoc = (TextField) formEditDialog.lookup("#txtSoc");
			TextField editMusic = (TextField) formEditDialog.lookup("#txtMusic");
			TextField editTotal = (TextField) formEditDialog.lookup("#txtTotal");
			TextField editAvg = (TextField) formEditDialog.lookup("#txtAvg");

			editTotal.setDisable(true);
			editAvg.setDisable(true);

			editName.setText(selectStudent.get(0).getName());
			editYear.setText(selectStudent.get(0).getLevel());
			editBan.setText(selectStudent.get(0).getBan());
			editGender.setText(selectStudent.get(0).getGender());
			editKorean.setText(selectStudent.get(0).getKorean());
			editEnglish.setText(selectStudent.get(0).getEnglish());
			editMath.setText(selectStudent.get(0).getMath());
			editSic.setText(selectStudent.get(0).getScience());
			editSoc.setText(selectStudent.get(0).getSocity());
			editMusic.setText(selectStudent.get(0).getMusic());
			editTotal.setText(selectStudent.get(0).getTotal());
			editAvg.setText(selectStudent.get(0).getAvg());
			
			Button btnCal = (Button) formEditDialog.lookup("#btnCal");
			Button btnFormAdd = (Button) formEditDialog.lookup("#btnFormAdd");
			Button btnFormCancel = (Button) formEditDialog.lookup("#btnFormCancel");
			
			btnCal.setOnAction(e1 -> {
				
				int koreanScore = Integer.parseInt(editKorean.getText());
				int englishScore = Integer.parseInt(editEnglish.getText());
				int mathScore = Integer.parseInt(editMath.getText());
				int sicScore = Integer.parseInt(editSic.getText());
				int socScore = Integer.parseInt(editSoc.getText());
				int musicScore = Integer.parseInt(editMusic.getText());
				
				int sum = koreanScore + englishScore +
						mathScore + sicScore +
						socScore + musicScore;
				
				editTotal.setText(String.valueOf(sum));
				editAvg.setText(String.valueOf(sum / 6.0));
				
			});
			
			btnFormAdd.setOnAction(e2 -> {
				
				try {

					if (editTotal.getText().equals("") || editAvg.getText().equals("")) {

						throw new Exception();

					} else {

						Student student = new Student(editName.getText(),
								editGender.getText(),editYear.getText(), 
								editBan.getText(), editKorean.getText(),
								editEnglish.getText(), editMath.getText(),
								editSic.getText(),editSoc.getText(), 
								editMusic.getText(),editTotal.getText(), 
								editAvg.getText());

						if (editDelete == true) {
							studentData.remove(selectStudentIndex);
							studentData.add(selectStudentIndex, student);
							editDelete = false;

						} else {
							throw new Exception("수정 등록 오류");
						} // end of if & else

						buttonInitSetting(false, true, false, true, false, true, true);

					} // end of if & else

				} catch (Exception e3) {

					e3.printStackTrace();
					// alertWarningDisplay(1, "등록 실패", "합계나 평균을 확인 바랍니다.", e.toString());
				} // end of try & catch
			});
			
			btnFormCancel.setOnAction(e4-> {
				
				dialogStage.close();
				
			});
			
			

			Scene scene = new Scene(formEditDialog);
			dialogStage.setScene(scene);
			dialogStage.setResizable(false);
			dialogStage.show();

		} catch (IOException e) {

			e.printStackTrace();

		} // end of try & catch

	}// end of handlerButtonEditAction
	
	private void handlerPieChartAction(MouseEvent e7) {
		
		try {
			
			if(e7.getClickCount() != 2) {
				return;
			}
			
			Parent pieChart = FXMLLoader.load(getClass().getResource("/view/piechart.fxml"));
			Stage stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(btnOk.getScene().getWindow());
			stage.setTitle(selectStudent.get(0).getName() + "총점과 평균");
			
			PieChart chart = (PieChart) pieChart.lookup("#pieChart");
			Button btnClose = (Button) pieChart.lookup("#btnClose");
			
			chart.setData(FXCollections.observableArrayList(
					new PieChart.Data("총점", Double.parseDouble(selectStudent.get(0).getTotal())), 
					new PieChart.Data("평균", Double.parseDouble(selectStudent.get(0).getAvg()))
					));
			
			btnClose.setOnAction(e -> {
				
				buttonInitSetting(false, true, false, true, false, true, true);
				
				textFieldInitSetting(false, false, false, false, false, false, false, false, false, false, false, true, true);

				txtName.setText("");
				cbYear.setValue("");
				txtBan.setText("");
				rbMale.setSelected(false);
				rbFemale.setSelected(false);
				txtKo.setText("");
				txtEng.setText("");
				txtMath.setText("");
				txtSic.setText("");
				txtSoc.setText("");
				txtMusic.setText("");
				txtTotal.setText("");
				txtAvg.setText("");
				
				editDelete = false;
				
				stage.close();
				
			});
			
			Scene scene = new Scene(pieChart);
			stage.setScene(scene);
			stage.show();
			
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}// end of handlerPieChartAction
	
	// end of Action method

	// handler Method

	private void textFieldValueInitSetting() {

		txtName.clear();
		cbYear.setValue("");
		txtBan.clear();
		txtKo.clear();
		txtEng.clear();
		txtMath.clear();
		txtSic.clear();
		txtSoc.clear();
		txtMusic.clear();
		txtTotal.clear();
		txtAvg.clear();

	}// end of textFieldValueInitSetting
	

	public void alertWarningDisplay(int type, String title, String headerText, String contentText) {

		Alert alert = null;

		switch (type) {

		case 1:
			alert = new Alert(AlertType.WARNING);
			break;
		case 2:
			alert = new Alert(AlertType.ERROR);
			break;
		case 3:
			alert = new Alert(AlertType.INFORMATION);
			break;
		case 4:
			alert = new Alert(AlertType.NONE);
			break;
		case 5:
			alert = new Alert(AlertType.CONFIRMATION);
			break;
		default:
			break;

		}

		alert.setTitle(title);
		alert.setHeaderText(headerText);
		alert.setContentText(headerText + "\n" + contentText);
		alert.setResizable(false);
		alert.showAndWait();

	}// end of alertWarningDisplay

	private void textFieldInitSetting(boolean b, boolean c, boolean d, boolean e, boolean f, boolean g, boolean h,
			boolean i, boolean j, boolean k, boolean l, boolean n, boolean m) {

		txtName.setDisable(b);
		cbYear.setDisable(c);
		txtBan.setDisable(d);
		txtKo.setDisable(e);
		txtEng.setDisable(f);
		txtMath.setDisable(g);
		txtSic.setDisable(h);
		txtSoc.setDisable(i);
		txtMusic.setDisable(j);
		rbMale.setDisable(k);
		rbFemale.setDisable(l);
		txtTotal.setDisable(n);
		txtAvg.setDisable(m);

	}// end of textFieldInitSetting

	public void handlerBtnAvgActoion(ActionEvent event) {

	}// end of handlerBtnAvgAction

	// end of args Method
}
