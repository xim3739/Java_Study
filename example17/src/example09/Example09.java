package example09;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Example09 {

	public static void main(String[] args) throws Exception {
		List<String> myArr = new ArrayList<String>();
		
		FileReader fileReader = new FileReader("example09.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriter = new FileWriter("exampleout09.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String data = null;
		
		while((data = bufferedReader.readLine()) != null) {
			myArr.add(data);
		}
		int i = 1;
		for(String value : myArr) {
			bufferedWriter.write(i++ + " : " + value + "\n");
		}
		bufferedWriter.flush();
		
		bufferedReader.close();
		bufferedWriter.close();
	}

}
