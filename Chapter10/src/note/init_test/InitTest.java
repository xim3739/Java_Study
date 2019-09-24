package note.init_test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InitTest extends Application {

	public InitTest() {
		
		System.out.println(Thread.currentThread().getName() + " Thread");
	}

	public static void main(String[] args) {
		
		System.out.println(Thread.currentThread().getName() + " Thread");
		
		launch(args);
	}

	@Override
	public void init() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " Thread");
		
		Parameters ps = getParameters();
		List<String> list = ps.getRaw();
		
		for (String value : list) {
			
			System.out.println(value);
		}

		Map<String, String> map = ps.getNamed();
		Set<Entry<String, String>> set = map.entrySet();

		for (Entry<String, String> entry : set) {
			
			String key = entry.getKey();
			String value = entry.getValue();

			System.out.println("key : " + key + " value : " + value);
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " Thread");
		
//		VBox rootVBox = new VBox();
//		rootVBox.setPrefSize(400, 600);
//		rootVBox.setSpacing(20);
//		rootVBox.setAlignment(Pos.CENTER);
//
//		TextField textField = new TextField();
//		textField.setPrefWidth(200);
//
//		Button button = new Button();
//		button.setText("button");
//		button.setOnAction((e) -> Platform.exit());
//
//		ObservableList<Node> list = rootVBox.getChildren();
//		list.add(textField);
//		list.add(button);
		
		Parent root = FXMLLoader.load(getClass().getResource("root.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		
		System.out.println(Thread.currentThread().getName() + " Thread");
	}
}
