package example14;

public class Date {
	private int year;
	private int month;
	private int day;
	
	public Date() {
		this.year = 0;
		this.month = 0;
		this.day = 0;
	}
	public Date(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	public void print1() {
		System.out.println(this.year+"."+this.month+"."+this.day);
	}
	public void print2() {
		String[] str = new String[] {"jeny", "feb", "merch", "aprl", "may", "jun", "july",
													"agus", "septem", "octo", "novem", "decem"};
		String str1 = null;
		str1 = str[this.month-1];
		
		System.out.println(str1 + "." + this.day+ "." + this.year);
	}
}
