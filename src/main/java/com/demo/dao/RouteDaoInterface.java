package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Route;

public interface RouteDaoInterface extends JpaRepository<Route, Integer>{

}
