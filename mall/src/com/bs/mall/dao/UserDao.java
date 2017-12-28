package com.bs.mall.dao;

import java.util.List;

import org.apache.catalina.User;

import com.bs.mall.entity.Role;
import com.bs.mall.entity.Users;

public interface UserDao {

	void save(Users user);
	
	Users getUserByName(String name);
	
	Users getUserByNameAndPassword(String name,String password);
	
	List<Users> findAllPaging(int currentPage,int pageSize);
	
	int getTotal();
	
	void save(Role role);
	
	Role getRoleByName(String name);
}
