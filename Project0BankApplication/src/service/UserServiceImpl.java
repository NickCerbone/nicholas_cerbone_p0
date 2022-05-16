package service;

import java.util.List;
import dao.UserDao;
import dao.UserDaoCollectionImpl;
import model.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	public UserServiceImpl() {
		userDao = new UserDaoCollectionImpl();
	}

	@Override
	public UserPojo register(UserPojo userPojo) {
		return userDao.register(userPojo);

	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) {
		// TODO Auto-generated method stub
		return null;
	}
}
