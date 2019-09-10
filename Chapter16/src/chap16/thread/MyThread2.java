package chap16.thread;

import java.awt.Toolkit;

public class MyThread2 extends Thread{
	
	
	@Override
	public void run() {
		Toolkit tool = Toolkit.getDefaultToolkit();
		
		for(int i = 1; i < 5; i++) {
			tool.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
}

