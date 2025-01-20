package com.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Admin {

	@Id
	private int adminId;
	private String adminUsername;
	private String adminPassword;
	
	
	
	
}
