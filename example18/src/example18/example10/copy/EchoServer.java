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
		//try(이 안에 닫아야할 것들을 선언과 초기값을 주면 자동으로 null값이 들어가면 닫아준다. close를 안써도 된다. 신기방) {}
		try (ServerSocket serverSocket = new ServerSocket(9111);
				Socket socket = serverSocket.accept();
				BufferedReader socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));) {
			System.out.println("Conneting Success!");

			String receivedData = null;
			while ((receivedData = socketReader.readLine()) != null) {
				if (receivedData.equals("quit")) {
					break;
				}
				socketWriter.write(receivedData+"\n");//리시브데이터를 널을 빼서준다... 
													  //그래서 널을 추가해야 클라이언트에서 받는다...
				socketWriter.flush();
			}
			System.out.println("end");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new EchoServer();
	}

}
