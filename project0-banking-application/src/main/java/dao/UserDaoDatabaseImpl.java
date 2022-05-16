package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.AccountPojo;
import model.UserPojo;

public class UserDaoDatabaseImpl implements UserDao {

	@Override
	public UserPojo register(UserPojo userPojo) {
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO user_details(password) VALUES ('" + userPojo.getPassword() + "'); INSERT INTO accnt_details (user_id) SELECT user_id FROM user_details WHERE password='" + userPojo.getPassword() +"'";
			
			// clean this up
			// exceptions 
			// progate throws
			// junit testing mockito
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				AccountPojo accountPojo = new AccountPojo(rs.getInt(1), rs.getInt(4), rs.getDouble(5));
			System.out.println(accountPojo);
			}
			}
			catch (SQLException e) {
			e.printStackTrace();
		}
		return userPojo;
		
	}

	@Override
	public UserPojo validateUser(UserPojo userPojo) {
		Connection conn;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM user_details WHERE user_id=" + userPojo.getUserId() + " and password='"
					+ userPojo.getPassword() + "'";
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				System.out.println("user validated successfully");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userPojo;
	}

}
