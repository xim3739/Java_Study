package Example_14;

public class Example_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cardName = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cardNum = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		int cardOfName = 0;
		int cardOfNum = 0;
		
		cardOfName = (int)(Math.random() * 4);
		cardOfNum = (int)(Math.random() * 13);
		
		for(int i = 0; i < cardName.length; i++) {
			if(i == cardOfName) {
				System.out.print(cardName[i] + " of ");
			}
		}
		for(int i = 0; i < cardNum.length; i++) {
			if(i == cardOfNum) {
				System.out.println(cardNum[i]);
			}
		}
	}

}
