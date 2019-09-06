package vector.test;

public class MyClass {
	public int number;

	public MyClass(int number) {
		super();
		this.number = number;
	}

	@Override
	public String toString() {
		return "MyClass [number=" + number + "]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
