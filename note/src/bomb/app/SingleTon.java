package bomb.app;

public class SingleTon {
	private static SingleTon singleTon = new SingleTon();
	
	static {
		singleTon = new SingleTon();
	}
	
	private SingleTon() {
		super();
	}
	
	public static SingleTon getInstance() {
		if(singleTon == null) {
			singleTon = new SingleTon();
		}
		
		return singleTon;
	}
}
