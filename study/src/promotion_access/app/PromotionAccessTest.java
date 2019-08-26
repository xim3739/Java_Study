package promotion_access.app;

public class PromotionAccessTest {

	public static void main(String[] args) {
		Child child = new Child();
		
		Parent parent = child;
		
		parent.method1();
		parent.method2();
		//parent.method3();
	}

}
