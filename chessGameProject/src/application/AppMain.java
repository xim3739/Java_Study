package application;

import chess.Pawn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {
	
	public static void main(String[] args) {
		Pawn pawn = new Pawn();
		System.out.println(pawn.toString());
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/view/chessbord.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("GAME");
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
