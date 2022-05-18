package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import exceptions.SystemException;
import model.UserPojo;

public class UserDaoDatabaseImpl implements UserDao {

	@Override
	public UserPojo register(UserPojo userPojo) throws SystemException {
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO user_details(password) VALUES ('" + userPojo.getPassword()
					+ "'); INSERT INTO accnt_details (user_id) SELECT user_id FROM user_details WHERE password='"
					+ userPojo.getPassword() + "'";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new SystemException();
		}
		return userPojo;

	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) throws SystemException {
		Connection conn;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_details WHERE user_id=" + userPojo.getUserId() + " and password='"
					+ userPojo.getPassword() + "'";
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				System.out.println("Logging in ...");
			} else {
				userPojo = null;
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return userPojo;
	}

	public int getDbUserId(String getPassword) throws SystemException {
		Connection conn = null;
		int userPojo = 0;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT user_id FROM user_details WHERE password='" + getPassword + "'";
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				userPojo = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return userPojo;
	}

}
