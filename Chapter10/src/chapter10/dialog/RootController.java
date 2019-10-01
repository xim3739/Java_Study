package chapter10.dialog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable{
	
	private Stage primaryStage;
	private String str = "집에 가고 싶다.";
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void handlerOpenFileChooser(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("텍스트파일", "*.txt"),
				new ExtensionFilter("이미지파일", "*.jpg", "*.png", "*.jepg"),
				new ExtensionFilter("한글파일", "*.hangle"),
				new ExtensionFilter("모든파일", "*")
				
				);
		File file = fileChooser.showOpenDialog(AppMain.stage);
		
		if(file != null) {
			System.out.println(file.getPath());
		}
	}

	public void handlerSaveFileChooser(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("텍스트파일", "*.txt"),
				new ExtensionFilter("이미지파일", "*.jpg", "*.png", "*.jepg"),
				new ExtensionFilter("한글파일", "*.hangle"),
				new ExtensionFilter("모든파일", "*")
				);
		File file = fileChooser.showSaveDialog(primaryStage);
		
		if(file != null) {
			System.out.println(file.getPath());
		}
		
	}

	public void handlerDirectoryChooser(ActionEvent e) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File file = directoryChooser.showDialog(primaryStage);
		
		if(file != null) {
			System.out.println(file.getPath());
		}
	}

	public void handlerPopUpChooser(ActionEvent e) {
		Popup popup = new Popup();
		HBox hBox = null;
		try {
			hBox = FXMLLoader.load(getClass().getResource("popup.fxml"));
			ImageView imageView = (ImageView) hBox.lookup("#imageView");
			Label label = (Label) hBox.lookup("#label");
			label.setText(str);
			imageView.setOnMouseClicked((Event event) -> {
					popup.hide();
				
			});
			popup.getContent().add(hBox);
			popup.setAutoHide(true);
			popup.show(primaryStage);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void handlerCustomChooser(ActionEvent e) {
		Stage stage = null;
		AnchorPane anchorPane = null;
		try {
			stage = new Stage(StageStyle.UTILITY);
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(primaryStage);
			stage.setTitle("xim");
			stage.setResizable(false);
			
			anchorPane = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
			TextField textFieldEnglish = (TextField) anchorPane.lookup("#textFieldEnglish");
			TextField textFieldKorean = (TextField) anchorPane.lookup("#textFieldKorean");
			TextField textFieldMusic = (TextField) anchorPane.lookup("#textFieldMusic");
			Button buttonOk = (Button) anchorPane.lookup("#buttonOk");
			Button buttonDelete = (Button) anchorPane.lookup("#buttonDelete");
			
			buttonOk.setOnAction((e1) -> {
				int sum = Integer.parseInt(textFieldEnglish.getText()) +
				Integer.parseInt(textFieldKorean.getText()) +
				Integer.parseInt(textFieldMusic.getText());
				
				System.out.println("sum : " + sum);
			});
			
			buttonDelete.setOnAction((e2) -> {
				textFieldEnglish.setText("0");
				textFieldKorean.setText("0");
				textFieldMusic.setText("0");
			});
			Scene scene = new Scene(anchorPane);
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	
}
