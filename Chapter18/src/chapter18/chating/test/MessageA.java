package chapter18.chating.test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MessageA {

	protected JTextField textField;
	protected JTextArea textArea;

	public DatagramSocket socket;
	public DatagramPacket packet;
	public InetAddress address;

	final int myPort = 5000;
	final int otherPort = 6000;

	public MessageA() {
		MyFrame f = new MyFrame();
		try {
			address = InetAddress.getByName("192.168.112.8");
			socket = new DatagramSocket(myPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public class MyFrame extends JFrame implements ActionListener {

		public MyFrame() {
			super("Messenger A");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			textField = new JTextField(30);
			textField.addActionListener(this);

			textArea = new JTextArea(10, 30);
			textArea.setEditable(false);

			add(textField, BorderLayout.PAGE_END);
			add(textArea, BorderLayout.CENTER);
			pack();
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String data = textField.getText();
			byte[] buffer = data.getBytes();
			DatagramPacket packet;

			packet = new DatagramPacket(buffer, buffer.length, address, otherPort);

			try {
				socket.send(packet);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			textArea.append("Send : " + data + "\n");
			textField.selectAll();
			textArea.setCaretPosition(textArea.getDocument().getLength());

		}
	}

	public void process() {
		while (true) {
			try {
				byte[] buf = new byte[1024];
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				textArea.append("Receive : " + new String(buf) + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MessageA m1 = new MessageA();
		m1.process();
	}

}
