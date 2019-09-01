package toBinary.app;

public class ToBinaryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num = 0;
		String strResult = "null";
		
		for(int i = 0; i < 10; i++) {
			
			num =(int) (Math.random() * 100 + 101);
			strResult = changeBinary(num);
			System.out.println(num + " to binary is " + strResult);
			
		}
		
	}
	
	public static String changeBinary(int num) {
		
		String strResult = "null";
		
		strResult = Integer.toBinaryString(num);
		
		while(strResult.length() < 32) {
			strResult = "0" + strResult;
		}
		
		return strResult;
	}
	
}