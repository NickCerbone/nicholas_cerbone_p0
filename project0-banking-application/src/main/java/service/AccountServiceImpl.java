package service;

import dao.AccountDao;
import dao.AccountDaoDatabaseImpl;
import model.AccountPojo;

public class AccountServiceImpl implements AccountService {

	AccountDao accountDao;

	public AccountServiceImpl() {
		accountDao = new AccountDaoDatabaseImpl();
	}

	@Override
	public AccountPojo depositFunds(AccountPojo accountPojo, int userId) {
		return accountDao.depositFunds(accountPojo, userId);
	}

	@Override
	public AccountPojo withdrawFunds(AccountPojo accountPojo, int userId) {
		return accountDao.withdrawFunds(accountPojo, userId);
	}

	@Override
	public double viewBalance(int userId) {
		return accountDao.viewBalance(userId);
	}
}
