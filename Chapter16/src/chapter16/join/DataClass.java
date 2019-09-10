package chapter16.join;

public class DataClass {
	private int sum = 0;

	public synchronized int  getSum() { //동기화 처리
		return sum;
	}

	public synchronized void setSum(int sum) { //동기화 처리
		this.sum = sum;
	}
	
	
}
