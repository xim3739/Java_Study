package example09;

class Job implements Runnable {
	@Override
	public void run() {
		
		try {
			System.out.println("A");
			Thread.sleep(1000);
			System.out.println("B");
		} catch (InterruptedException e) {
			System.out.println("C");
		}
		System.out.println("D");
		
	}
}

public class Example09 {
	
	public static void main(String[] args) {
		Thread t = new Thread(new Job());
		t.start();
		t.interrupt();
	}

}
