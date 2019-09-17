package example08;

import java.io.Serializable;

public class MyClass implements Serializable{
	private int no;
	private String name;
	private String num;
	private String eMail;
	
	public MyClass(int no, String name, String num, String eMail) {
		super();
		this.no = no;
		this.name = name;
		this.num = num;
		this.eMail = eMail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	
	@Override
	public String toString() {
		return "MyClass [no=" + no + ", name=" + name + ", num=" + num + ", eMail=" + eMail + "]";
	}

	
	
	
	
}
