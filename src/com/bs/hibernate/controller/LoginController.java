package com.bs.hibernate.controller;

import java.util.Scanner;

import com.bs.hibernate.dao.UserDAO;

public class LoginController {
	public static String login() {
		UserDAO userDAO = new UserDAO();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username");
		String username = sc.nextLine();
		System.out.println("Enter pass");
		String pass = sc.nextLine();
		String role = userDAO.login(username, pass);
		return role != null ? role : "not in system";

	}
}
