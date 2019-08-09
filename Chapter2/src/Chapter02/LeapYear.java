package Chapter02;

public class LeapYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2012;
		boolean isLeapYear = false;
		
		isLeapYear = (year % 4 == 0);
		
		System.out.println(isLeapYear);
	}

}
