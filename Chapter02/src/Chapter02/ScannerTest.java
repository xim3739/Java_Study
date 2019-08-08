package Chapter02;

import java.util.*;

public class ScannerTest {
	
	public static  void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		String s1;
		String s2;
		int age = 0;
		
		System.out.print("input first String : ");
		s1 = input.nextLine();
		
		
		System.out.print("input second String : ");
		s2 = input.nextLine();
		
		System.out.println(s1 + " " + s2);
		
		System.out.print("input your age : ");
		age = input.nextInt();
		
		System.out.println("your age is " + age);
	}
}
