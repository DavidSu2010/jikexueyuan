package com.bs.mall.entity;

public class Users {
	private String username;
	private Role role;
	private String password;

	public Users() {

	}

	public Users(String username, Role role, String password) {
		this.setRole(role);
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
