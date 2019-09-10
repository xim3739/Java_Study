package chapter16.JFrame.app;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.text.StyledEditorKit.BoldAction;

public class CountDownTest extends JFrame{
	private JLabel label;
	
	private class MyThread extends Thread {
		@Override
		public void run() {
			for(int i = 10; i <= 0; i--) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				label.setText(i + " ");
			}// end of for
		}// end of run
	}

	public CountDownTest() throws HeadlessException {
		super();
		setTitle("Title Text");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.label = new JLabel("Start");
		this.label.setFont(new Font("Serif", Font.BOLD,50));
		add(label);
		Thread myThread = new MyThread();
		myThread.start();
		setVisible(true);
	}
	
}
