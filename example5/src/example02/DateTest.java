package example02;

public class DateTest {

	public static void main(String[] args) {
		Date myDate = new Date(2019, 8, 20);
		
		myDate.memberPrint();
		
		myDate.setYear(2020);
		myDate.setMonth(3);
		myDate.setDay(20);
		
		myDate.memberPrint();
	}

}
