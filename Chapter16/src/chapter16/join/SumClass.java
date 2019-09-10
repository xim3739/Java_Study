package chapter16.join;

public class SumClass extends Thread{
	private DataClass data;
	
	public SumClass(DataClass data) {
		super();
		this.data = data;
	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum += i;
			data.setSum(sum);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
