package com.example.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.User;
import com.example.services.UserService;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {
	
	@Autowired private UserService userService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable("id") long id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String createUser(@RequestBody User user) {
		this.userService.save(user);
		return "User successfully created with id = " + user.getId() + " and username = " + user.getUsername();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String updateUser(@PathVariable("id") long id, @RequestBody User user) {		
		User currentUser = this.userService.getUserById(id);
		if (currentUser == null) {
			return "Unable to update user with id " + id;
		}
		currentUser.setUsername(user.getUsername());
		currentUser.setPassword(user.getPassword());
		
		this.userService.updateUser(currentUser);
		return "User " + user.getUsername() + " has been successfully updated";
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") long id) {
		User user = this.userService.getUserById(id);
		if (user == null) {
			return "Unable to delete user with id " + id;
		}
		this.userService.deleteUserById(id);
		return "User successfully delete with id = " + id;
	}
	
}
