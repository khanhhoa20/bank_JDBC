package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.util.DBUtil;


public class LockBankAccountDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public LockBankAccountDAO() {
		connection = DBUtil.getConnection();
	}

	public boolean lockBankAccount(String cus_phone) {
		boolean result = false;

		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection.prepareStatement(ILockBankAccountQuery.UPDATE_LOCK_STATUS);
			preparedStatement.setString(1, cus_phone);
			result = preparedStatement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return result;
	}

}
