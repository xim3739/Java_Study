package example14;

public class Graduate extends Student{
	private String type;
	private double rate;
	
	public Graduate() {
		super();
	}
	
	public Graduate(String name, String studentNum, String mager, int studentYear, int score, String type, double rate) {
		super(name, studentNum, mager, studentYear, score);
		this.type = type;
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate(double rate) {
		if(this.type.equals("교육")) {
			this.rate = rate;
			return this.rate;
		} else {
			
			return 0.0;
		}
		
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Graduate [type=" + type + ", rate=" + this.getRate(rate) + ", getName()=" + getName() + ", getStudentNum()="
				+ getStudentNum() + ", getMager()=" + getMager() + ", getStudentYear()=" + getStudentYear()
				+ ", getScore()=" + getScore() + "]";
	}
	
	
}
