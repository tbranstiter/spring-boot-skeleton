package com.example.services;

import java.util.List;

import com.example.dto.User;

public interface UserService {
	List<User> getAllUsers();
	
	User getUserById(long id);
	
	void save(User user);
	
	void deleteUserById(long id);
	
	void updateUser(User user);
}
