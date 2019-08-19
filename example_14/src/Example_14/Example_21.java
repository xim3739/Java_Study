package Example_14;

import java.util.Scanner;

public class Example_21 {

	private static String[] hexa2bin = {"0000", "0001", "0010", "0011","0100", "0101", "0110", "0111","1000", "1001", "1010", "1011","1100", "1101", "1110", "1111"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputStr = null;
		int num = 0;
		String binaryString = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("input 16x num : ");
		inputStr = scanner.nextLine();
		
		System.out.print(inputStr+" to 16x is");
		
		for(int i = 0; i < inputStr.length(); i++) {
			
			if(inputStr.charAt(i) >= '0' && inputStr.charAt(i) <= '9') {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - '0']);
				num = inputStr.charAt(i) - '0';
			} else if(inputStr.charAt(i) >= 'a' && inputStr.charAt(i) <= 'z') {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - 'a' + 10]);
				num = inputStr.charAt(i) - 'a' + 10;
			} else if(inputStr.charAt(i) >= 'A' && inputStr.charAt(i) <= 'Z') {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - 'A' + 10]);
				num = inputStr.charAt(i) - 'A' + 10;
			}
			binaryString = toBinaryString(num);
			System.out.print(binaryString + " ");
		}
		
		
	}
	public static String toBinaryString(int num) {
		String str = null;
		str = Integer.toBinaryString(num);
		while(str.length() < 4) {
			str = "0" + str;
		}
		return str;
	}

}
