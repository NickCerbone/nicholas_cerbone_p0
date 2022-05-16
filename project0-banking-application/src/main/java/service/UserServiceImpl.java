package service;

import dao.UserDao;
import dao.UserDaoDatabaseImpl;
import model.UserPojo;

public class UserServiceImpl implements UserService {
	
	// interface reference
	UserDao userDao;

	public UserServiceImpl() {
		//userDao = new UserDaoCollectionImpl();
		userDao = new UserDaoDatabaseImpl();
	}

	@Override
	public UserPojo register(UserPojo userPojo) {
		return userDao.register(userPojo);

	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) {
		return userDao.validateUser(userPojo);
	}
}
