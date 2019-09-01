package example10;

public class MyClass {
	private int a;
	protected int b;
	int c;
	
	class MyInner {
		int d;
		public void m() {
			a = 10;
			b = 10;
			c = 10;
			d = 10;
		}
	}
}
