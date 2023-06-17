package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.CustomerDAO;
import com.bs.dao.LockBankAccountDAO;


public class LockBankAccountController {
	public static void lockBankAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter phone number to lock");
		String phone = sc.nextLine();
		CustomerDAO customerDAO = new CustomerDAO();
		if (customerDAO.findCustomerID(phone) == null) {
			System.out.println("Phone number is not in the system");
		} else {
			LockBankAccountDAO lockDAO = new LockBankAccountDAO();
			if (lockDAO.lockBankAccount(phone)) {
				System.out.println("Locked this account successfully");
			} else {
				System.out.println("Something wrong. Fail to lock this account");
			}
		}
	}
}
