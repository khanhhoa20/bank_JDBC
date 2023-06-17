package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.model.User;
import com.bs.util.DBUtil;


public class UserDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public UserDAO() {
		connection = DBUtil.getConnection();
	}

	public String login(String username, String password) {
		String role = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection.prepareStatement(IUserQuery.SELECT_QUERY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				role = resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return role;
	}

	public boolean addUser(String username, String password, String role) {
		boolean resultAdd = false;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection.prepareStatement(IUserQuery.INSERT_QUERY);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, role);
			result = preparedStatement.executeUpdate();
			if (result > 0) {
				resultAdd = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return resultAdd;
	}

	public User findUser(String username) {
		User user = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(IUserQuery.FIND_USER);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return user;
	}
}
