package chap16.thread;

public class MyThread extends Thread{
	@Override
	public void run() {
		for(int i = 1; i < 5; i++) {
			System.out.println(i + " ");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
