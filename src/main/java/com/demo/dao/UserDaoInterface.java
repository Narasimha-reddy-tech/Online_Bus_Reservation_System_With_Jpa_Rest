package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.User;

public interface UserDaoInterface extends JpaRepository<User, Integer>{

}
