package com.jike.dao;

import java.util.List;

import com.jike.entity.Users;

public interface UsersDao {
	
    void saveUsers(Users users);
    
    List<Users> queryUsers();
    
    void deleteUsers(Users users);
}
