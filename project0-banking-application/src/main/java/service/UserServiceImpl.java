package service;

import dao.UserDao;
import dao.UserDaoDatabaseImpl;
import exceptions.RegistrationException;
import model.UserPojo;

public class UserServiceImpl implements UserService {

	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoDatabaseImpl();
	}

	@Override
	public UserPojo register(UserPojo userPojo) {
		return userDao.register(userPojo);

	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws RegistrationException {
		return userDao.validateUser(userPojo);

	}

	@Override
	public int getDbUserId(String getPassword) {
		return userDao.getDbUserId(getPassword);
	}
}
