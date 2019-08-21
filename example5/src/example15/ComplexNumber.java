package example15;

public class ComplexNumber {
	private double real;
	private double imag;
	
	public ComplexNumber() {
		this.imag = 0.0;
		this.real = 0.0;
	}
	
	public ComplexNumber(double real, double imag) {
		this.imag = imag;
		this.real = real;
	}
	
	public double complexNum(int i) {
		return this.real + this.imag * i;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	
}
