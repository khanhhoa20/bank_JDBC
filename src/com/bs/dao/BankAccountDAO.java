package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.model.BankAccount;
import com.bs.util.DBUtil;


public class BankAccountDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public BankAccountDAO() {
		connection = DBUtil.getConnection();
	}

	public int createBankAccount(BankAccount bankAccount) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IBankAccountQuery.INSERT_BANK_ACCOUNT);

			preparedStatement.setLong(1, bankAccount.getBalance());
			preparedStatement.setString(2, bankAccount.getBankName());
			preparedStatement.setLong(3, bankAccount.getCusId());

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return result;

	}

	public boolean widthdrawMoney(Long balance, Long money, String phone) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IBankAccountQuery.WITHDRAW_MONEY);
			preparedStatement.setLong(1, (balance - money));
			preparedStatement.setString(2, phone);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return result > 0 ? true : false;
	}
	
	public boolean depositMoney(Long balance, Long money, String phone) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IBankAccountQuery.DEPOSIT_MONEY);
			preparedStatement.setLong(1, (balance + money));
			preparedStatement.setString(2, phone);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return result > 0 ? true : false;
	}

	public Long getBalance(String phone) {
		Long balance = 0l;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IBankAccountQuery.GET_BALANCE);
			preparedStatement.setString(1, phone);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				balance = resultSet.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return balance;
	}
}
