package com.demo.Exceptions;

public class BusNotFoundException extends RuntimeException{

	public BusNotFoundException (String message) {
		super(message);
	}
}
