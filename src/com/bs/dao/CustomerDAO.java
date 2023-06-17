package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bs.model.Customer;
import com.bs.util.DBUtil;


public class CustomerDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	int result;

	public CustomerDAO() {
		connection = DBUtil.getConnection();
	}

	public int addCustomer(Customer customer) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.INSERT_QUERY);

			preparedStatement.setString(1, customer.getCustomerName());
			preparedStatement.setString(2, customer.getCustomerPhone());
			preparedStatement.setLong(3, customer.getCustomerNationalId());
			preparedStatement.setDate(4, new java.sql.Date(customer.getCustomerDob().getTime()));
			preparedStatement.setString(5, customer.getCustomerEmail());
			preparedStatement.setString(6, customer.getCustomerAddress());
			preparedStatement.setLong(7, customer.getUser().getUserID());

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public Customer findCustomerID(String phone) {
		Customer customer = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.FIND_CUSTOMER);
			preparedStatement.setString(1, phone);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customer = new Customer();
				customer.setCustomerId(resultSet.getLong(1));
				customer.setCustomerPhone(resultSet.getString(3));
				customer.setCustomerName(resultSet.getString(2));
				customer.setCustomerNationalId(resultSet.getLong(4));
				customer.setCustomerDob(resultSet.getDate(5));
				customer.setCustomerEmail(resultSet.getString(6));
				customer.setCustomerAddress(resultSet.getString(7));
				customer.setUserID(resultSet.getLong(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return customer;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<>();
		Customer customer = null;
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}
			preparedStatement = connection.prepareStatement(ICustomerQuery.GET_ALL_CUSTOMERS);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				customer = new Customer(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(7),
						resultSet.getString(3), resultSet.getString(6), resultSet.getLong(4), resultSet.getDate(5));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int updateCustomer(Customer customer) {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.UPDATE_CUSTOMER);
			preparedStatement.setDate(1, new java.sql.Date(customer.getCustomerDob().getTime()));
			preparedStatement.setString(2, customer.getCustomerEmail());
			preparedStatement.setString(3, customer.getCustomerAddress());
			preparedStatement.setString(4, customer.getCustomerPhone());

			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return result;
	}

	public String checkLock(String phone) {
		String lock = "none";
		try {
			if (connection == null || connection.isClosed()) {
				connection = DBUtil.getConnection();
			}

			preparedStatement = connection.prepareStatement(ICustomerQuery.CHECK_LOCK);
			preparedStatement.setString(1, phone);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				lock = resultSet.getString(1);
			}
//			System.out.println("1" + lock);
			if (lock ==null)
				lock = "none";
//			System.out.println("2" + lock);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return lock;
	}

}
