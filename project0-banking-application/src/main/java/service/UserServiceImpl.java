package service;

import dao.UserDao;
import dao.UserDaoDatabaseImpl;
import exceptions.SystemException;
import model.UserPojo;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoDatabaseImpl();
	}

	@Override
	public UserPojo register(UserPojo userPojo) throws SystemException {
		return userDao.register(userPojo);

	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws SystemException {
		return userDao.validateUser(userPojo);

	}

	@Override
	public int getDbUserId(String getPassword) throws SystemException {
		return userDao.getDbUserId(getPassword);
	}
}
