package model;

public class Login_VO {
	private String id;
	private String pw;
	
	public Login_VO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	public Login_VO() {
		super();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
}
