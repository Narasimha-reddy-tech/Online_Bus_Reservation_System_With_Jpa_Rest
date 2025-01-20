package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="Bus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bus {

	@Id
	private int busId;
	@NotBlank (message="bus name can't be empty")
	private String busName;
	@NotBlank (message="driver name can't be empty")
	private String driverName;
	@NotBlank (message="bus type can't be empty")
	private String busType;
	@NotBlank (message="route from can't be empty")
	private String routeFrom;
	@NotBlank (message="route to can't be empty")
	private String routeTo;
	@NotBlank (message="arrival time can't be empty")
	private String arrivalTime;
	@NotBlank (message="departure time can't be empty")
	private String departureTime;
	@Min (value = 0,message="seats can't be negative")
	private int seats;
	@Min (value = 0,message="available seats can't be negative")
	private int availableSeats;
	private String viewBusByType;
	
	
	
	
	
	
}
