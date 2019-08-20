package example12;

public class Sum {
	private int num1;
	private int num2;
	private int num3;
	
	public Sum() {
		this.num1 = 0;
		this.num2 = 0;
		this.num3 = 0;
	}
	public Sum(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = 0;
	}
	public int sum() {
		return num1 + num2;
	}
	public int sum(int num3) {
		this.num3 = num3;
		return num1 + num2 + num3;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getNum3() {
		return num3;
	}
	public void setNum3(int num3) {
		this.num3 = num3;
	}
	
	
	
}
