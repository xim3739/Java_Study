package example16;

public class BankAccount {
	private int balance;
	
	public BankAccount(int balance) {
		super();
		this.balance = balance;
	}
	
	public void deposit(int deposit) {
		System.out.println("balance : " + this.balance);
		this.balance = this.balance + deposit;
		System.out.println("deposit : " + deposit);
		System.out.println("balance : " + this.balance);
	}
	public void withdraw(int withdraw) {
		System.out.println("balance : " + this.balance);
		if(this.balance > withdraw) {
			this.balance = this.balance - withdraw;
			System.out.println("withdraw : " + withdraw);
			System.out.println("balance : " + this.balance);
		} else {
			System.out.println(new MyException("NegativeBalanceException"));
		}
		
	}
	
}
