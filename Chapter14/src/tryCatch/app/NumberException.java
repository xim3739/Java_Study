package tryCatch.app;

import javax.management.RuntimeErrorException;

public class NumberException {

	public static void main(String[] args) throws Exception {	
		System.out.println("cal number");
		int number = 10/10;
		int num2 = 0;
		System.out.println("number is " + number);
		
		System.out.println("cal number");
		testPrint();
		try {
			num2 = 10/0;
		} catch (ArithmeticException e) {
			System.out.println("exception : " + e.getMessage());
			num2 = 10/1;
		}finally {
			System.out.println("END");
		}
		
		System.out.println("number is " + num2);
	}
	
	public static void testPrint() {
		System.out.println("11....");
		int number = 0;
		
		try {
			number = 10/0;
		} catch (ArithmeticException e) {
			System.out.println("12 ...... Exception");
			throw new RuntimeException(e);
		}
		
		
		System.out.println("12...." + number);
		
		System.out.println("13....... END");
	}
	
}
