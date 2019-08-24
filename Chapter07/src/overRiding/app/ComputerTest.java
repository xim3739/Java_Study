package overRiding.app;

public class ComputerTest {

	public static void main(String[] args) {
		int r = 10;
		Calculator calculator = new Calculator();
		System.out.println("circle area : " + calculator.areaCircle(r));
		
		Computer computer = new Computer();
		System.out.println("circle area : " + computer.areaCircle(r));

	}

}
