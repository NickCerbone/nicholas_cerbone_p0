package model;

public class UserPojo {

	private int userId;
	private String password;
	
	public UserPojo() {	
	}

	public UserPojo(int userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", password=" + password + "]";
	}
}
	