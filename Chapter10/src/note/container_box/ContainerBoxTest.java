package note.container_box;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContainerBoxTest extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox rootVBox = new VBox();
		rootVBox.setPrefSize(400, 600);
		rootVBox.setSpacing(20);
		rootVBox.setAlignment(Pos.CENTER);
		
		TextField textField = new TextField();
		textField.setPrefWidth(200);
		
		Button button = new Button();
		button.setText("button");
		button.setOnAction((e) -> Platform.exit());
		
		ObservableList<Node> list = rootVBox.getChildren();
		list.add(textField);
		list.add(button);
		
		Scene scene = new Scene(rootVBox);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
	}

}
