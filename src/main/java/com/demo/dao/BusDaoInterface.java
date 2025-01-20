package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Bus;


public interface BusDaoInterface extends JpaRepository<Bus, Integer>{

	List<Bus>	viewBusByType(String busType);
}
