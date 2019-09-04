package example14;

public class MyExceptionTest {

	public static void main(String[] args) {
		try {
			checkNegative(1);
			checkNegative(-1);
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	public static void checkNegative(int number) throws MyException {
		if(number < 0) {
			System.err.println(new MyException("negative number"));
		} else {
			System.out.println("not negative number");	
		}
		
	}

}
