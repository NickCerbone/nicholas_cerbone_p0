package dao;

import java.util.List;
import model.UserPojo;

public interface UserDao {
	UserPojo register(UserPojo userPojo); // throws ApplicationException;
	UserPojo validateUser(UserPojo userPojo); //throws ApplicationException;
}

