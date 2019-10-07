package model;

public class Student {
	private String name;
	private String gender;
	private String level;
	private String ban;
	private String korean;
	private String english;
	private String math;
	private String science;
	private String socity;
	private String music;
	private String total;
	private String avg;
	
	public Student() {
	
	}

	public Student(String name, String gender, String level, String ban, String korean, String english, String math,
			String science, String socity, String music, String total, String avg) {
		super();
		this.name = name;
		this.gender = gender;
		this.level = level;
		this.ban = ban;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.science = science;
		this.socity = socity;
		this.music = music;
		this.total = total;
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getKorean() {
		return korean;
	}

	public void setKorean(String korean) {
		this.korean = korean;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getScience() {
		return science;
	}

	public void setScience(String science) {
		this.science = science;
	}

	public String getSocity() {
		return socity;
	}

	public void setSocity(String socity) {
		this.socity = socity;
	}

	public String getMusic() {
		return music;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}
	
}
