package example23;

import java.util.Scanner;

public class Player extends ComputerGuesse{
	private int playerValue;
	
	public void start() {
		super.setComValue();
		System.out.println("가위(0) 바위(1) 보(2)를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		this.playerValue = input.nextInt();
		if(this.playerValue > super.getComValue()) {
			System.out.println("사용자가 이겼습니다.");
		}else if(this.playerValue == super.getComValue()) {
			System.out.println("비겼습니다.");
		}else {
			System.out.println("사용자가 졌습니다.");
		}
	}
}
