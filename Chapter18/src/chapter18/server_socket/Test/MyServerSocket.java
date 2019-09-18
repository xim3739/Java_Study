package chapter18.server_socket.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServerSocket {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9472);
		while(true) {
			
			System.out.println("wait Client");
			Socket socket = serverSocket.accept();
			
			OutputStream outputStream = socket.getOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			String data = bufferedReader.readLine();
			System.out.println(data);
			
			printStream.println(new Date().toString());
			printStream.close();
			break;
			
		}//end of while
		
		serverSocket.close();
	}

}
