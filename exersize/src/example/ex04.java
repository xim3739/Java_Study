package example;

public class ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age = 22;
		
		if(age > 20) {
			System.out.println("1번그룹");
		}else {
			System.out.print("2번그룹 ");
			System.out.println("입니다.");
		}
		age = 66;
		
		if(age > 20) {
			if(age < 65) {
				System.out.println("1번그룹 ");
			} else {
				System.out.println("2번 그룹");
			}
		}
	}

}
