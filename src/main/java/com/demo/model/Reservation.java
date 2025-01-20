package com.demo.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="Reservation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

	@Id
	private int reservationId;
	@NotBlank (message = "reservation status can't be empty")
	private String reservationStatus;
	@NotBlank (message = "reservation type can't be empty")
	private String reservationType;
	@NotBlank (message = "reservation date can't be empty")
	private Date reservationDate;
	@NotBlank (message = "reservation time can't be empty")
	private String reservationTime;
	@NotBlank (message = "source can't be empty")
	private String source;
	@NotBlank (message = "destination can't be empty")
	private String destination;
	
	@OneToOne (cascade = CascadeType.ALL)
	private Bus bus;                  // has a relation

	
	
	
	
}
