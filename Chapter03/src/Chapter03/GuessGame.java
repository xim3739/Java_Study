package Chapter03;

import java.util.Scanner;

public class GuessGame {
	
	public static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int comValue = 0;
		
		comValue = comGuess();
		
		Guess_Game(comValue);
			
	}
	
	public static int comGuess() {
		int comValue = 0;
		comValue = (int)(Math.random() * 100+ 1);
		return comValue;
	}
	
	public static int userGuess() {
		int userValue = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("input number : ");
		userValue = scan.nextInt();
		count++;
		return userValue;
	}
	
	public static void Guess_Game(int comValue) {
			
		int userValue = 0;
		while(true) {
			userValue = userGuess();
			if(userValue > comValue) {
				System.out.println("user number is up");
				continue;
			} if(userValue < comValue) {
				System.out.println("user number is down");
				continue;
			} if(userValue == comValue) {
				System.out.println("congraturation !!! ");
				System.out.println("count : " + count);
				break;
			}
		}
	}
	
}
