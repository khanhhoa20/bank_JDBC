package com.bs.controller;

import java.util.Scanner;

import com.bs.dao.UserDAO;


public class AddUserController {
	public static void addUser() {
		UserDAO dao = new UserDAO();
		System.out.println("Enter name");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("Enter password");
		String pass = sc.nextLine();
		System.out.println("Enter role");
		String role = sc.nextLine();
		boolean result = dao.addUser(name, pass, role);

		if (result) {
			System.out.println("add user success");
		} else {
			System.out.println("sth wrong");
		}
	}
}
