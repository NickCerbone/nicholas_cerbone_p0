package dao;

import model.AccountPojo;

public interface AccountDao {

	AccountPojo depositFunds(AccountPojo accountPojo, int userId); // Update
	
	AccountPojo withdrawFunds(AccountPojo accountPojo, int userId); // Update

	double viewBalance(int userId); // Read
	
	
}
