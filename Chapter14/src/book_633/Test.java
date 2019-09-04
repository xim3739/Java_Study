package book_633;

import java.io.IOException;

public class Test {
	public static final int SIZE = 100;

	public static void main(String[] args) throws IOException {
		
		System.out.println(readString());
		
	}
	
	public static String readString() throws IOException {
		
		byte[] buf = new byte[SIZE];
		
		System.out.print("문자열을 입력하세요 : ");
		System.in.read(buf);
		throw new IOException();

		
	}

}
