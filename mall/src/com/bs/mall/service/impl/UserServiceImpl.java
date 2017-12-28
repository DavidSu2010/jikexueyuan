package com.bs.mall.service.impl;

import java.util.List;

import com.bs.mall.dao.UserDao;
import com.bs.mall.entity.Role;
import com.bs.mall.entity.Users;
import com.bs.mall.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public Users login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.getUserByNameAndPassword(username, password);
	}

	@Override
	public List<Users> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.findAllPaging(currentPage, pageSize);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return userDao.getTotal();
	}

	@Override
	public Users getUserByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getUserByName(name);
	}

	@Override
	public void saveOrUpdate(Users user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public Role getRoleByName(String name) {
		// TODO Auto-generated method stub
		return userDao.getRoleByName(name);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		userDao.save(role);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
