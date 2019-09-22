package example18.example10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class EchoClient {
	private Socket socket;
	private BufferedReader reader;
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private String sendData;
	private String reciveData;
	private boolean flag = false;
	
	public EchoClient() {
		try {
			System.out.println("Connecting....");
			socket = new Socket("localhost", 9111);
			output = new ObjectOutputStream(socket.getOutputStream()); //코멘트에 따라서 뭔가 수정
			input = new ObjectInputStream(socket.getInputStream());
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			while(flag == false) {
				System.out.print("send : ");
				while((sendData = reader.readLine()) != null) {
					output.writeObject(sendData);
					output.flush();
					
					if(sendData.equals("quit")) {
						flag = true;
						break;
					}
					
					reciveData = (String)input.readObject();
					System.out.println(reciveData);
					break;
				}
				if(flag == true) {
					System.out.println("end");
					input.close();
					output.close();
					socket.close();
					System.exit(0);
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoClient();
	}

}
