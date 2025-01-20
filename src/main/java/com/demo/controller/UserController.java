package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Route;
import com.demo.model.User;
import com.demo.service.UserServiceInterface;

import jakarta.validation.Valid;


@RestController
@RequestMapping ("/user")
@Validated
public class UserController {

	@Autowired
      private UserServiceInterface service;
      
	//1. handling add User
	 
			@PostMapping ("/add")         // http://localhost:2020/user/add
			  public ResponseEntity<User> addUser(@Valid @RequestBody User user){
				User useAdd=  service.addUser(user);
				return new ResponseEntity<User>(useAdd, HttpStatus.CREATED);
			  }
			
			//2. handling update
			
			@PutMapping  ("/update")     // http://localhost:2020/user/update
			public ResponseEntity<User> updateUser(@Valid @RequestBody User user){
				
				User useUpd =service.updateUser(user);
				return new ResponseEntity<User>(useUpd, HttpStatus.CREATED);
			}
			
			//3. handle delete
			
			@DeleteMapping   ("/del/{id}")     // http://localhost:2020/user/del/id
			public ResponseEntity<User>  deleteUser(@PathVariable ("id") int userId){
				User useDel =service.deleteUser(userId);
				return new ResponseEntity<User>(useDel, HttpStatus.OK);
			}
			
			//4. handle view User
			
			@GetMapping   ("/view/{id}")       // http://localhost:2020/user/view/id
			public ResponseEntity<User> viewUser(@PathVariable ("id") int userId){
				User useView =service.viewUser(userId);
				return new ResponseEntity<User>(useView, HttpStatus.OK);
			}
			
			
			//5. handle viewAll User
			
			@GetMapping  ("/viewall")        // http://localhost:2020/user/viewall
			public ResponseEntity<List<User>> viewAllUser(){
			List<User> useViewAll=	service.viewAllUsers();
			return new ResponseEntity<List<User>>(useViewAll, HttpStatus.OK);
			}
}
