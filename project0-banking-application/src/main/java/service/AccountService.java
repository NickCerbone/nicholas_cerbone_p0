package service;

import model.AccountPojo;

public interface AccountService {

	AccountPojo depositFunds(AccountPojo accountPojo, int userId); // Update
	
	AccountPojo withdrawFunds(AccountPojo accountPojo, int userId); // Update

	double viewBalance(int userId); // Read

}
