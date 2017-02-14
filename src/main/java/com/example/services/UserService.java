package com.example.services;

import java.util.List;

import com.example.dto.User;

public interface UserService {
	List<User> getAllUsers();
	
	User getUser(long id);
	
	void save(User user);
}
