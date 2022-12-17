package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Route;
import com.travelzilla.repositories.RouteDAO;


@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private RouteDAO erepo;

	@Override
	public Route registerRoute(Route route) throws RouteException {
		// TODO Auto-generated method stub
        if(route !=null) {
			
        	Route route1 =erepo.save(route);
			return route1;
		}else {
			throw new RouteException("Customer is null ");
		}
	}

	@Override
	public Route getRouteById(Integer routeID) throws RouteException {
		
        Optional<Route> em=erepo.findById(routeID);
		
		if(em.isPresent()) {
			Route cus1= em.get();
			return cus1;
		}else {
			throw new RouteException("Route Not Found.");
		}
	}

	@Override
	public List<Route> getAllRouteDetails() throws RouteException {
          List<Route> list= erepo.findAll();
		
		if(list.size()==0) {
			throw new RouteException(" no Route ");
		}else {
			return list;
		}
	}

	@Override
	public Route deleteRouteById(Integer routeId) throws RouteException {
        Optional<Route> em=erepo.findById(routeId);
		
		if(em.isPresent()) {
			Route cus1= em.get();
			erepo.delete(cus1);
			
			return cus1;
		}else {
			throw new RouteException("Route deleted.");
		}
	}

}
