package protected_pacage2.app;

import protected_pacage.app.A;

public class D extends A {
	public D() {
		super();
		this.field = "value";
		this.method();
	}
	public void method() {
		this.field = "value";
		this.method();
	}
}
