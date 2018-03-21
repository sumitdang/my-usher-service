package com.usher.pojo;

import java.util.List;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private List<Integer> shopIds;
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getShopIds() {
		return shopIds;
	}

	public void setShopIds(List<Integer> shopIds) {
		this.shopIds = shopIds;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("firstName : ").append(this.firstName).append("\n");
		sb.append("lastName : ").append(this.lastName).append("\n");
		sb.append("email : ").append(this.email).append("\n");
		return sb.toString();
	}

}
