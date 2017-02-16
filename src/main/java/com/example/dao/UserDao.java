package com.example.dao;

import java.util.List;

import com.example.dto.User;

public interface UserDao {
	List<User> getAllUsers();
	
	void save(User user);
	
	User getUserById(long id);

	void updateUser(User user);
	
	void deleteUserById(long id);
}
