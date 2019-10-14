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
			//씬
			Scene s = new Scene(r);
			
			//스테이지
			primaryStage.setTitle("로그인");
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
