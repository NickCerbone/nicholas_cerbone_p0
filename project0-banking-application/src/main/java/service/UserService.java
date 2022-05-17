package service;

import exceptions.RegistrationException;
import model.UserPojo;

public interface UserService {

	UserPojo register(UserPojo userPojo); // throws ApplicationException;
	UserPojo validateUser(UserPojo userPojo) throws RegistrationException;
	public int getDbUserId(String getPassword);
}
