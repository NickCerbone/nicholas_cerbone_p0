package dao;

import exceptions.FundsException;
import model.AccountPojo;

public interface AccountDao {

	AccountPojo depositFunds(AccountPojo accountPojo, int userId); // Update
	
	AccountPojo withdrawFunds(AccountPojo accountPojo, int userId) throws FundsException; // Update

	double viewBalance(int userId); // Read
	
	
}
