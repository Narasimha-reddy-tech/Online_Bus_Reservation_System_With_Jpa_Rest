package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Exceptions.BusNotFoundException;
import com.demo.dao.BusDaoInterface;
import com.demo.model.Bus;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BusServiceImplClass implements BusServiceInterface{

	@Autowired
	private BusDaoInterface dao;
	
	@Override
	public Bus addBus(Bus bus) {
		
		return dao.save(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		
		if(!dao.existsById(bus.getBusId())) {
			throw new BusNotFoundException("Bus :"+bus.getBusId()+"not found");
		}
	
		return dao.save(bus);
	}

	@Override
	public Bus deleteBus(int busId) {
	Optional<Bus>bus= dao.findById(busId);
	
	if(bus.isPresent()) {
		dao.deleteById(busId);
		return bus.get();
	}
	else {
		return null;
	}
         

	}

	@Override
	public Bus viewBus(int busId) {
	Optional<Bus> bus=	dao.findById(busId);
	Bus viewBus=bus.get();
	
	if(bus.isEmpty()) {
		throw new BusNotFoundException("Bus :"+busId+"not found");
	}
		return viewBus;
	}

	@Override
	public List<Bus> viewBusByType(String busType) {
		   
		return dao.viewBusByType(busType);
	}

	@Override
	public List<Bus> viewAllBus() {
		
		return dao.findAll();
	}

}
