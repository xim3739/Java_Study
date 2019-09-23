package chapter10.javafx.main;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application{
	
	public AppMain() {
		System.out.println(Thread.currentThread().getName() + " 1 쓰레드 AppMain() 생성자");
		//클래스 쓰레드
	}
	//메인 클래스 생성자
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 2 쓰레드 main()");
		launch(args);
		//메인 함수의 쓰레드 표시, launch로 어플을 실행
	}
	
	@Override
	public void init() throws Exception {
		System.out.println(Thread.currentThread().getName() + " 3 스레드 init()");
		//init 함수 쓰레드 출력
		System.out.println("init() 콜");
		//함수 콜 출력
		Parameters ps  = getParameters();
		//파라미터를 얻는다.
		
		List<String> list = ps.getRaw();
		for(String value : list) {
			System.out.println(value);
		}
		//파라미터를 리스트로 저장후 출력
		
		Map<String, String> map = ps.getNamed();
		//파라미터를 맵으로 저장
		
		Set<Entry<String, String>> set = map.entrySet();
		//맵을 엔트리로 나눔
		
		for(Entry<String, String> entry : set) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			System.out.println("key : " + key + " value : " + value);
		}
		//포이치로 키와 밸류 표시
	}
	//init 함수 
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName() + " 4 스레드 start()");
		//start 함수의 쓰레드 표시
		primaryStage.setTitle("xim");
		//타이틀 설정
		System.out.println("start() 함수 생성");
		//함수 생성 출력
		primaryStage.show();
		//창 보여주기
	}
	//어플 시작 함수
	
	@Override
	public void stop() throws Exception {
		System.out.println(Thread.currentThread().getName() + " 5 스레드 stop()");
	}
	//어플 스탑 함수
}
