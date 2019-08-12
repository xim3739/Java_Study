package example;
import java.util.Scanner;
public class ex10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		num = inputNum();
		
		switch (num) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;

		}
	}
	
	public static int inputNum() {
		int num = 0;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("input number : ");
			num = input.nextInt();
			if(num < 1 || num > 9) {
				System.out.println("wrong input number.");
			} else {
				break;
			}
		}
		return num;
	}
}
