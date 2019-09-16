package example05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Example05 {

	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = null;
		BufferedInputStream bufferedInputStream = null;
		DataInputStream dataInputStream = null;
		
		FileOutputStream fileOutputStream = new FileOutputStream("example05.bin");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
		DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);
		
		dataOutputStream.writeInt(100);
		dataOutputStream.writeShort('A');
		dataOutputStream.writeLong(123L);
		dataOutputStream.writeFloat(12.444f);
		dataOutputStream.writeDouble(3.141592);
		
		dataOutputStream.flush();
		
		if(dataOutputStream != null) {
			dataOutputStream.close();
		}
		
		fileInputStream = new FileInputStream("example05.bin");
		bufferedInputStream = new BufferedInputStream(fileInputStream);
		dataInputStream = new DataInputStream(bufferedInputStream);
		
		System.out.println(dataInputStream.readInt());
		System.out.println((char)(dataInputStream.readShort()));
		System.out.println(dataInputStream.readLong());
		System.out.println(dataInputStream.readFloat());
		System.out.println(dataInputStream.readDouble());
		
		if(dataInputStream != null) {
			dataInputStream.close();
		}
		
	}

}
