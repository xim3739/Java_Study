package example18.example09;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener {
	
	JButton button;
	JTextField field;
	JEditorPane pane;
	
	public MyFrame() {
		pane = new JEditorPane();
		pane.setEditable(false);
		
		try {
			pane.setPage("http://www.google.com/");
		} catch (IOException e) {
			pane.setContentType("text/html");
			pane.setText("not Found page");
			e.printStackTrace();
		}
		field = new JTextField(50);
		button = new JButton("이동");
		button.addActionListener(this);
		
		JScrollPane scrollPane = new JScrollPane(pane);
		JPanel panel = new JPanel();
		panel.add(field);
		panel.add(button);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel, BorderLayout.NORTH);
		add(scrollPane);
		setSize(500, 500);
		setVisible(true);
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try {
				pane.setPage(field.getText());
			} catch (IOException e1) {
				pane.setContentType("text/html");
				pane.setText("not Found page");
				e1.printStackTrace();
			}
		}
	}
}

public class MyServer {

	public static void main(String[] args) {
		new MyFrame();
	}

}
