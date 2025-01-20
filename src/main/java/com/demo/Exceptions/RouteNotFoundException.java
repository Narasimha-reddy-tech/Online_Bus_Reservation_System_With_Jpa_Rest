package com.demo.Exceptions;

public class RouteNotFoundException extends RuntimeException{

	public RouteNotFoundException(String message) {
		super(message);
	}
}
