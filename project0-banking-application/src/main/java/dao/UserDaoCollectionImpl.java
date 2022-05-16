//package dao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import model.UserPojo;
//
//public class UserDaoCollectionImpl implements UserDao {
//
//List<UserPojo> allUser = new ArrayList<UserPojo>();
//	
//	public UserDaoCollectionImpl() {
//		UserPojo user1 = new UserPojo (156, "expass1");
//		allUser.add(user1);	
//	}
//	
//
//	@Override
//	public UserPojo register(UserPojo userPojo) {
//		int newUserId = allUser.get(allUser.size()-1).getUserId() + 1;
//		userPojo.setUserId(newUserId);
//		allUser.add(userPojo);
//		return userPojo;
//	}
//
//	@Override
//	public UserPojo validateUser(UserPojo userPojo) {
//		// TODO Auto-generated method stub
//		return null;
//	}	
//}
