package chapter10.dialog.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	public static Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		Scene scene = new Scene(root);
		stage = primaryStage;
		primaryStage.setTitle("xim");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
