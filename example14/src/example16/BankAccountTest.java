package example16;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount myBank = new BankAccount(10000);
		myBank.withdraw(3000);
		myBank.withdraw(12000);
	}

}
