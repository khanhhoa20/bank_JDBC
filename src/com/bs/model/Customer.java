package com.bs.model;

import java.util.Date;

public class Customer extends User {
	private Long customerId;
	private String customerName;
	private String customerAddress;
	private String customerPhone;
	private String customerEmail;
	private Long customerNationalId;
	private Date customerDob;
	private User user;

	public Customer() {

	}

	public Customer(Long customerId, String customerName, String customerAddress, String customerPhone,
			String customerEmail, Long customerNationalId, Date customerDob) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerNationalId = customerNationalId;
		this.customerDob = customerDob;
	}

	public Customer(Long customerId, String customerName, String customerAddress, String customerPhone,
			String customerEmail, Long customerNationalId, Date customerDob, User user) {

		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerNationalId = customerNationalId;
		this.customerDob = customerDob;
		this.user = user;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerNationalId() {
		return customerNationalId;
	}

	public void setCustomerNationalId(Long customerNationalId) {
		this.customerNationalId = customerNationalId;
	}

	public Date getCustomerDob() {
		return customerDob;
	}

	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
