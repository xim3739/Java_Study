package example13;

public class Sum {
	double num1;
	double num2;
	double num3;
	
	public Sum() {
		this.num1 = 0.0;
		this.num2 = 0.0;
		this.num3 = 0.0;
	}
	public Sum(double num1, double num2) {
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = 0.0;
	}
	
	public double sum() {
		return this.num1 + this.num2;
	}
	public double sum(double num3) {
		this.num3 = num3;
		return this.num1 + this.num2 + this.num3;
	}
	public double getNum1() {
		return num1;
	}
	public void setNum1(double num1) {
		this.num1 = num1;
	}
	public double getNum2() {
		return num2;
	}
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public double getNum3() {
		return num3;
	}
	public void setNum3(double num3) {
		this.num3 = num3;
	}
	
}
