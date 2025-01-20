package com.demo.model;

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
@Table (name="User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id
	private int userId;
	@NotBlank (message = "username can't be empty")
	private String username;
	@NotBlank (message = "password can't be empty")
	private String password;
	@NotBlank (message = "firstname can't be empty")
	private String firstName;
	@NotBlank (message = "lastname can't be empty")
	private String lastName;
	@NotBlank (message = "contact can't be empty")
	private String contact;
	@NotBlank (message = "email can't be empty")
	private String email;
	
	@OneToOne (cascade = CascadeType.ALL)
   private Reservation reservation;              // has a relation


   
   
   
   
}
