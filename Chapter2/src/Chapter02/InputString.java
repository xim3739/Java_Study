package Chapter02;

import java.util.*;

public class InputString {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String name = null;
		int age = 0;
		
		System.out.print("input your name : ");
		name = input.nextLine();
		
		System.out.print("input your age : ");
		age  = input.nextInt();
		
		System.out.println("hellow " + name + " your age " + age + "!!!");
	}

}
