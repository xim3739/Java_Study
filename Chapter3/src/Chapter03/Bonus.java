package Chapter03;

import java.util.Scanner;

public class Bonus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int saleTaget = 1000;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("input money : ");
			int money = scanner.nextInt();
			
			if(money < 1000) {
				System.out.println(saleTaget - money + " you lose u.u");
				continue;
			}else {
				System.out.println("bonus is " + (int)((money - saleTaget) * 0.1));
				break;
			}
		} 
	}

}
