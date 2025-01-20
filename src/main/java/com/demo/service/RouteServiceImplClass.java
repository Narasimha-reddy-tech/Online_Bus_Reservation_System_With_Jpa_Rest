package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Exceptions.RouteNotFoundException;
import com.demo.dao.RouteDaoInterface;
import com.demo.model.Route;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RouteServiceImplClass implements RouteServiceInterface{

	@Autowired
	private RouteDaoInterface dao;
	
	@Override
	public Route addRoute(Route route) {
		
		return dao.save(route);
	}

	@Override
	public Route updateRoute(Route route) {
		
		if(!dao.existsById(route.getRouteId())) {
			throw new RouteNotFoundException("route :"+route.getRouteId()+"not found");
		}
		
		return dao.save(route);
	}

	@Override
	public Route deleteRoute(int routeId) {
	Optional<Route>delRou=	dao.findById(routeId);
	if(delRou.isPresent()) {
		dao.deleteById(routeId);
		return delRou.get();
	}
	else {
		return null;
	}
		
	}

	@Override
	public Route viewRoute(int routeId) {
		Optional<Route>  viewRou=dao.findById(routeId);
		Route rouview=viewRou.get();
		
		if(viewRou.isEmpty()) {
			throw new RouteNotFoundException("route :"+routeId+"not found");
		}
		return rouview;
	}

	@Override
	public List<Route> viewAllRoute() {
	
		return dao.findAll();
	}

}
