package com.travelzilla.service;

import java.util.List;

import com.travelzilla.Exception.RouteException;
import com.travelzilla.models.Route;

public interface RouteService {
	
	public Route  registerRoute(Route route)throws RouteException;
	public Route getRouteById(Integer route)throws RouteException;
	public List<Route>  getAllRouteDetails()throws RouteException;
	public  Route deleteRouteById(Integer routeId)throws RouteException;

}
