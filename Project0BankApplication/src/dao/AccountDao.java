package dao;

import java.util.List;

import exception.EmptyAccountException;
import model.AccountPojo;

public interface AccountDao {

	AccountPojo updateAccount(AccountPojo accountPojo); // Update

	List<AccountPojo> getAllAccount()throws EmptyAccountException; // Read

	AccountPojo getAAccount(int accntId); // Read
	
	
}
