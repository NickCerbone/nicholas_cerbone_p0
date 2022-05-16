package model;

public class AccountPojo {

	private int accntId;
	private int userId;
	private double balance;
	
	public AccountPojo() {
		
	}

	public AccountPojo(int accntId, int userId, double balance) {
		super();
		this.accntId = accntId;
		this.userId = userId;
		this.balance = balance;
	}

	public int getAccntId() {
		return accntId;
	}

	public void setAccntId(int accntId) {
		this.accntId = accntId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountPojo [accntId=" + accntId + ", userId=" + userId + ", balance=" + balance + "]";
	}


}
