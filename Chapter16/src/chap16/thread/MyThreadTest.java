package chap16.thread;

import java.awt.Toolkit;

public class MyThreadTest {

	public static void main(String[] args) {
		
//		Thread myThread = new MyThread() {
//			@Override
//			public void run() {
//				for(int i = 1; i < 5; i++) {
//					System.out.println(i + " ");
//					try {
//						Thread.sleep(500);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		
//		Thread myThread2 = new MyThread2();
//		myThread.start();
//		myThread2.start();
		//Runnable my1 = new MyThread3();
		Thread myThread1 = new Thread(() -> {
				Toolkit tool = Toolkit.getDefaultToolkit();
				
				for(int i = 1; i < 5; i++) {
					if(i == 2 || i == 3) {
						Thread.yield();
					} else {
						tool.beep();
					}
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		);
	
		Runnable my2 = new MyThread4();
		Thread myThread2 = new Thread(my2);
	
		myThread1.start();
		myThread2.start();
	}

}