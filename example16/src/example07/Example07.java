package example07;

public class Example07 {
		private int count = 1;
		
		public synchronized void sub() {
			for(int i = 0; i < 10; i++) {
				System.out.println(count++);
			}
		}

	public static void main(String[] args) {
		Example07 demo = new Example07();
		Thread a1 = new A(demo);
		Thread a2 = new A(demo);
		
		a1.start();
		a2.start();
	}

}

class A extends Thread {
	Example07 demo;
	
	public A(Example07 ex) {
		demo = ex;
	}
	
	public void run() {
		demo.sub();
	}
}
