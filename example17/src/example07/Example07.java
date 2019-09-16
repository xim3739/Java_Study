package example07;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example07 {

	public static void main(String[] args) throws Exception {
		
		List<Double> doubleArr = new ArrayList<Double>();
		
		FileReader fileReader = new FileReader("example07.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriter = new FileWriter("exampleout07.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		
		String data = null;
		
		while((data = bufferedReader.readLine()) != null) {
			double num = Double.parseDouble(data);
			doubleArr.add(num);
		}
		
		Collections.sort(doubleArr);
		
		for(double value : doubleArr) {
			if(value % 1 == 0) {
				bufferedWriter.write(String.valueOf((int)(value))+"\n");
			} else {
				bufferedWriter.write(String.valueOf(value)+"\n");
			}
		}
		
		bufferedWriter.flush();
		
		bufferedReader.close();
		bufferedWriter.close();
	}
	
}
