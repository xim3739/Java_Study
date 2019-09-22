package example18.example11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EchoClientUDP {

	final int myPort = 8001;
	final int otherPort = 9001;

	private DatagramPacket sendPacket;
	private DatagramPacket receivePacket;
	private InetAddress address;

	private byte[] buffer;
	private String sendData;
	private String receiveData;

	public EchoClientUDP() {
		System.out.println("Wait Server Connecting");
		//서버와 연결이 될때까지 기다린다.
		try {
			address = InetAddress.getByName("localhost");
			//서버의 주소를 얻는다.
		} catch (UnknownHostException e1) {
			System.out.println("not found address");
			//서버의 주소를 못 얻었을때 오류 표시
			e1.printStackTrace();
		}

		try (DatagramSocket socket = new DatagramSocket(myPort);) {
			//유디피 소켓을 만든다.
			xim: while (true) {
				System.out.print("send : ");
				//보내는 메세지 출력
				BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
				//컴퓨터 입력을 받아올 스트림을 만든다.
				while ((sendData = line.readLine()) != null) {
					//입력한 스트림이 없는지 있는지 확인 후 반복문을 돌린다.
					buffer = new byte[1024];
					//패킷으로 보낼 바이트 배열을 만든다.
					buffer = sendData.getBytes();
					//컴퓨터 키보드로 입력받은 스트링을 바이트로 바꾼다.
					sendPacket = new DatagramPacket(buffer, buffer.length, address, otherPort);
					//패킷에 바이트, 바이트의 길이, 서버의 주소, 서버의 포트 번호를 서버에 보낼 패킷 객체를 만든다.
					socket.send(sendPacket);
					//보낸다.

					if (sendData.equals("exit")) {
						break xim;
					}
					//문자랑 같으면 종료

					buffer = new byte[sendData.length()];
					//서버에서 받을 데이터를 배열의 크기만큼 만든다.
					//어차피 내가 보낸것을 바로 돌려받기 때문에 내가 보낸 데이터의 크기로 
					//배열의 길이를 잡는다.

					receivePacket = new DatagramPacket(buffer, buffer.length);
					//서버에서 보낸 패킷을 받는 객체를 만든다. 바이트 배열, 길이만큼
					socket.receive(receivePacket);
					//받는다.
					receiveData = new String(receivePacket.getData(), 0, receivePacket.getData().length);
					//패킷을 받아서 데이터를 얻어오고 0부터 패킷 데이터의 길이만큼 문자열로 바꾼다.
					System.out.println("receive : " + receiveData);
					//콘솔창에 프린트한다.
					break;
					//나간다.
				}
				//마지막 브레이크로 나오면 맨 위 반복문으로 들어가서 다시 컴퓨터로 입력을 받는다.
			}
			System.out.println("end");
			//라벨을 거쳐서 반복문을 나오면 종료한다. 
			//이떄 try() 괄호안에 패킷을 만들었기 때문에 사용을 다 하면 알아서 종료한다.
		} catch (Exception e) {
			e.printStackTrace();
			// 실행도중 오류
		}
	}

	public static void main(String[] args) {
		EchoClientUDP e1 = new EchoClientUDP();
	}

}
