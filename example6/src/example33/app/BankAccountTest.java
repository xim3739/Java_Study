package example33.app;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount seoBank = new BankAccount();
		seoBank.setName("seo");
		seoBank.setAccountNum("110-332-123441");
		seoBank.setMoney(30000);
		seoBank.setInteresRate(3.2);
		System.out.println(seoBank);
		
		BankAccount ximBank = new BankAccount("xim", "110-304-131268", 50000, 3.7);
		System.out.println(ximBank);

	}

}
