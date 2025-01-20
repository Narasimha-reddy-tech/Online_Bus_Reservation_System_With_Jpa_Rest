package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Feedback;
import com.demo.model.Route;
import com.demo.service.FeedbackServiceInterface;

@RestController
@RequestMapping ("/feedback")
public class FeedbackController {

	@Autowired
	private FeedbackServiceInterface service;
	
	//1. handling add Feedback
	 
			@PostMapping ("/add")         // http://localhost:2020/feedback/add
			  public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback){
				Feedback fedAdd=  service.addFeedBack(feedback);
				return new ResponseEntity<Feedback>(fedAdd, HttpStatus.CREATED);
			  }
			
			//2. handling update
			
			@PutMapping  ("/update")     // http://localhost:2020/feedback/update
			public ResponseEntity<Feedback> updateFeedback(@RequestBody Feedback feedback){
				
				Feedback fedUpd =service.updateFeedBack(feedback);
				return new ResponseEntity<Feedback>(fedUpd, HttpStatus.CREATED);
			}
			
			
			
			//3. handle view Feedback
			
			@GetMapping   ("/view/{id}")       // http://localhost:2020/feedback/view/id
			public ResponseEntity<Feedback> viewFeedback(@PathVariable ("id") int feedbackId){
				Feedback fedView =service.viewFeedBack(feedbackId);
				return new ResponseEntity<Feedback>(fedView, HttpStatus.OK);
			}
			
			
			//4. handle viewAll Feedback
			
			@GetMapping  ("/viewall")        // http://localhost:2020/feedback/viewall
			public ResponseEntity<List<Feedback>> viewAllFeedback(){
			List<Feedback> fedViewAll=	service.viewAllFeedBack();
			return new ResponseEntity<List<Feedback>>(fedViewAll, HttpStatus.OK);
			}
	
}
