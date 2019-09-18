package chapter18.socket_test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("time-c.nist.gov", 13);
		InputStream inputStream = socket.getInputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		String data = null;
		
		while((data = bufferedReader.readLine()) != null) {
			System.out.println(data);
		}
		
		if(bufferedReader != null) {
			bufferedReader.close();
		}
		
	}

}
