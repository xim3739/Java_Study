package Chapter03;

import java.util.Scanner;

public class Rotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long nValue = 0;
		long kValue = 0;
		long i = 0;
		long fac1 = 1;
		long fac2 = 1;
		long total = 0;

		nValue = inputNum();
		kValue = inputNum();
		
		for(i = 1; i <= kValue; i++) {
			fac1 = fac1 * (nValue - i + 1);
		}
		for(i = 1; i <= kValue; i++) {
			fac2 = fac2 * i;
		}
		
		total = fac1 / fac2;
		
		System.out.println("1 / " + total);
	}
	
	public static long inputNum() {
		long num = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("input number : ");
		num = scanner.nextLong();
		
		return num;
	}

}
