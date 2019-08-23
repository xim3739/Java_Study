package innerClass.app;

import innerClass.app.OuterClass.InnerClass1;

public class OuterClassTest {

	public static void main(String[] args) {
		OuterClass.InnerClass1 inner1 = new InnerClass1();
		inner1.myMethod1();
		OuterClass outerClass = new OuterClass(29,"xim",1106);
		OuterClass.InnerClass2 inner2 = outerClass.new InnerClass2();
		inner2.myMethod2();
	}

}
