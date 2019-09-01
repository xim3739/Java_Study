package example05;

interface A {
	public float mA(int a);
}

interface B extends A {
	public int mB(int a);
	public Object mBB(int a);
}

class C {
	public void mC(int a) {
		System.out.println("HI");
	}
}

public class MyClass extends C implements B{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float mA(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int mB(int a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object mBB(int a) {
		// TODO Auto-generated method stub
		return null;
	}

}
