package bank;

public class WThread implements Runnable {
	private Account account;
	String name;
	
	public WThread() {}
	
	public WThread(Account account,String name) {
		this.account = account;
		this.name = name;
	}
	
	@Override
	public void run() {
		while(account.getBalance() > 0 ) {
			int money = (int)(Math.random()*3+1)*100;
			account.withdraw(money);
			System.out.println(name+" withdraw : "+money);
			System.out.println(name+": "+account);
		}
	}

}






