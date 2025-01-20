package com.demo.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice 
public class GlobalExceptionHandler {
	
	//1. handling bus not found exception
	
	@ExceptionHandler (BusNotFoundException.class)
	public ResponseEntity<String> handleBusNotFoundException(BusNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}

	//2. feedback handling
	
	@ExceptionHandler (FeedBackNotFoundException.class)
	public ResponseEntity<String> handleFeedBackNotFoundException(FeedBackNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//3. reservation handling
	
	@ExceptionHandler (ReservationNotFoundException.class)
	public ResponseEntity<String> handlereservationNotFoundException(ReservationNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//4.  route handling
	
	@ExceptionHandler (RouteNotFoundException.class)
	public ResponseEntity<String> handleRouteNotFoundException(RouteNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	//5. user handling
	
	@ExceptionHandler (UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotfoundException(UserNotFoundException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
//  validation exception
	
	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
		
		Map<String,String> errors=new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			
			String fieldName=((FieldError)error).getField();
			String fieldMessage=error.getDefaultMessage();
			   errors.put(fieldName, fieldMessage);
			
		});
		
		return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
	
	
	// general exception
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<String> handleGeneralException(Exception ex){
		
		
		return new ResponseEntity<String>("Internal server error :"+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}
	
	


