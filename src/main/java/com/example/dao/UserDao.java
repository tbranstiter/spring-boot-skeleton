package com.example.dao;

import java.util.List;

import com.example.dto.User;

public interface UserDao {
	List<User> getAllUsers();
	
	void save(User user);
	
	User getUser(long id);

	void update(User user);
}
