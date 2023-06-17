package com.bs.hibernate.controller;

import java.util.List;

import com.bs.hibernate.dao.CustomerDAO;
import com.bs.hibernate.model.Customer;

public class ViewCustomerListController {
	public static void viewCustomerList() {
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> list = customerDAO.getAllCustomer();
		list.stream().forEach(cus -> {
			System.out.format("%-30s%-22s%-22s%-22s%-22s%-15s\n", cus.getCustomerName(), cus.getCustomerPhone(),
					cus.getCustomerNationalId(), cus.getCustomerDob(), cus.getCustomerEmail(),
					cus.getCustomerAddress());
		});
	}
}
