package stringClass.app;

import java.util.Scanner;

public class StringClassTest {

	public static void main(String[] args) {
		String str=null;
	      Scanner scan = new Scanner(System.in);
	      
	      System.out.print("사이트를 입력하세요 :");
	      str=scan.nextLine();
	      if(str.equals("quit")) {
	         System.exit(0);
	         
	      }else if (str.matches("^www\\.(.+)$")){
	         System.out.println("첫단어를 www.로 입력하셨습니다.");
	         
	      }else
	         System.out.println("첫단어를 www.~정신차려요");
	}

}
