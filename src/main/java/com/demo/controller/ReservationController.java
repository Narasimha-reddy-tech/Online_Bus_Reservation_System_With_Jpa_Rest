package com.demo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Reservation;
import com.demo.service.ReservationServiceInterface;

import jakarta.validation.Valid;


@RestController 
@RequestMapping ("/reserve")
@Validated
public class ReservationController {

	@Autowired
	public ReservationServiceInterface service;
	
	//1. handling add reservation
	 
	@PostMapping ("/add")         // http://localhost:2020/reserve/add
	  public ResponseEntity<Reservation> addReservation(@Valid @RequestBody Reservation reservation){
		Reservation revAdd=  service.addReservation(reservation);
		return new ResponseEntity<Reservation>(revAdd, HttpStatus.CREATED);
	  }
	
	//2. handling update
	
	@PutMapping  ("/update")     // http://localhost:2020/reserve/update
	public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody Reservation reservation){
		Reservation revUpd =service.updateReservation(reservation);
		return new ResponseEntity<Reservation>(revUpd, HttpStatus.CREATED);
	}
	
	//3. handle delete
	
	@DeleteMapping   ("/del/{id}")     // http://localhost:2020/reserve/del/id
	public ResponseEntity<Reservation>  deleteReservation(@PathVariable ("id") int reservationId){
		Reservation revDel =service.deleteReservation(reservationId);
		return new ResponseEntity<Reservation>(revDel, HttpStatus.OK);
	}
	
	//4. handle view Reservation
	
	@GetMapping   ("/view/{id}")       // http://localhost:2020/reserve/view/id
	public ResponseEntity<Reservation> viewReservation(@PathVariable ("id") int reservationId){
		Reservation revView =service.viewReservation(reservationId);
		return new ResponseEntity<Reservation>(revView, HttpStatus.OK);
	}
	
	
	//5. handle viewAll reservation
	
	@GetMapping  ("/viewall")        // http://localhost:2020/reserve/viewall
	public ResponseEntity<List<Reservation>> viewAllReservation(){
	List<Reservation> revViewAll=	service.viewAllReservation();
	return new ResponseEntity<List<Reservation>>(revViewAll, HttpStatus.OK);
	}
	
	//6. handle get all reservation with date
	
//	@GetMapping  ("/getall/{date}")
//	public ResponseEntity<List<Reservation>> getAllReservation(@PathVariable("date") LocalDate date){
//		List<Reservation> revGetAll= service.getAllReservation(date);
//		return new ResponseEntity<List<Reservation>>(revGetAll, HttpStatus.OK);
//	}
}
