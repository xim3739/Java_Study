package model;

public class Input_emp_VO {

	// 필드선언
	private String e_no; // 사원번호
	private String e_name; // 사원이름
	private String age; // 생년월일
	private String phone; // 전화번호
	private String spot; // 직급
	private String pw; // 비밀번호
	private String st_no; // 매장코드
	private String mag; // 담당 매니저
	private int sal; // 월급
	private String sales_date; // 입사일_판매날짜(날짜형)

	// 생성자
	public Input_emp_VO(String e_no, String e_name, String age, String phone, String spot, String pw, String st_no,
			String mag, int sal, String sales_date) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.age = age;
		this.phone = phone;
		this.spot = spot;
		this.pw = pw;
		this.st_no = st_no;
		this.mag = mag;
		this.sal = sal;
		this.sales_date = sales_date;
	}

	public Input_emp_VO() {
		super();
	}

	public Input_emp_VO(String e_no, String e_name, String age, String phone, String spot, String pw, String st_no,
			String mag, String sales_date) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.age = age;
		this.phone = phone;
		this.spot = spot;
		this.pw = pw;
		this.st_no = st_no;
		this.mag = mag;
		this.sales_date = sales_date;
	}

	public Input_emp_VO(String e_no, String e_name, String age, String phone, String spot, String pw, String st_no,
			String mag, int sal) {
		super();
		this.e_no = e_no;
		this.e_name = e_name;
		this.age = age;
		this.phone = phone;
		this.spot = spot;
		this.pw = pw;
		this.st_no = st_no;
		this.mag = mag;
		this.sal = sal;
	}

	// getter,setter
	public String getE_no() {
		return e_no;
	}

	public void setE_no(String e_no) {
		this.e_no = e_no;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSpot() {
		return spot;
	}

	public void setSpot(String spot) {
		this.spot = spot;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSt_no() {
		return st_no;
	}

	public void setSt_no(String st_no) {
		this.st_no = st_no;
	}

	public String getMag() {
		return mag;
	}

	public void setMag(String mag) {
		this.mag = mag;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getSales_date() {
		return sales_date;
	}

	public void setSales_date(String sales_date) {
		this.sales_date = sales_date;
	}

	public Input_emp_VO(String e_name) {
		super();
		this.e_name = e_name;
	}

	public Input_emp_VO(String e_name, String age, String phone) {
		super();
		this.e_name = e_name;
		this.age = age;
		this.phone = phone;
	}

}
