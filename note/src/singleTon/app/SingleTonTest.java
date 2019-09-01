package singleTon.app;

public class SingleTonTest {

	public static void main(String[] args) {
		
		SingleTon singleTon = SingleTon.getSingleTon();
		
		singleTon.print();
		singleTon.setStr("제발 가자....");
		singleTon.print();
	}

}
