package com.bs.dao;


interface ICustomerQuery {
	String INSERT_QUERY = "INSERT INTO customer VALUES(null,?,?,?,?,?,?,?)";
	String FIND_CUSTOMER = "SELECT * FROM customer WHERE cus_phone = ?";
	String GET_ALL_CUSTOMERS = "SELECT * FROM customer";
	String UPDATE_CUSTOMER = "UPDATE customer SET cus_date_of_birth=?,"
			+ " cus_email=?, cus_address=? WHERE cus_phone=?";
	String CHECK_LOCK = "SELECT lock_status from bank_account where "
			+ "cus_id =(SELECT id FROM customer WHERE cus_phone=?)";
}
