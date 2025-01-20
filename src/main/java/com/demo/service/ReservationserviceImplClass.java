package com.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Exceptions.ReservationNotFoundException;
import com.demo.dao.ReservationDaoInterface;
import com.demo.model.Reservation;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReservationserviceImplClass implements ReservationServiceInterface{

	@Autowired
	private ReservationDaoInterface dao;
	
	@Override
	public Reservation addReservation(Reservation reservation) {
	
		return dao.save(reservation);
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		
		if(!dao.existsById(reservation.getReservationId())) {
			throw new ReservationNotFoundException("reservation:"+reservation.getReservationId()+"not found");
		}
	
		return dao.save(reservation);
	}

	@Override
	public Reservation deleteReservation(int reservationId) {
	   Optional<Reservation>reserve= dao.findById(reservationId);
		if(reserve.isPresent()) {
			dao.deleteById(reservationId);
			return reserve.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Reservation viewReservation(int reservationId) {
		Optional<Reservation>res= dao.findById(reservationId);
		    Reservation viewRes=   res.get();
		    
		    if(res.isEmpty()) {
		    	throw new ReservationNotFoundException("reservation :"+reservationId+"not found");
		    }
		return viewRes;
	}

	@Override
	public List<Reservation> viewAllReservation() {
		
		return dao.findAll();
	}

	@Override
	public List<Reservation>  findByReservationDate(Date reservationDate) {
		List<Reservation>getAll=dao.findByReservationDate(reservationDate);
		return getAll;
		
	}

}
