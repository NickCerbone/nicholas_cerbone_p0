package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.FundsException;
import exceptions.SystemException;
import model.AccountPojo;

public class AccountDaoDatabaseImpl implements AccountDao {

	AccountPojo accountPojo;

	@Override
	public AccountPojo depositFunds(AccountPojo accountPojo, int userId) throws SystemException {
		Connection conn;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE accnt_details SET balance=balance+'" + accountPojo.getDepositAmount()
					+ "' WHERE user_id='" + userId + "' ";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public AccountPojo withdrawFunds(AccountPojo accountPojo, int userId) throws FundsException, SystemException {
		Connection conn;

		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE accnt_details SET balance=balance-'" + accountPojo.getWithdrawAmount()
					+ "' WHERE user_id='" + userId + "' AND '" + accountPojo.getWithdrawAmount() + "' <=balance";
			int rowsAffected = stmt.executeUpdate(query);
			if (rowsAffected == 0) {
				FundsException fe = new FundsException();
				throw fe;
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}

	@Override
	public double viewBalance(int userId) throws SystemException {
		Connection conn = null;
		double accountPojo = 0.00;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT balance FROM accnt_details WHERE user_id='" + userId + "'";
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				accountPojo = resultSet.getDouble(1);
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return accountPojo;
	}

}
	