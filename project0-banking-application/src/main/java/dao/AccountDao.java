package dao;

import exceptions.FundsException;
import exceptions.SystemException;
import model.AccountPojo;

public interface AccountDao {

	AccountPojo depositFunds(AccountPojo accountPojo, int userId) throws SystemException; // Update

	AccountPojo withdrawFunds(AccountPojo accountPojo, int userId) throws FundsException, SystemException; // Update

	double viewBalance(int userId) throws SystemException; // Read

}
