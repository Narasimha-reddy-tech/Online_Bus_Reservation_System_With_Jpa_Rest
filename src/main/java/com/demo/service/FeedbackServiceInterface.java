package com.demo.service;

import java.util.List;

import com.demo.model.Feedback;

public interface FeedbackServiceInterface {

	Feedback  addFeedBack(Feedback feedback);
	Feedback   updateFeedBack(Feedback feedback);
	Feedback   viewFeedBack(int feedbackId);
	List<Feedback> viewAllFeedBack();	
}
