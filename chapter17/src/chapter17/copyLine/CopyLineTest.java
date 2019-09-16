package chapter17.copyLine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CopyLineTest {

	public static void main(String[] args) throws Exception {
		File inFile = new File("Input.txt");
		FileReader fileReader = new FileReader(inFile); // 파일 읽기
		BufferedReader bufferedReader = new BufferedReader(fileReader); //읽은 데이터를 버퍼에 넣기
		File outFile = new File("Output4.txt");
		FileWriter fileWriter = new FileWriter(outFile); //읽은 데이터를 파일로 저장
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); //저장하기 전 데이터를 버퍼에 넣기
		PrintWriter printWriter = new PrintWriter(bufferedWriter); //버퍼에 있는 데이터를 printWirter에 넣어서 저장하기
		
		String data = null;
		
		while((data = bufferedReader.readLine()) != null) {
			printWriter.println(data);
		}
		
		if(bufferedReader != null) {
			bufferedReader.close();
		}
		if(printWriter != null) {
			printWriter.close();
		}
		
	}

}
