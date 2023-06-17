package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.UserDAO;


public class LoginController {
	public static String login() {
		UserDAO userDAO = new UserDAO();
		// phone number by default
		System.out.println("Enter username");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		// default: 123
		System.out.println("Enter password");
		String pass = sc.nextLine();
		String role = userDAO.login(name, pass);
		if (role != null) {
			System.out.println("Login success. Welcome " + name + ", role: " + role);
		} else {
			System.out.println("Login failed");
		}
		return role;
	}
}
