package chapter17.file_example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CopyFile {

	public static void main(String[] args) throws Exception {
		FileInputStream in = null;
		FileOutputStream out = null;
		
		in = new FileInputStream("a.jpg");
		out = new FileOutputStream("b.jpg");
		
		int data = 0;
		
		while((data = in.read()) != -1) {
			out.write(data);
		}
		System.out.println("땡구가 복사 되었습니다.");
		
		if(in != null) {
			in.close();
		}
		if(out != null) {
			out.close();
		}
		
	}

}
