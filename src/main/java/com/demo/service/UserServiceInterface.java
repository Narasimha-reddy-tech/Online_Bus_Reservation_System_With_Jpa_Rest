package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserServiceInterface {

	User  addUser(User user);
	User  updateUser(User user);
	User  deleteUser(int userId);
	User  viewUser(int userId);
	List<User> viewAllUsers();
}
