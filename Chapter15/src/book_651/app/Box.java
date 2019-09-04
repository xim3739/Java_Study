package book_651.app;

public class Box<T,U> {
	private T data;
	private U data2;
	
	public Box(T data, U data2) {
		super();
		this.data = data;
		this.data2 = data2;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public U getData2() {
		return data2;
	}
	public void setData2(U data2) {
		this.data2 = data2;
	}
	
	
}
