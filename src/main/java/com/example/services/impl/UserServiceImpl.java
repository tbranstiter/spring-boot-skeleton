package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.dto.User;
import com.example.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired UserDao userDao;
	
	@Override
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}
	
	@Override
	public User getUserById(long id) {
		return this.userDao.getUserById(id);
	}
	
	@Override
	public void save(User user) {
		this.userDao.save(user);
	}
	
	@Override 
	public void deleteUserById(long id) {
		this.userDao.deleteUserById(id);
	}
	
	@Override
	public void updateUser(User user) {
		this.userDao.updateUser(user);
	}
}
