package com.travelzilla.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Route;
import com.travelzilla.services.RouteService;

@RestController
public class RouteController {
	
	@Autowired
	private RouteService cont;
	
	@PostMapping("/route")
	public ResponseEntity<Route> registerRouteHandler(@RequestBody Route route) throws RouteException{
		
		Route route1= cont.registerRoute(route);
		return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/route/{id}")
	public ResponseEntity<Route> getRouteByIdHandler(@PathVariable("id") Integer routeID) throws RouteException{
		Route route1= cont.getRouteById(routeID);
		return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
	}
	
	@GetMapping("/routes")
	public ResponseEntity<List<Route>> getAllRouteDetails() throws RouteException{
		
		List<Route> route1= cont.getAllRouteDetails();
		return new ResponseEntity<List<Route>>(route1, HttpStatus.CREATED);
	}
//	
//	@DeleteMapping("/route/{id}")
//	public ResponseEntity<Route> deleteRouteByIdHandler(@PathVariable("id") Integer routeId) throws RouteException{
//		
//		Route route1= cont.deleteRouteById(routeId);
//		return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
//		
//	}
//	
//	
//	@PutMapping("/route")
//	public ResponseEntity<Route> modifyRoute(@RequestBody Route route) throws RouteException{
//		
//		Route route1= cont.modifyRoute(route);
//		return new ResponseEntity<Route>(route1, HttpStatus.OK);
//		
//	}

}
