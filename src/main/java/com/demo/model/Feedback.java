package com.demo.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="Feedback")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Feedback {

	@Id
	private int feedbackId;
	@Min (value = 0,message = "driver rating can't be negative")
	private int driverRating;
	@Min (value = 0,message = "service rating can't be negative")
	private int serviceRating;
	@Min (value = 0,message = "overall rating can't be negative")
	private int overallRating;
	private String comments;
	private Date feedbackDate;
	
	@OneToOne (cascade = CascadeType.ALL)
	private User user;         // has a relation
	
	
	@OneToOne (cascade = CascadeType.ALL)
	private Bus bus;           // has a relation
	
	
	
	
	
	
}
