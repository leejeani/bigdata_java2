package bank;

public class Account {
	private int balance;
	public Account() {}
	public Account(int balance) {
		this.balance = balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}
	
	public synchronized void deposit(int money) {
		if(money > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance += money;
		}
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
}
