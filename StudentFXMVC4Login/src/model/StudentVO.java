package model;

public class StudentVO {
	
	private int no;
	private String name;
	private String level;
	private String ban;
	private String gender;
	private int korean;
	private int english;
	private int math;
	private int sic;
	private int soc;
	private int music;
	private int total;
	private double avg;
	private String register;
	private String filename;
	
	public StudentVO() {
		// TODO Auto-generated constructor stub
	}

	public StudentVO(int no, String name, String level, String ban, String gender, int korean, int english, int math,
			int sic, int soc, int music, int total, double avg) {
		super();
		this.no = no;
		this.name = name;
		this.level = level;
		this.ban = ban;
		this.gender = gender;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sic = sic;
		this.soc = soc;
		this.music = music;
		this.total = total;
		this.avg = avg;
	}

	public StudentVO(String name, String level, String ban, String gender, int korean, int english, int math, int sic,
			int soc, int music, int total, double avg) {
		super();
		this.name = name;
		this.level = level;
		this.ban = ban;
		this.gender = gender;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sic = sic;
		this.soc = soc;
		this.music = music;
		this.total = total;
		this.avg = avg;
	}

	public StudentVO(int no, String name, String level, String ban, String gender, int korean, int english, int math,
			int sic, int soc, int music, int total, double avg, String register, String filename) {
		super();
		this.no = no;
		this.name = name;
		this.level = level;
		this.ban = ban;
		this.gender = gender;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sic = sic;
		this.soc = soc;
		this.music = music;
		this.total = total;
		this.avg = avg;
		this.register = register;
		this.filename = filename;
	} // end of get StudentVO()

	public StudentVO(String name, String level, String ban, String gender, int korean, int english, int math, int sic,
			int soc, int music, int total, double avg, String register, String filename) {
		super();
		this.name = name;
		this.level = level;
		this.ban = ban;
		this.gender = gender;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.sic = sic;
		this.soc = soc;
		this.music = music;
		this.total = total;
		this.avg = avg;
		this.register = register;
		this.filename = filename;
	} // end of set StudnetVO()
	
	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getBan() {
		return ban;
	}

	public void setBan(String ban) {
		this.ban = ban;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getSic() {
		return sic;
	}

	public void setSic(int sic) {
		this.sic = sic;
	}

	public int getSoc() {
		return soc;
	}

	public void setSoc(int soc) {
		this.soc = soc;
	}

	public int getMusic() {
		return music;
	}

	public void setMusic(int music) {
		this.music = music;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
