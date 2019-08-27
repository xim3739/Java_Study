package singleTon;

public class SingleTonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleTon singleTon = SingleTon.getSingleTon();
		
		singleTon.print();
		singleTon.setStr("제발 가자....");
		singleTon.print();
	}

}
