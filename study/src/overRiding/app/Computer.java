package overRiding.app;

public class Computer extends Calculator{
	@Override
	double areaCircle(int r) {
		System.out.println("com areaCircle");
			return Math.PI * r * r;
		}
}
