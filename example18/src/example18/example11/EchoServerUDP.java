package example18.example11;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServerUDP {

	final int myPort = 9001;

	private byte[] buffer;
	private String reader;
	private DatagramPacket receivePacket;
	private DatagramPacket sendPacket;

	public EchoServerUDP() {
		System.out.println("Wait Client");
		//클라이언트를 기다린다.
		try (DatagramSocket socket = new DatagramSocket(myPort);) {
			//포트번호를 적어서 소켓을 만든다.
			while (true) {
				buffer = new byte[1024];
				//주고받을 바이트 배열을 만든다.
				receivePacket = new DatagramPacket(buffer, buffer.length);
				//에코서버는 클라이언트에서 받은 데이터를 돌려주는 서버이기 때문에 먼저 클라이언트에 데이터를 보내야한다.
				//따라서 우선 서버는 데이터를 받아야한다. 그래서 패킷을 바이트 배열, 배열의 길이만큼 받는 패킷 객체를 만든다.
				socket.receive(receivePacket);
				//받는다. 
				
				reader = new String(receivePacket.getData(),0,receivePacket.getLength());
				//받은 패킷을 문자열로 바꾼다. 
				//받은 패킷의 데이터, 0부터 받은 패킷의 데이터의 길이만큼 문자열로 바꾼다.
				System.out.println("receive message : " + reader);
				//콘솔창에 출력한다.
				if(reader.equals("quit")) {
					break;
				}
				//다음 문자와 같으면 반복문을 나간다.
				sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getData().length,
						receivePacket.getAddress(), receivePacket.getPort());
				//클라이언트로부터 받은 문자를 다시 돌려줘야한다.
				//받은 패킷의 데이터, 받은 패킷의 데이터의 길이, 받은 패킷의 주소, 받은 패킷의 포트번호를 적어서
				//보내는 패킷을 만든다.
				socket.send(sendPacket);
				//보낸다.
			}
			System.out.println("exit");
			//최종적으로 나오면 서버도 종료한다.
			//try() 괄호안에 패킷을 만들었으므로 따로 닫아주지 않아도 자동으로 닫힌다.
		} catch (Exception e) {
			e.printStackTrace();
			//실행오류
		}
	}

	public static void main(String[] args) {
		EchoServerUDP e1 = new EchoServerUDP();
	}

}
