package service;

import exceptions.SystemException;
import model.UserPojo;

public interface UserService {

	UserPojo register(UserPojo userPojo) throws SystemException;

	UserPojo validateUser(UserPojo userPojo) throws SystemException;

	public int getDbUserId(String getPassword) throws SystemException;
}
