package book_comparable;

public class MyClass <T> implements Comparable<T> {
	
	private int num;
	private String name;
	
	public MyClass(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	@Override
	public int compareTo(T t) {
		MyClass mc = null;
		if(t instanceof MyClass) {
			mc = (MyClass)t;
		}
		if(this.num > mc.num) {
			return 1;
		} else if(this.num < mc.num) {
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

	@Override
	public String toString() {
		return "MyClass [num=" + num + ", name=" + name + "]";
	}
	
	
	
}
