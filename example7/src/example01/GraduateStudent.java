package example01;

public class GraduateStudent extends Student{
	public String lab;

	public GraduateStudent(int number, String name, String lab) {
		super(number, name);
		this.lab = lab;
	}

	public String getLab() {
		return lab;
	}

	public void setLab(String lab) {
		this.lab = lab;
	}
	
	public int getNumber() {
		return super.getNumber();
	}
	public void setNumber(int number) {
		super.setNumber(number);
	}
	
	
}
