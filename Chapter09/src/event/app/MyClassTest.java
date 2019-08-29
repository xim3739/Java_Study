package event.app;

import java.awt.event.ActionListener;

import javax.swing.Timer;


public class MyClassTest {

	public static void main(String[] args) {
		ActionListener listener = new Myclass();
		
		Timer t = new Timer(1000, listener);
		
		t.start();
		for(int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
