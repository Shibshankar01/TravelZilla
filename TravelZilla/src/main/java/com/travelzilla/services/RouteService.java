package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;

public interface RouteService {
	
	public Route  registerRoute(Route route)throws RouteException;
	
	public Route getRouteById(Integer route)throws RouteException;
	
	public List<Route>  getAllRouteDetails()throws RouteException;

	public List<Packages>  getAllRouteByFrom_To(String from,String to)throws RouteException;

	public List<Packages>  getAllRouteByFrom(String from)throws RouteException;
	
	
	

}
