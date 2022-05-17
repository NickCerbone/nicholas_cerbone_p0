package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao {
	
	AccountPojo accountPojo;
	
	@Override
	public AccountPojo depositFunds(AccountPojo accountPojo, int userId) {
		Connection conn;
		try {
		conn = DBUtil.makeConnection();
		Statement stmt = conn.createStatement();
		String query = "UPDATE accnt_details SET balance=balance+'"+accountPojo.getDepositAmount()+"' WHERE user_id='"+userId+"' ";
		int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo withdrawFunds(AccountPojo accountPojo, int userId) {
		Connection conn;
		try {
		conn = DBUtil.makeConnection();
		Statement stmt = conn.createStatement();
		String query = "UPDATE accnt_details SET balance=balance-'"+accountPojo.getWithdrawAmount()+"' WHERE user_id='"+userId+"' ";
		int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}

	@Override
	public double viewBalance(int userId) {
		Connection conn = null;
		double accountPojo = 0.00;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT balance FROM accnt_details WHERE user_id='"+userId+"'";
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
			accountPojo = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accountPojo;
	}
	
}
	
	