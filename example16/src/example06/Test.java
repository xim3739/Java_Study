package example06;

public class Test implements Runnable{
	
	public static void main(String[] args) {
		Test t = new Test();
		Thread x = new Thread(t);
		
		x.start();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; ++i) {
			System.out.println(i + " ");
		}
	}
}
