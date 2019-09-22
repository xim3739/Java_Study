package chapter18.socket_thread.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientServerTest {
	private BufferedReader in;
	public static final Scanner SCANNER = new Scanner(System.in);


	public static void main(String[] args) throws Exception {
		ClientServerTest c = new ClientServerTest();
	}

	public ClientServerTest() throws Exception{
		
		Socket socket = new Socket("192.168.112.8", 9111);
		
		InputStream inputStream = socket.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		in = new BufferedReader(inputStreamReader);
	
		OutputStream outputStream = socket.getOutputStream();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
		while(true) {
			String data = null;
			if((data = in.readLine()) != null) {
				System.out.println(data);				
			}
			
			System.out.println(in.readLine());
			
			//bufferedWriter.write(word);
			bufferedWriter.flush();
			
		}
	
	}
}
