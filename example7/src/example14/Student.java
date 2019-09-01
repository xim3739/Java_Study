package example14;

public class Student {
	private String name;
	private String StudentNum;
	private String mager;
	private int StudentYear;
	private int score;
	
	public Student() {
		this(null,null,null,0,0);
	}

	public Student(String name, String studentNum, String mager, int studentYear, int score) {
		super();
		this.name = name;
		StudentNum = studentNum;
		this.mager = mager;
		StudentYear = studentYear;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentNum() {
		return StudentNum;
	}

	public void setStudentNum(String studentNum) {
		StudentNum = studentNum;
	}

	public String getMager() {
		return mager;
	}

	public void setMager(String mager) {
		this.mager = mager;
	}

	public int getStudentYear() {
		return StudentYear;
	}

	public void setStudentYear(int studentYear) {
		StudentYear = studentYear;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", StudentNum=" + StudentNum + ", mager=" + mager + ", StudentYear="
				+ StudentYear + ", score=" + score + "]";
	}
	
	
	
}
