package Study;

import java.util.Scanner;

public class BinaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		String binary = null;
		
		num = inputNum();
		binary = change_binary(num);
		
		System.out.println(num + " is binary to " + binary);
	}
	
	public static int inputNum() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("input num : ");
		num = input.nextInt();
		return num;
	}
	
	public static String change_binary(int num) {
		String strResult = null;
		
		strResult = Integer.toBinaryString(num);
		while(strResult.length() < 32) {
			strResult = "0" + strResult;
		}
		return strResult;
	}
	
}
