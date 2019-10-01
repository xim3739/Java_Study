package chapter10.dialog.test;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void handlerMyCustomChooser(ActionEvent e) {
		Stage stage = new Stage(StageStyle.UTILITY);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(AppMain.stage);
		stage.setTitle("score");
		stage.setResizable(false);
		AnchorPane anchorPane = null;
		try {
			anchorPane = FXMLLoader.load(getClass().getResource("custom.fxml"));
			TextField textFieldKorean = (TextField) anchorPane.lookup("#textFieldKorean");
			TextField textFieldEnglish = (TextField) anchorPane.lookup("#textFieldEnglish");
			TextField textFieldMusic = (TextField) anchorPane.lookup("#textFieldMusic");
			
			Label labelTotalScore = (Label) anchorPane.lookup("#labelTotalScore");
			Label labelAvg = (Label) anchorPane.lookup("#labelAvg");
			
			Button buttonTotalScore = (Button) anchorPane.lookup("#buttonTotalScore");
			Button buttonAvg = (Button) anchorPane.lookup("#buttonAvg");
			Button buttonCancle = (Button) anchorPane.lookup("#buttonCancle");
			Button buttonExit = (Button) anchorPane.lookup("#buttonExit");
			
			buttonTotalScore.setOnAction((e1) -> {
				int sum = Integer.parseInt(textFieldEnglish.getText()) + Integer.parseInt(textFieldKorean.getText()) + Integer.parseInt(textFieldMusic.getText());
				labelTotalScore.setText(String.valueOf(sum));
			});
			buttonAvg.setOnAction((e2) -> {
				int sum = Integer.parseInt(textFieldEnglish.getText()) + Integer.parseInt(textFieldKorean.getText()) + Integer.parseInt(textFieldMusic.getText());
				double avg = (double)sum / 3.0;
				labelAvg.setText(String.valueOf(avg));
			});
			buttonCancle.setOnAction((e3) -> {
				labelAvg.setText("0");
				labelTotalScore.setText("0");
				textFieldEnglish.setText("0");
				textFieldKorean.setText("0");
				textFieldMusic.setText("0");
			});
			buttonExit.setOnAction((e4) -> {
				stage.close();
			});
			Scene scene = new Scene(anchorPane);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
