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
			//아닌거 같다... 그냥 오류인가... 이렇게 쓰면 순서 상관이 없는데 이걸 밖으로 빼는 순간 순서의 영향을 받는가 보다...
			//우선 서버와 통신할 소켓을 만든다. (서버의 주소, 포트번호)
			//통신에 필요한 스트림을 만든다. input, output
			//컴퓨터로 입력을 받은 데이터를 스트림으로 바꿔야 하므로 reader를 만든다. (System.in)
			xim: while(true) {
				System.out.print("send : ");
				//콘솔창에 보낸다 라는 메세지 출력
				while((sendData = reader.readLine()) != null) {
					//컴퓨터로 입력받은 데이터가 없는지 있는지 확인 후 반복문
					output.write(sendData + "\n");
					//컴퓨터로 입력받은 데이터에 \n을 더해서 서버에 보낸다.
					//\n 까지 있어야 서버에서 받는다... readLine의 특성 : \n이 꼭 들어가야 한다.
					output.flush();
					//버퍼에 있는 데이터를 모두 보낸다.
					
					if(sendData.equals("quit")) {
						System.out.println("End");
						break xim;// 라벨이라는 것이다. 지정한 반복분을 나가는 것이다. 저 위에 쓴 곳을 나간다.
								  // 플래그를 안써도 된다. 변수를 만들 필요가 없다.
					}
					//컴퓨터로 입력한 데이터가 같은 값이면 반복문을 모두 나온다.
					reciveData = input.readLine();
					//서버에서 보낸 데이터를 읽어서 저장한다.
					System.out.println(reciveData);
					//콘솔창에 출력한다.
					break;
					//작은 반복문을 나간다.
				}
			}
			//라벨에 있는 break면 이쪽으로 나온다. 모든 반복문을 나가게 된다.
		} catch (Exception e) {
			e.printStackTrace();
			//소켓이나, 데이터 주고받을때의 오류
		}
	}
	public static void main(String[] args) {
		new EchoClient();
	}

}
