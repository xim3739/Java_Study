package compareToTest;

public class RectagleTest {

	public static void main(String[] args) {
		Rectangle rec1 = new Rectangle(10, 40);
		Rectangle rec2 = new Rectangle(20, 10);
		Circle cir1 = new Circle(20);
		
		int compareValue = 0;
		
		System.out.println(rec1);
		System.out.println(rec2);
		System.out.println(cir1);
		
		compareValue = rec1.compareTo(rec2);
		
		ifFunc(compareValue, "객체1", "객체2");
		
		compareValue = rec1.compareTo(cir1);
		
		ifFunc(compareValue, "객체1", "객체2");
		
	}
	public static void ifFunc(int compareValue, String str1, String str2) {
		if(compareValue == 1) {
			System.out.println(str1+" 이 크다.");
		} else if (compareValue == -1) {
			System.out.println(str2 + " 가 크다.");
		} else if (compareValue == 0){
			System.out.println("두 객체는 같다.");
		} else {
			System.out.println("두 객체를 비교할 수 없습니다.");
		}
		
	}
	
}
