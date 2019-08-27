package example01;

public class Student {
	private int number;
	public String name;
	
	public Student() {
		this(0, null);
	}
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
