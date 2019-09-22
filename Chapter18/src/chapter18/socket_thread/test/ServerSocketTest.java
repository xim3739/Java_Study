package chapter18.socket_thread.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ServerSocketTest {
	public static Map<String, String> map = new HashMap<String, String>();
	
	public static void main(String[] args) throws Exception{
		
		map.put("java", "자바");
		map.put("bus", "버스");
		map.put("taxi", "택시");
		map.put("sim", "심재현");
		
		System.out.println("Run Server");
		int clientId = 0;
		ServerSocket serverSocket = new ServerSocket(9111);
		
		try {
			
			while(true) {
				clientId++;
				Translator t = new Translator(serverSocket.accept(), clientId);
				t.start();
			}
			
		}finally {
			
			serverSocket.close();
			
		}
	}
	
	public static class Translator extends Thread {
		private Socket socket;
		private int myId;
		private BufferedReader bufferedReader;
		private PrintWriter printWriter;
		
		public Translator(Socket socket, int myId) throws IOException {
			this.socket = socket;
			this.myId = myId;
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			printWriter = new PrintWriter(socket.getOutputStream(),true);
		}
		
		@Override
		public void run() {
			printWriter.println("HI Client number : " + socket.getInetAddress());
			
			try {
				
				while(true) {
					
					printWriter.println("input word :");
					
					String inputWord = bufferedReader.readLine();
					System.out.println(inputWord);
					
					if(inputWord == null) {
						break;
					}
					Set<Entry<String, String>> set = map.entrySet();
					boolean find = false;
					for(Entry<String, String> ent : set) {
						String key = ent.getKey();
						if(key.equals(inputWord)) {
							find = true;
							printWriter.println(inputWord + " is " + ent.getValue());
							break;
						}
					}
					if(find == false) {
						printWriter.println("Not Found Word");
					}
					
//					if(inputWord.equals("java")) {
//						printWriter.println("java -> 자바");
//						
//					} else {
//						printWriter.println("Not Found Word");
//						
//					}
				}
				
			} catch (IOException e) {
				System.out.println("Error ... Client : " + myId);
				e.printStackTrace();
			}finally {
				try {
					socket.close();
					bufferedReader.close();
					printWriter.close();
				} catch (IOException e) {
					System.out.println("socket close Error");
					e.printStackTrace();
				}
				
				System.out.println("END !!!! Client : " + myId);
			}
		}
		
	}
}
