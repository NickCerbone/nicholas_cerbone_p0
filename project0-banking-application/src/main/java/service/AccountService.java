package service;

import model.AccountPojo;

public interface AccountService {

	AccountPojo depositFunds(int userId, double depositAmount); // Update
	
	AccountPojo withdrawFunds(int userId, double withdrawAmount); // Update

	double viewBalance(int userId); // Read

	public int getDbUserId(String getPassword);
}
