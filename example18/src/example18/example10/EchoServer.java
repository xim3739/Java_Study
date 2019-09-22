package example18.example10;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private ServerSocket serverSocket;
	private Socket socket;
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private String reciveData;
	
	public EchoServer() {
		try {
			serverSocket = new ServerSocket(9111);
			System.out.println("Wait Client");
			socket = serverSocket.accept();
			System.out.println("Conneting Success!");
			
			input = new ObjectInputStream(socket.getInputStream());
			output = new ObjectOutputStream(socket.getOutputStream());
			
			while((reciveData = (String)input.readObject()) != null) {
				if(reciveData.equals("quit")) {
					break;
				}
				output.writeObject(reciveData);
				output.flush();
			}
			System.out.println("end");
			input.close();
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoServer();
	}

}
