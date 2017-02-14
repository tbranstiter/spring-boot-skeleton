package com.example.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserDao;
import com.example.dto.User;
import com.example.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") long id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		this.userService.save(user);
		return "User successfully created with id = " + user.getId() + " and username = " + user.getUsername();
	}
	//
}
