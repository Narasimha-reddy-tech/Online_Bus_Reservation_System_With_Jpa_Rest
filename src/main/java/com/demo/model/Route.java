package com.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table (name="Route")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Route {

	@Id
	private int routeId;
	@NotBlank (message = "route from can't be empty")
	private String routeFrom;
	@NotBlank (message = "route to can't be empty")
	private String routeTo;
	@NotBlank (message = "distance can't be empty")
	private double distance;
	
	@OneToMany (cascade = CascadeType.ALL)
	private List<Bus>buses;           // list of buses on this route
	
	
	
	
	
}
