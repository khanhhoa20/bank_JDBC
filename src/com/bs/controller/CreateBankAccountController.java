package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bs.dao.BankAccountDAO;
import com.bs.dao.CustomerDAO;
import com.bs.dao.UserDAO;
import com.bs.model.BankAccount;
import com.bs.model.Customer;
import com.bs.model.User;


public class CreateBankAccountController {
	public static void createBankAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter customer name");
		String name = sc.nextLine();
		System.out.println("Enter customer phone");
		String phone = sc.nextLine();
		System.out.println("Enter customer national id");
		Long nationalID = Long.parseLong(sc.nextLine());
		System.out.println("Enter customer date of birth(dd/mm/yyyy)");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = null;
		try {
			dob = format.parse(sc.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter customer email");
		String email = sc.nextLine();
		System.out.println("Enter customer address");
		String address = sc.nextLine();

		Customer customer = new Customer(null, name, address, phone, email, nationalID, dob, null);
		customer.setUserName(phone);
		// default password
		customer.setUserPass("123");

		UserDAO userDAO = new UserDAO();
		boolean createUserResult = userDAO.addUser(customer.getUserName(), customer.getUserPass(), "customer");
		if (createUserResult) {
			User user = userDAO.findUser(customer.getUserName());
			if (user != null) {
				customer.setUser(user);
				CustomerDAO customerDAO = new CustomerDAO();
				int createCustomerResult = customerDAO.addCustomer(customer);
				if (createCustomerResult > 0) {
					BankAccountDAO bankAccountDAO = new BankAccountDAO();
					Long cusID = customerDAO.findCustomerID(customer.getCustomerPhone()).getCustomerId();
					// default bank name is "bank"
					BankAccount bankAccount = new BankAccount(null, 0l, "bank", cusID);
					int result = bankAccountDAO.createBankAccount(bankAccount);
					if (result > 0) {
						System.out.println("Create bank account successfully");
					} else {
						System.out.println("Something wrong. Fail to create bank account");
					}
				} else {
					System.out.println("Something wrong. Cannot create customer account. Fail to create bank account");
				}
			}
		} else {
			System.out.println("Something wrong. Cannot create user account. Fail to create bank account");
		}
	}
}
