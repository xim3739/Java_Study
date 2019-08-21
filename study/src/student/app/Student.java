package student.app;

public class Student {
	
	private String name;
	private int stdNum;
	private String gender;
	private int score;
	
	public Student() {
		this.name = null;
		this.stdNum = 0;
		this.gender = null;
		this.score = 0;
	}
	
	public Student(String name, int stdNum, String gender, int score) {
		this.name = name;
		this.stdNum = stdNum;
		this.gender = gender;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStdNum() {
		return stdNum;
	}

	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(score < 1 || score > 100) {
			this.score = 0;
		} else {
			System.out.println("input wrong Score ... setting 0");
			this.score = score;
		}
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", stdNum=" + stdNum + ", gender=" + gender + ", score=" + score + "]";
	}
	
	public void nameScorePrint() {
		System.out.println("name : " + this.name + "\nsocre : " + this.score );
	}
	
}
