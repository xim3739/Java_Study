package Chapter03;

import java.util.*;

public class ToBinaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		String strResult = null;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("input number : ");
		num = input.nextInt();
		
		strResult = toBinaryString(num);
		
		System.out.println(num+" to binary is " + strResult);
		
	}
	
	public static String toBinaryString(int value) {
		
		String strValue = Integer.toBinaryString(value);
		
		System.out.println("binary lenth"+strValue.length());
		
		while(strValue.length() < 32) {
			strValue = "0" + strValue;
		}
		
		return strValue;
	}

}
