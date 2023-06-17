package com.bs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bs.dao.CustomerDAO;
import com.bs.model.Customer;


public class UpdateCustomerController {
	public static void updateCustomer() {
		CustomerDAO customerDAO = new CustomerDAO();
		System.out.println("Enter customer phone");
		Scanner sc = new Scanner(System.in);
		String phone = sc.nextLine();
		Customer customer = customerDAO.findCustomerID(phone);
		if (customer == null) {
			System.out.println("Do not have this phone number in the system");
			return;
		}
			
		System.out.println("Enter updated date of birth(dd/mm/yyyy)");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date dob = null;
		try {
			dob = format.parse(sc.nextLine());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("Enter updated email");
		String email = sc.nextLine();
		System.out.println("Enter updated address");
		String address = sc.nextLine();

		customer.setCustomerAddress(address);
		customer.setCustomerDob(dob);
		customer.setCustomerEmail(email);
		int result = customerDAO.updateCustomer(customer);
		if (result > 0) {
			System.out.println("Update customer information successfully");
		} else {
			System.out.println("Something wrong. Fail to update customer information");
		}
	}
}
