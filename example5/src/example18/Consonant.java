package example18;

public class Consonant {
	private String str;
	
	public Consonant() {
		this.str = null;
	}
	public Consonant(String str) {
		this.str = str;
	}
	
	public void consonant() {
		int consonantCount = 0;
		int vowelCount = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
				consonantCount++;
			} else {
				vowelCount++;
			}
		}
		
		System.out.println("consonant is " + consonantCount);
		System.out.println("vowel is " + vowelCount);
	}
}
