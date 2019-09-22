package example18.example10.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public EchoServer() {
		System.out.println("Wiat Client");
		//서버를 기다린다.
		
		//try(이 안에 닫아야할 것들을 선언과 초기값을 주면 자동으로 null값이 들어가면 닫아준다. close를 안써도 된다. 신기방기) {}
		try (ServerSocket serverSocket = new ServerSocket(9111);
				Socket socket = serverSocket.accept();
				BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
			//필요한 서버소켓, 소켓, input과 output을 만든다.
			System.out.println("Conneting Success!");
			//연결 성공 확인 출

			String receivedData = null;
			while ((receivedData = socketReader.readLine()) != null) {
				//클라이언트가 보낸 스트림을 서버 소켓으로 읽고 그것을 저장한다.
				//그리고 데이터가 있는지 없는지 확인 후 반복문 실
				if (receivedData.equals("quit")) {
					break;
				}
				//받은 데이터가 같은 데이터이면 반복문 종
				
				socketWriter.write(receivedData+"\n");//리시브데이터를 널을 빼서준다. 그래서 널을 추가해야 클라이언트에서 받는다...
				//받은 데이터를 다시 보낸다. 이때 \n 필수... 
				//받는 클라이언트가 readLine으로 받기 때문에
				socketWriter.flush();
				//버퍼에 있는 데이터를 모두 보낸다.
			}
			System.out.println("end");
			//반복문을 나오게 되면 종료

		} catch (Exception e) {
			e.printStackTrace();
			//소켓 또는 통신중 오류 표시
		}

	}

	public static void main(String[] args) {
		new EchoServer();
	}

}
