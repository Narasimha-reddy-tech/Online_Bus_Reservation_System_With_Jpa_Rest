package com.demo.service;

import java.util.List;

import com.demo.model.Route;

public interface RouteServiceInterface {

	Route addRoute(Route route);
	Route updateRoute(Route route);
	Route deleteRoute(int routeId);
	Route viewRoute(int routeId);
	List<Route> viewAllRoute();
	
}
