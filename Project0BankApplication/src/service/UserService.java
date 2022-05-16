package service;

import java.util.List;
import model.UserPojo;

public interface UserService {

	UserPojo register(UserPojo userPojo); // throws ApplicationException;
	UserPojo validateUser(UserPojo userPojo); //throws ApplicationException;
}
