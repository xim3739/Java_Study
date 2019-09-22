package chapter18.udp.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPSendTest {

	public static void main(String[] args) {
		//1. 데이타그램소켓을 만든다. 
				DatagramSocket dSocket =null;
				InetAddress ia=null;
				try {
					dSocket=new DatagramSocket(5932);
				} catch (SocketException e) {
					e.printStackTrace();
				}
				//2 보낼데이타를 바이트배열로 만들어 놓는다. 
				String data = new String("나의 운명은 내가 주인이다.");
				byte[] buf = data.getBytes();
				//3. 보내고자하는 주소를 설정한다. 
				try {
					ia=InetAddress.getByName("localhost");
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				//4. 패킷을 만든다. 
				DatagramPacket dp=new DatagramPacket(buf, buf.length, ia, 5932);
				try {
					dSocket.send(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					dSocket.close();
				}
	}

}
