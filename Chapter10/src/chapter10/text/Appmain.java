package chapter10.text;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Appmain extends Application{

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = new FXMLLoader().load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("Hi");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
