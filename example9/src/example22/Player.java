package example22;

import java.util.Scanner;

public class Player extends Dice{
	private int playerNum;
	
	public Player() {
		super();
		this.playerNum = 1;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	
	public void start() {
		System.out.println("주사위를 굴립니다.....");
		super.roll();
		System.out.print("숫자를 입력하세요 : (1 ~ 6)");
		Scanner input = new java.util.Scanner(System.in);
		this.playerNum = input.nextInt();
		
		if(this.playerNum > super.getValue()) {
			System.out.println("사용자가 이겼습니다.");
		}else if(this.playerNum == super.getValue()) {
			System.out.println("비겼습니다.");
		}else {
			System.out.println("사용자가 졌습니다.");
		}
	}
}
