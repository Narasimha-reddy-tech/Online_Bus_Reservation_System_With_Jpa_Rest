package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Feedback;

public interface FeedbackDaoInterface extends JpaRepository<Feedback, Integer>{

}
