package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.BankAccountDAO;
import com.bs.dao.CustomerDAO;


public class WithdrawMoneyController {
	public static void withdrawMoney() {
		System.out.println("Enter customer phone");
		Scanner sc = new Scanner(System.in);
		String phone = sc.nextLine();
		CustomerDAO customerDAO = new CustomerDAO();
		BankAccountDAO bankAccountDAO = new BankAccountDAO();
		if (customerDAO.findCustomerID(phone) != null && (!customerDAO.checkLock(phone).equals("locked"))) {
//			System.out.println(customerDAO.checkLock(phone));
			Long currentBalance = bankAccountDAO.getBalance(phone);
			System.out.println("Balance: " + currentBalance + " VND");
			Long amount;
			String cont = "Y";
			do {
				System.out.println("Enter your amount");
				amount = Long.parseLong(sc.nextLine());
				if (amount > currentBalance) {
					System.out.println("Amount money to withdraw must not greater than current balance");
					System.out.println("Do you want to continue withdraw:(Y/N)");
					cont = sc.nextLine();
					if (cont.equalsIgnoreCase("N"))
						break;
				}
			} while (amount > currentBalance);
			if (cont.equalsIgnoreCase("Y")) {
				boolean result = bankAccountDAO.widthdrawMoney(currentBalance, amount, phone);
				if (result) {
					System.out.println("Withdraw successfully");
					System.out.println(
							"Current balance of " + phone + " is " + bankAccountDAO.getBalance(phone) + " VND");
				} else {
					System.out.println("Something wrong. Fail to withdraw");
				}
			}
		} else {
			if (customerDAO.findCustomerID(phone) == null)
				System.out.println("Phone does not exist in the system");
			else if (customerDAO.checkLock(phone).equals("locked")) {
				System.out.println("This bank account is locked");
			}

		}
	}
}
