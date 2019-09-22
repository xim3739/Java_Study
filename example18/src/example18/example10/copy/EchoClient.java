package example18.example10.copy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EchoClient {
	private String sendData;
	private String reciveData;
	
	
	public EchoClient() {
		
		try(Socket socket = new Socket("localhost", 9111);
				BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
			//인풋 아웃풋 순서도 중요하다.... 만드는거 자체도 순서가 중요하다.... 읽고 쓰고의 순서를 맞춰서 만들어야한다... 젝일...
			
			xim: while(true) {
				System.out.print("send : ");
				while((sendData = reader.readLine()) != null) {
					output.write(sendData+"\n");
					output.flush();
					
					if(sendData.equals("quit")) {
						System.out.println("End");
						break xim;// 라벨이라는 것이다. 지정한 반복분을 나가는 것이다. 저 위에 쓴 곳을 나간다.
					}
					
					reciveData = input.readLine();
					System.out.println(reciveData);
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new EchoClient();
	}

}
