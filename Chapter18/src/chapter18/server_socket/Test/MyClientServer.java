package chapter18.server_socket.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class MyClientServer {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("192.168.0.230", 9100);
		InputStream inputStream = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		OutputStream outputStream = socket.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		PrintStream printStream = new PrintStream(bufferedOutputStream);
		printStream.println("");
		printStream.flush();
		
		System.out.println("wait Server");
		
		String data = bufferedReader.readLine();
		
		System.out.println(data);
		
		bufferedReader.close();
	}

}
