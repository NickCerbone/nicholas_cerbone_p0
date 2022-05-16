package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import exception.EmptyAccountException;
import model.AccountPojo;

public class AccountDaoCollectionImpl implements AccountDao{

	List<AccountPojo> allAccount = new ArrayList<AccountPojo>();
	
	public AccountDaoCollectionImpl() {
		AccountPojo bankInfo1 = new AccountPojo (1, 1, 500.00);
		AccountPojo bankInfo2 = new AccountPojo (2, 2, 600.00);
		AccountPojo bankInfo3= new AccountPojo (3, 3, 700.00);
		allAccount.add(bankInfo1);
		allAccount.add(bankInfo2);
		allAccount.add(bankInfo3);
	}

	@Override
	public AccountPojo updateAccount(AccountPojo accountPojo) {
		for(int i=0;i<allAccount.size();i++) {
			if(allAccount.get(i).getAccntId() == accountPojo.getAccntId()) {
				allAccount.set(i, accountPojo); 
				break;
			}
		}
		return accountPojo;
	}

	@Override
	public List<AccountPojo> getAllAccount() throws EmptyAccountException {
		if(allAccount.isEmpty()) {
			EmptyAccountException ese = new EmptyAccountException();
			throw ese;
		}
		return allAccount;
	}

	@Override
	public AccountPojo getAAccount(int accntId) {
		AccountPojo foundProduct = null;
		for(int i=0;i<allAccount.size();i++) {
			if(allAccount.get(i).getAccntId() == accntId) {
				foundProduct = allAccount.get(i); // when match found , assign the found reference variable to foundProduct
				break;
			}
		}
		return foundProduct;
	}


	
}
