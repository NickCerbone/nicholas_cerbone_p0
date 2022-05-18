package dao;

import exceptions.SystemException;
import model.UserPojo;

public interface UserDao {
	UserPojo register(UserPojo userPojo) throws SystemException;

	UserPojo validateUser(UserPojo userPojo) throws SystemException;

	int getDbUserId(String getPassword) throws SystemException;
}
