package example11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example11 {

	public static void main(String[] args) throws Exception {
		List<String> arr1 = new ArrayList<String>();
		List<String> arr2 = new ArrayList<String>();
		
		BufferedReader bufferedReader1 = new BufferedReader(
				new FileReader("example11_1.txt"));
		BufferedReader bufferedReader2 = new BufferedReader(
				new FileReader("example11_2.txt"));
		String data = null;
		while((data = bufferedReader1.readLine()) != null) {
			arr1.add(data);
		}
		while((data = bufferedReader2.readLine()) != null) {
			arr2.add(data);
		}
		System.out.println(arr1.equals(arr2));
	}

}
