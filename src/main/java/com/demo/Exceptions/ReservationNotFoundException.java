package com.demo.Exceptions;

public class ReservationNotFoundException extends RuntimeException{

	public ReservationNotFoundException(String message) {
		super(message);
	}
}
