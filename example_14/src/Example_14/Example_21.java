package Example_14;

import java.util.Scanner;

public class Example_21 {

	private static String[] hexa2bin = {"0000", "0001", "0010", "0011","0100", "0101", "0110", "0111","1000", "1001", "1010", "1011","1100", "1101", "1110", "1111"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputStr = null;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("input 16x num : ");
		inputStr = scanner.nextLine();
		
		System.out.print(inputStr+" to 16x is");
		
		for(int i = 0; i < inputStr.length(); i++) {
			
			if(inputStr.charAt(i) >= 48 && inputStr.charAt(i) <= 57) {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - 48]);
			} else if(inputStr.charAt(i) >= 97 && inputStr.charAt(i) <= 102) {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - 87]);
			} else if(inputStr.charAt(i) >= 65 && inputStr.charAt(i) <=70) {
				System.out.print(" " + hexa2bin[inputStr.charAt(i) - 55]);
			}
			
		}
		
		
	}

}
