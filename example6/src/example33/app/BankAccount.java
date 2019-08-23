package example33.app;

public class BankAccount {
	private String name;
	private String accountNum;
	private int money;
	private double interesRate;
	
	public BankAccount() {
		this(null, null, 0, 0.0);
	}
	public BankAccount(String name, String accountNum, int money, double interesRate) {
		this.name = name;
		this.accountNum = accountNum;
		this.money = money;
		this.interesRate = interesRate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public double getInteresRate() {
		return interesRate;
	}
	public void setInteresRate(double interesRate) {
		this.interesRate = interesRate;
	}
	@Override
	public String toString() {
		return "BankAccount [name=" + name + ", accountNum=" + accountNum + ", money=" + money + ", interesRate="
				+ interesRate + "]";
	}
	
	
}
