package Chapter03;

import java.time.*;

public class TimerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime localDateTime = LocalDateTime.now();
		
		int year = localDateTime.getYear();
		Month month = localDateTime.getMonth();
		int day = localDateTime.getDayOfMonth();
		int hour = localDateTime.getHour();
		int minute = localDateTime.getMinute();
		int second = localDateTime.getSecond();
		
	}

}
