package exmaple10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Example10 {

	public static void main(String[] args) throws Exception{
		BufferedReader bufferedReader1 = new BufferedReader(new FileReader("example10_1.txt"));
		BufferedReader bufferedReader2 = new BufferedReader(new FileReader("example10_2.txt"));
		
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("example10.txt"));
		
		String data = null;
		while((data = bufferedReader1.readLine()) != null) {
			bufferedWriter.write(data + "\n");
		}
		while((data = bufferedReader2.readLine()) != null) {
			bufferedWriter.write(data + "\n");
		}
		
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}

}
