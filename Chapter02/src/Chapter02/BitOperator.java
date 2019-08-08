package Chapter02;

public class BitOperator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 0x0fff;
		int y = 0xfff0;

		System.out.printf("%x \n", (x & y));
		System.out.printf("%x \n", (x | y));
		System.out.printf("%x \n", (x ^ y));
		System.out.printf("%x \n", ~x);
		System.out.printf("%x \n", (x << 4));
		System.out.printf("%x \n", (x >> 4));
		System.out.printf("%x \n", (-1 >>> y));
		
	}

}
