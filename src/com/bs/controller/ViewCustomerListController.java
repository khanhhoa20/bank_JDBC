package com.bs.controller;

import java.util.List;

import com.bs.dao.CustomerDAO;
import com.bs.model.Customer;


public class ViewCustomerListController {
	public static void viewCusList() {
		System.out.println("List of customer:");
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> list = customerDAO.getAllCustomers();
		if (!list.isEmpty()) {
			System.out.format("%-30s%-22s%-22s%-22s%-22s%-15s\n", "Customer Name", "Phone", "National Id",
					"Date of birth", "Email", "Address");
			list.stream().forEach(cus -> {
				System.out.format("%-30s%-22s%-22s%-22s%-22s%-15s\n", cus.getCustomerName(), cus.getCustomerPhone(),
						cus.getCustomerNationalId(), cus.getCustomerDob(), cus.getCustomerEmail(),
						cus.getCustomerAddress());
			});
			System.out.println();
		}else {
			System.out.println("Empty list");
		}

	}
}
