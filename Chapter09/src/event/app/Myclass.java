package event.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Myclass implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("beep");
	}

}
