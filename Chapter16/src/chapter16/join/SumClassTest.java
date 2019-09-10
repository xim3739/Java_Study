package chapter16.join;

public class SumClassTest {

	public static void main(String[] args) throws InterruptedException {
		DataClass myData = new DataClass();
		
		System.out.println(myData.getSum());
		
		Thread myThread = new SumClass(myData);
		myThread.start();
		myThread.join();
		
		System.out.println(myData.getSum());
	}

}
