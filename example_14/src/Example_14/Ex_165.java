package Example_14;

import java.util.Scanner;

public class Ex_165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 10;
		int[] seat = new int[SIZE];
		
		while(true) {
			System.out.println("-----------------------------------");
			for(int i = 0; i < seat.length; i++) {
				System.out.print(i + 1 + " ");
			}
			System.out.println("\n-----------------------------------");
			
			for(int i = 0; i < seat.length; i++) {
				System.out.print(seat[i] + " ");
			}
			System.out.println("\n-----------------------------------");
			
			System.out.print("원하시는 좌석번호를 입력하세요 (종료는 -1) : ");
			Scanner scan = new Scanner(System.in);
			int s = scan.nextInt();
			if(s == -1) {
				break;
			}
			if(seat[s-1] == 0) {
				seat[s-1] = 1;
				System.out.println("예약되었습니다.");
			} else {
				System.out.println("이미 예약 되었습니다.");
			}
		}
	}

}
