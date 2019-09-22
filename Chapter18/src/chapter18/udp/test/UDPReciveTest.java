package chapter18.udp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReciveTest {

	public static void main(String[] args) {
		// 1. 데이타그램소켓을 만든다.
		DatagramSocket dSocket = null;
		try {
			dSocket = new DatagramSocket(5932);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		// 2 보낼데이타를 바이트배열로 만들어 놓는다.
		byte[] buf = new byte[1024];

		// 4. 패킷을 만든다.
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		try {
			dSocket.receive(dp);
			System.out.println(new String(buf));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dSocket.close();
		}
	}

}
