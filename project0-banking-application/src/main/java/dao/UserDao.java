package dao;

import exceptions.RegistrationException;
import model.UserPojo;

public interface UserDao {
	UserPojo register(UserPojo userPojo); 
	UserPojo validateUser(UserPojo userPojo) throws RegistrationException; 
	public int getDbUserId(String getPassword);
}

