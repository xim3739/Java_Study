package example14;

public class JnderGraduate extends Student{
	private String Circle;
	
	public JnderGraduate() {
		super();
	}

	public JnderGraduate(String name, String studentNum, String mager, int studentYear, int score, String circle) {
		super(name, studentNum, mager, studentYear, score);
		Circle = circle;
	}

	public String getCircle() {
		return Circle;
	}

	public void setCircle(String circle) {
		Circle = circle;
	}

	@Override
	public String toString() {
		return "JnderGraduate [Circle=" + Circle + ", getName()=" + getName() + ", getStudentNum()=" + getStudentNum()
				+ ", getMager()=" + getMager() + ", getStudentYear()=" + getStudentYear() + ", getScore()=" + getScore()
				+ "]";
	}
	
	
	
}
