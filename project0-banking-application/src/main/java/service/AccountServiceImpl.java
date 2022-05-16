package service;

import dao.AccountDao;
import dao.AccountDaoDatabaseImpl;
import model.AccountPojo;


public class AccountServiceImpl implements AccountService {
	
	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}
	
	public int getDbUserId(String getPassword) {
		return accountDao.getDbUserId(getPassword);
	}

	@Override
	public AccountPojo depositFunds(int userId, double depositAmount) {
		return accountDao.depositFunds(userId, depositAmount);
	}

	@Override
	public AccountPojo withdrawFunds(int userId, double withdrawAmount) {
		return accountDao.withdrawFunds(userId, withdrawAmount);
	}

	@Override
	public double viewBalance(int userId) {
		return accountDao.viewBalance(userId);
	}
}
