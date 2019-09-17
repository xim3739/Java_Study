package chapter17.object;

import java.io.Serializable;

public class  Student implements Serializable{
	public String name;
	public int num;
	
	public Student(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", num=" + num + "]";
	}
	
}
