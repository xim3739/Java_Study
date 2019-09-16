package chapter17.dataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataStreamTest {

	public static void main(String[] args) throws Exception {
		//입력
		FileInputStream fileInputStream = new FileInputStream("data.bin");
		BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
		DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
		//출력
		FileOutputStream fileOutputStream = new FileOutputStream("data.bin");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
		
		dataOutputStream.writeDouble(3.141592);
		dataOutputStream.writeInt(1000);
		dataOutputStream.writeUTF("안녕하세요.");
		
		dataOutputStream.flush();
		
		System.out.println("완료 했습니다.");
		
		fileInputStream = new FileInputStream("data.bin");
		bufferedInputStream = new BufferedInputStream(fileInputStream);
		dataInputStream = new DataInputStream(bufferedInputStream);
		
		System.out.println(dataInputStream.readDouble());
		System.out.println(dataInputStream.readInt());
		System.out.println(dataInputStream.readUTF());
		
		if(dataOutputStream != null) {
			dataOutputStream.close();
		}
		if(dataInputStream != null) {
			dataInputStream.close();
		}
	}

}
