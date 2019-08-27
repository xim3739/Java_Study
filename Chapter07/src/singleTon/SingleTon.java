package singleTon;

public class SingleTon {
	
	private String str = "집에가자";
	
	private static SingleTon singleTon;
	
	/*
	static {
		singleTon = new SingleTon();
	}
	*/
	
	private SingleTon() {
		super();
	}
	
	public static SingleTon getSingleTon() {
		if(singleTon == null) {
			singleTon = new SingleTon();
		}
		
		return singleTon;
	}
	
	public void print() {
		System.out.println("집에 갈래.....");
		System.out.println("보내줘....");
		System.out.println("부탁이야....");
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
	
}
