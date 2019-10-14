package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.stage.Stage;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent r = FXMLLoader.load(getClass().getResource("/view/login.fxml"));
			//��
			Scene s = new Scene(r);
			
			//��������
			primaryStage.setTitle("�α���");
			primaryStage.setScene(s);
			primaryStage.show();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}