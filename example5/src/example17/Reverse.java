package example17;

public class Reverse {
	private String str;
	
	
	public Reverse() {
		this.str = null;
		
	}
	
	public Reverse(String str) {
		this.str = str;
		
	}
	
	public String reversString() {
		
		String resultStr = null;
		for(int i = this.str.length(); i > 0; i--) {
			resultStr = resultStr + this.str.charAt(i-1);
		}	
		String result = resultStr.substring(4);
		
		return result;
	}
}
