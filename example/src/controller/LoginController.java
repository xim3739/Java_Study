package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.ClientDAO;
import model.ClientVO;
import util.AlertMessage;

public class LoginController implements Initializable {

	@FXML
	private TextField tfId;
	@FXML
	private TextField tfPassword;
	@FXML
	private Button btLogin;
	@FXML
	private Button btSignUp;
	@FXML
	private Button btCancle;

	private ClientDAO clientDVO;
	private ArrayList<ClientVO> clientList = new ArrayList<ClientVO>();
	private boolean flagCheck = true;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		initSetting();

		btLogin.setOnAction(e -> handlerButtonLoginAction(e));
		btCancle.setOnAction(e -> handlerButtonCancleAction(e));
		btSignUp.setOnAction(e -> handlerButtonSignUpAction(e));

	} // end of initialize

	private void handlerButtonLoginAction(ActionEvent e) {

		if (tfId.getText().equals("") || tfPassword.getText().equals("")) {

			AlertMessage.alertWarningDisplay(1, "Login Error", "try again Id or Password",
					"wrong input Id or Password");

		} else if ((tfId.getText().equals("admin") && tfPassword.getText().equals("1234"))
				|| (checkId(tfId.getText(), clientList) && checkPassword(tfPassword.getText(), clientList))) {
			
			flagCheck = true;
			
			Parent mainView = null;
			Stage mainStage = null;

			try {

				mainView = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
				Scene scene = new Scene(mainView);
				mainStage = new Stage();
				mainStage.setTitle("MAIN");
				mainStage.setScene(scene);
				mainStage.setResizable(false);

				((Stage) btLogin.getScene().getWindow()).close();

				mainStage.show();
				
			} catch (Exception e1) {
				e1.printStackTrace();
				AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "메인 화면을 불러오는 도중 에러가 발생했습니다.");
				
				flagCheck = true;
				
			}

		} else {

			AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "맞지 않는 아이디, 또는 비밀번호를 입력하였습니다.");
			
			flagCheck = true;

		}

	} // end of handlerButtonLoginAction

	private void handlerButtonCancleAction(ActionEvent e) {

		Platform.exit();

	} // end of handlerButtonCancleAction

	private void handlerButtonSignUpAction(ActionEvent e) {

		try {

			Parent signUpRoot = FXMLLoader.load(getClass().getResource("/view/signup.fxml"));
			Stage dialogStage = new Stage(StageStyle.UTILITY);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(btSignUp.getScene().getWindow());
			dialogStage.setTitle("수정");

			TextField tfDialogId = (TextField) signUpRoot.lookup("#tfDialogId");
			PasswordField tfDialogPassword = (PasswordField) signUpRoot.lookup("#tfDialogPassword");
			TextField tfDialogName = (TextField) signUpRoot.lookup("#tfDialogName");
			TextField tfDialogPhone = (TextField) signUpRoot.lookup("#tfDialogPhone");
			Button btDialogOk = (Button) signUpRoot.lookup("#btDialogOk");
			Button btDialogCancle = (Button) signUpRoot.lookup("#btDialogCancle");

			btDialogOk.setOnAction(e1 -> {

				try {

					if (tfDialogId.getText().equals("") || tfDialogPassword.getText().equals("")
							|| tfDialogName.getText().equals("") || tfDialogPhone.getText().equals("")) {
						throw new Exception();

					} else {

						ClientVO cvo = new ClientVO(tfDialogId.getText().trim(), tfDialogPassword.getText().trim(),
								tfDialogName.getText().trim(), tfDialogPhone.getText().trim());

						clientDVO = new ClientDAO();

						clientList = clientDVO.getClientCheck(cvo);

						if (duplicateCheckId(cvo.getId(), clientList) || clientList == null) {

							flagCheck = true;
								
							clientDVO.insertClientDB(cvo);

							AlertMessage.alertWarningDisplay(1, "회원 가입 성공", "회원 가입 성공", "회원 가입에 성공하였습니다.");
							dialogStage.close();

						} else {

							AlertMessage.alertWarningDisplay(1, "아이디 중복", "아이디 중복 입니다.", "이미 사용중인 아이디 입니다.");
							flagCheck = true;

						}

					}

				} catch (Exception e2) {
					
					e2.printStackTrace();
					AlertMessage.alertWarningDisplay(1, "오류", "오류 입니다.", "다시 확인 해 주세요.");
					
					flagCheck = true;

				}

			});

			btDialogCancle.setOnAction(e2 -> {

				dialogStage.close();

			});

			Scene scene = new Scene(signUpRoot);
			dialogStage.setScene(scene);
			dialogStage.setResizable(false);
			dialogStage.show();

		} catch (Exception e1) {
			
			e1.printStackTrace();
			AlertMessage.alertWarningDisplay(1, "에러", "에러 입니다.", "화면을 불러오는 도중 에러가 발생했습니다.");
			
		}

	} // end of handlerButtonSignUpAction

	// end of handler Method

	private void initSetting() {

		clientDVO = new ClientDAO();

		clientList = clientDVO.getClientInfo();

	} // end of initSetting

	public boolean duplicateCheckId(String id, ArrayList<ClientVO> cvoList) {

		if (cvoList.equals(null)) {

			return true;

		}

		for (int i = 0; i < cvoList.size(); i++) {

			if (cvoList.get(i).getId().equals(id)) {

				flagCheck = false;
				break;

			} else {

				flagCheck = true;

			}

		}

		return flagCheck;

	} // end of duplicateCheckId

	public boolean checkPassword(String password, ArrayList<ClientVO> cvoList) {

		if (cvoList.equals(null)) {

			return false;

		}

		for (int i = 0; i < cvoList.size(); i++) {

			if (cvoList.get(i).getPassword().equals(password)) {

				flagCheck = true;
				break;
				
			} else {

				flagCheck = false;

			}

		}

		return flagCheck;

	} // end of checkPassword
	
	public boolean checkId(String id, ArrayList<ClientVO> cvoList) {
		
		if (cvoList.equals(null)) {

			return false;

		}

		for (int i = 0; i < cvoList.size(); i++) {

			if (cvoList.get(i).getId().equals(id)) {

				flagCheck = true;
				break;
				
			} else {

				flagCheck = false;

			}

		}

		return flagCheck;
		
	}

}
