package generic.compare;

public class MyClass <T> implements Comparable<T>{
	
	private int num;
	private String name;
	
	public MyClass(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	@Override
	public int compareTo(T o) {
		MyClass myClass = null;
		if(o instanceof MyClass) {
			myClass = (MyClass)o;
		}
		if(this.num > myClass.num) {
			return 1;
		} else if (this.num < myClass.num) {
			return -1;
		} else {
			return 0;	
		}
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
