package model;

public class AccountPojo {

	private int accntId;
	private int userId;
	private double balance;
	private double depositAmount;
	private double withdrawAmount;

	public AccountPojo() {
	}

	public AccountPojo(int accntId, int userId, double balance) {
		super();
		this.accntId = accntId;
		this.userId = userId;
		this.balance = balance;
	}

	public AccountPojo(int userId) {
	}

	public AccountPojo(double balance) {
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

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	@Override
	public String toString() {
		return "AccountPojo [accntId=" + accntId + ", userId=" + userId + ", balance=" + balance + ", depositAmount="
				+ depositAmount + ", withdrawAmount=" + withdrawAmount + "]";
	}

}