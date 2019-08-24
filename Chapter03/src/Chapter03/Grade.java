package Chapter03;

import java.util.Scanner;

public class Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int scoreType = 10;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("input your name : ");
		String name = scanner.nextLine();
		
		while(true) {
		System.out.print("input your score : ");
		int score = scanner.nextInt();
		
		if(score >= 0 && score <= 100) {
			
			if(score >= 90) {
				System.out.println("Grade is A");
				break;
			} else if(score >= 80) {
				System.out.println("Grade is B");
				break;
			} else if(score >= 70) {
				System.out.println("Grade is C");
				break;
			} else {
				System.out.println("Grade is D");
				break;
			}
	
		} else {
			System.out.println("wrong input score... try again");
			continue;
		}
			
		}
		
	}

}
