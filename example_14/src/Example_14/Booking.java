package Example_14;

import java.util.Scanner;

public class Booking extends Book{
	//멤버 변수 (정적 멤버 변수, 인스턴스 멤버 변수)
	private static Scanner scanner = new Scanner(System.in); // 정적 멤버
	
	private final int INDEX = 11; //정적 멤
	
	private int[] seat = new int[INDEX]; //인스턴스 멤버  캡슐화 시켜야한다. 변수들은 private로 생성하고 set, get 함수를 통해서 접근한다.
	private int seatNum;
	
	
	//생성자 함수 
	public  Booking(int init) {
		
		seatNum = 0;	
		
		for(int i = 0; i < seat.length; i++) {
			seat[i] = init;
			
		}
		
	}
	
	//멤버 함수  
	
	public void initArrayValue () {
		
		int num = 0;
		
		System.out.print("input init Number : ");
		num = scanner.nextInt();
		
		for(int i = 0; i < seat.length; i++) {
			seat[i] = num;
		}
	}
	
	public int[] getSeat() {
		return seat;
	}

	public void setSeat(int[] seat) {
		this.seat = seat;
	}

	public int getSeatNum() {	
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public void display() {
		for(int i = 1; i < seat.length; i++) {
			System.out.print(i+", ");
		}
		System.out.println(" ");
		System.out.println("======================");
		for(int i = 1; i < seat.length; i++) {
			System.out.print(seat[i]+", ");
		}
		System.out.println("\n======================");
	}
	
	public int inputBookIndex() {
		
		int seatNum = 0;
		
		System.out.println("input seat number (-1 is exit) : ");
		seatNum = scanner.nextInt();
		if(seatNum == -1) {
			System.out.println("exit program.");
			System.exit(0);
		} else if(seatNum < seat.length) {
			if(seat[seatNum] == 0) {
				System.out.println("예약 되었습니다.");
				seat[seatNum]++;
			}else {
				System.out.println("이미 예약되었습니다.");
			}
		}else {
			System.out.println("1 ~ 10 까지의 번호를 입력하세요.");

		}
		return seatNum;
	}
	
	public void retryBook() {
		char inputYn = 0;
		System.out.println("다시 예약 하시겠습니까? : (y, n)");
		inputYn = scanner.next().charAt(0);
		
		if(inputYn == 'y' || inputYn == 'Y') {
			
		} else if(inputYn == 'N' || inputYn == 'n') {
			System.out.println("exit program.");
			System.exit(0);
		}
	}
	
}
