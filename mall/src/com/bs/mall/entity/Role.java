package com.bs.mall.entity;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Integer id;
	private String roles;
	private Set<Users> userses = new HashSet<Users>();

	public Role() {

	}

	public Role(String roles, Set<Users> userses) {
		this.setRoles(roles);
		this.setUserses(userses);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Set<Users> getUserses() {
		return userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
