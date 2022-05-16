package service;

import java.util.List;

import exception.EmptyAccountException;
import model.AccountPojo;

public interface AccountService {

	AccountPojo updateAccount(AccountPojo accountPojo); // Update

	List<AccountPojo> getAllAccount()throws EmptyAccountException; // Read

	AccountPojo getAAccount(int accntId); // Read
	
	
}
