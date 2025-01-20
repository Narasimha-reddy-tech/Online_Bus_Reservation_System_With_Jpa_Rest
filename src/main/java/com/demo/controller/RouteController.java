package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Reservation;
import com.demo.model.Route;
import com.demo.service.RouteServiceInterface;

@RestController 
@RequestMapping ("/route")
public class RouteController {

	@Autowired
	private RouteServiceInterface service;
	
     
	//1. handling add route
	 
		@PostMapping ("/add")         // http://localhost:2020/route/add
		  public ResponseEntity<Route> addRoute(@RequestBody Route route){
			Route rouAdd=  service.addRoute(route);
			return new ResponseEntity<Route>(rouAdd, HttpStatus.CREATED);
		  }
		
		//2. handling update
		
		@PutMapping  ("/update")     // http://localhost:2020/route/update
		public ResponseEntity<Route> updateRoute(@RequestBody Route route){
			
			Route rouUpd =service.updateRoute(route);
			return new ResponseEntity<Route>(rouUpd, HttpStatus.CREATED);
		}
		
		//3. handle delete
		
		@DeleteMapping   ("/del/{id}")     // http://localhost:2020/route/del/id
		public ResponseEntity<Route>  deleteRoute(@PathVariable ("id") int routeId){
			Route rouDel =service.deleteRoute(routeId);
			return new ResponseEntity<Route>(rouDel, HttpStatus.OK);
		}
		
		//4. handle view Route
		
		@GetMapping   ("/view/{id}")       // http://localhost:2020/route/view/id
		public ResponseEntity<Route> viewRoute(@PathVariable ("id") int routeId){
			Route rouView =service.viewRoute(routeId);
			return new ResponseEntity<Route>(rouView, HttpStatus.OK);
		}
		
		
		//5. handle viewAll Route
		
		@GetMapping  ("/viewall")        // http://localhost:2020/route/viewall
		public ResponseEntity<List<Route>> viewAllRoute(){
		List<Route> rouViewAll=	service.viewAllRoute();
		return new ResponseEntity<List<Route>>(rouViewAll, HttpStatus.OK);
		}
}
