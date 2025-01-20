package com.demo.service;

import java.util.List;

import com.demo.model.Bus;

public interface BusServiceInterface {

	Bus addBus(Bus bus);
	Bus  updateBus(Bus bus);
	Bus deleteBus(int busId);
	Bus viewBus(int busId);
  List<Bus>	viewBusByType(String busType);
  List<Bus>  viewAllBus();
}
