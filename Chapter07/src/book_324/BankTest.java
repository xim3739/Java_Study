package book_324;

class Bank {
	double getInterestRate() {
		return 0.0;
	}
}

class BadBank extends Bank {
	double getInterestRate() {
		return 10.0;
	}
}

class NomalBank extends Bank {
	double getInterestRate() {
		return 5.0;
	}
}

class GoodBank extends Bank {
	double getInterestRate() {
		return 3.0;
	}
}

public class BankTest {

	public static void main(String[] args) {
		BadBank badBank = new BadBank();
		NomalBank nomalBank = new NomalBank();
		GoodBank goodBank = new GoodBank();
		
		System.out.println("Bad Bank InterestRate : " + badBank.getInterestRate());
		System.out.println("Nomal Bank InterestRate : " + nomalBank.getInterestRate());
		System.out.println("Good Bank InterestRate : " + goodBank.getInterestRate());

	}

}
