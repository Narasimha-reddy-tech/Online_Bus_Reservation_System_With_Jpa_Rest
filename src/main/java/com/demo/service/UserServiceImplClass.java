package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Exceptions.UserNotFoundException;
import com.demo.dao.UserDaoInterface;
import com.demo.model.User;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImplClass implements UserServiceInterface{

	@Autowired
	private UserDaoInterface dao;
	
	@Override
	public User addUser(User user) {
		
		return dao.save(user);
	}

	@Override
	public User updateUser(User user) {
		
		if(!dao.existsById(user.getUserId())) {
			throw new UserNotFoundException("user :"+user.getUserId()+"not found");
		}
		
		return dao.save(user);
	}

	@Override
	public User deleteUser(int userId) {
	Optional<User>userdel=	dao.findById(userId);
	if(userdel.isPresent()) {
		dao.deleteById(userId);
		return userdel.get();
	}
	else {
		return null;
	}
	}

	@Override
	public User viewUser(int userId) {
	 Optional<User>user=   dao.findById(userId);
	User viewuse= user.get();
	
	if(user.isEmpty()) {
		throw new UserNotFoundException("user :"+userId+"not found");
	}
		return viewuse;
	}

	@Override
	public List<User> viewAllUsers() {
	
		return dao.findAll();
	}

}
