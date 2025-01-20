package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Bus;
import com.demo.model.User;
import com.demo.service.BusServiceInterface;

import jakarta.validation.Valid;


@RestController
@RequestMapping  ("/bus")
@Validated
public class BusController {

	@Autowired
	private BusServiceInterface service;
	
	//1. handling add Bus
	 
	@PostMapping ("/add")         // http://localhost:2020/bus/add
	  public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus){
		Bus busAdd=  service.addBus(bus);
		return new ResponseEntity<Bus>(busAdd, HttpStatus.CREATED);
	  }
	
	//2. handling update
	
	@PutMapping  ("/update")     // http://localhost:2020/bus/update
	public ResponseEntity<Bus> updateBus ( @Valid @RequestBody Bus bus){
		Bus busUpd =service.updateBus(bus);
		return new ResponseEntity<Bus>(busUpd, HttpStatus.CREATED);
	}
	
	//3. handle delete
	
	@DeleteMapping   ("/del/{id}")     // http://localhost:2020/bus/del/id
	public ResponseEntity<Bus>  deleteBus(@PathVariable ("id") int busId){
		Bus busDel =service.deleteBus(busId);
		return new ResponseEntity<Bus>(busDel, HttpStatus.OK);
	}
	
	//4. handle view Bus
	
	@GetMapping   ("/view/{id}")       // http://localhost:2020/bus/view/id
	public ResponseEntity<Bus> viewBus(@PathVariable ("id") int busId){
		Bus busView =service.viewBus(busId);
		return new ResponseEntity<Bus>(busView, HttpStatus.OK);
	}
	
	
	//5. handle viewBusByType
	
	@GetMapping  ("/viewtype")            //http://localhost:2020/bus/viewtype
	public ResponseEntity<List<Bus>> viewBusByType (@RequestParam String busType){
	List<Bus>busViewByType=	service.viewBusByType(busType);
		return new ResponseEntity<List<Bus>>(busViewByType, HttpStatus.OK);
		
	}
	
	
	//6. handle viewAll Bus
	
	@GetMapping  ("/viewall")        // http://localhost:2020/bus/viewall
	public ResponseEntity<List<Bus>> viewAllBus(){
	List<Bus> busViewAll=	service.viewAllBus();
	return new ResponseEntity<List<Bus>>(busViewAll, HttpStatus.OK);
	}
}
