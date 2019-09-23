package note.init_test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.stage.Stage;

public class InitTest extends Application{
	
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
		for(String value : list) {
			System.out.println(value);
		}
		
		Map<String, String> map = ps.getNamed();
		Set<Entry<String, String>> set = map.entrySet();
		
		for(Entry<String, String> entry : set) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key : " + key + " value : " + value);
		}
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + "Thread");
		primaryStage.setTitle("xim");
		primaryStage.show();
		
	}
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " Thread");
	}
}
