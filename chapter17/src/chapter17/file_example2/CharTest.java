package chapter17.file_example2;

import java.io.FileReader;
import java.io.FileWriter;

public class CharTest {

	public static void main(String[] args) throws Exception{
		
		FileReader in = new FileReader("InputString.txt");
		FileWriter out = new FileWriter("OutputString.txt");
		
		int data = 0;
		
		while((data = in.read()) != -1) {
			out.write(data);
			System.out.print((char)data);
		}
		
		System.out.println("\n=================\n복사가 완료 됐습니다.");
		
		if(in != null) {
			in.close();
		}
		if(out != null) {
			out.close();
		}
		
	}

}
