package example07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example07_2 {

	public static void main(String[] args) throws Exception {
		
		List<Integer> intArr = new ArrayList<Integer>();
		
		FileReader fileReader = new FileReader("example07.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriter = new FileWriter("exampleout07.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		
		String data = null;
		
		while((data = bufferedReader.readLine()) != null) {
			int num = Integer.parseInt(data);
			intArr.add(num);
		}
		
		Collections.sort(intArr);
		
		String arrStr = intArr.toString();
		
		bufferedWriter.write(arrStr, 0, arrStr.length());
		
		bufferedWriter.flush();
		
		bufferedReader.close();
		bufferedWriter.close();
	}
	
}
