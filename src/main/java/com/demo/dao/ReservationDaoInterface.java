package com.demo.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Reservation;
import java.util.Date;




//@Repository
public interface ReservationDaoInterface extends JpaRepository<Reservation, Integer>{

	
	 List<Reservation>   findByReservationDate(Date reservationDate);
}
