package com.usher.pojo.main;

import com.usher.pojo.User;

public class Main {
	public static void main(String[] args) {
		User u1 = new User();
		u1.setFirstName("pooja");
		
		User u2 = new User();
		u2.setLastName("dang");

		System.out.println(u1.toString());
		System.out.println(u2.toString());
	}
}
