package Study;

public class BinaryTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;
		String strBinary = null;
		
		for(int i = 0; i < 10; i++) {
			num = (int)(Math.random() * (150 - 50  + 1) + 50);
			strBinary = toBinaryString(num);
			System.out.println((i+1)+" : " + num + " = " +strBinary );
		}
	}
	
	public static String toBinaryString(int num) {
		String strResult = null;
		
		strResult = Integer.toBinaryString(num);
		
		while(strResult.length() < 16) {
			strResult = "0" + strResult;
		}
		return strResult;
	}

}
