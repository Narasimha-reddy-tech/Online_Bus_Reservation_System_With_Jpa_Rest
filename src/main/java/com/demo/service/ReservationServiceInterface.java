package com.demo.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.demo.model.Reservation;

public interface ReservationServiceInterface {

Reservation	addReservation(Reservation reservation);
Reservation updateReservation(Reservation reservation);
Reservation deleteReservation(int reservationId);
Reservation viewReservation(int reservationId);
 List<Reservation>   viewAllReservation();
 List<Reservation>   findByReservationDate(Date reservationDate);
}
