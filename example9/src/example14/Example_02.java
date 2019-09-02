package example14;

public class Example_02 {
	public static void main(String args[ ]) {
		String str = "By doubting we come at the truth";
		
		String[] splitStr = str.split(" ");
		
		for(int i = 0; i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
		
		}
}
