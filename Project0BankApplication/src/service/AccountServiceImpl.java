package service;

import java.util.List;

import dao.AccountDao;
import dao.AccountDaoCollectionImpl;
import exception.EmptyAccountException;
import model.AccountPojo;


public class AccountServiceImpl implements AccountService {
	
	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoCollectionImpl();
	}

	@Override
	public AccountPojo updateAccount(AccountPojo accountPojo) {
		return accountDao.updateAccount(accountPojo);
	}

	@Override
	public List<AccountPojo> getAllAccount() throws EmptyAccountException {
		return accountDao.getAllAccount();
	}

	@Override
	public AccountPojo getAAccount(int accntId) {
		return accountDao.getAAccount(accntId);
	}

	

}
