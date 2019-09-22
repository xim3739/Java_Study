package chapter18.tictactoc.game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientTest extends Thread{
	
	private JButton[][] jButton = new JButton[3][3];
	private char me, other;
	private JFrame frame;
	private JPanel panel;
	private JLabel message;
	private BufferedReader in;
	private PrintWriter out;
	private Socket socket;
	
	
	
	public ClientTest() {
		
		try {
			socket = new Socket("localhost", 9111);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame = new JFrame();
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 5, 5));
		Font font = new Font("Dialog", Font.BOLD, 50);
		message = new JLabel("여기에 메세지가 출력 됩니다.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(message, BorderLayout.SOUTH);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				final int ii = i;
				final int jj = j;
				jButton[i][j] = new JButton(" ");
				jButton[i][j].setFont(font);
				
				jButton[i][j].addActionListener(e -> {
						jButton[ii][jj].setText("" + me);
						out.println("MOVE " + ii + " " + jj);
					}
				);
				
				panel.add(jButton[i][j]);
			}
		}
		
		panel.repaint();//무효화 영역 처리 방식
	}// end of construct

	@Override
	public void run() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
