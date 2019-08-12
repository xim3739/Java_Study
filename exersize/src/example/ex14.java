package example;

import java.util.Scanner;

public class ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char chars = 0;
		
		chars = inputChar();
		
		switch (chars) {
		case 'A':	case 'a':
			System.out.println("모음");
			break;
		case 'E':	case 'e':
			System.out.println("모음");
			break;
		case 'I':	case 'i':
			System.out.println("모음");
			break;
		case 'O':	case 'o':
			System.out.println("모음");
			break;
		case 'U':	case 'u':
			System.out.println("모음");
			break;

		default:
			System.out.println("자음");
			break;
		}
	}

	public static char inputChar() {
		String str = null;
		char charValue = 0;
		Scanner input = new Scanner(System.in);
		
		str = input.next();
		charValue = str.charAt(0);
		return charValue;
	}
	
}
