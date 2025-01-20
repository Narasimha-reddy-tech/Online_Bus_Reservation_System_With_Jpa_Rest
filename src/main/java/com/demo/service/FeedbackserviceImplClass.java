package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Exceptions.FeedBackNotFoundException;
import com.demo.dao.FeedbackDaoInterface;
import com.demo.model.Feedback;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class FeedbackserviceImplClass implements FeedbackServiceInterface{

	@Autowired
	private FeedbackDaoInterface dao;
	
	@Override
	public Feedback addFeedBack(Feedback feedback) {
		
		return dao.save(feedback);
	}

	@Override
	public Feedback updateFeedBack(Feedback feedback) {
		
		if(!dao.existsById(feedback.getFeedbackId())) {
			throw new FeedBackNotFoundException("feedback :"+feedback.getFeedbackId()+"not found");
		}
		
		return dao.save(feedback);
	}

	@Override
	public Feedback viewFeedBack(int feedbackId) {
	       Optional<Feedback> feed=  dao.findById(feedbackId);
	     Feedback getFeed=  feed.get();
	     
	     if(feed.isEmpty()) {
	    	 throw new FeedBackNotFoundException("feedback :"+feedbackId+"not found");
	     }
		return getFeed;
	}

	@Override
	public List<Feedback> viewAllFeedBack() {
	
		return dao.findAll();
	}

}
