package chapter10.dialog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	public static Stage stage;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("root.fxml"));
		Parent hBox = fxmlLoader.load();
		RootController rootController = fxmlLoader.getController();
		rootController.setPrimaryStage(primaryStage);
		stage = primaryStage;
		Scene scene = new Scene(hBox);
		primaryStage.setTitle("xims");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();

	}

}
