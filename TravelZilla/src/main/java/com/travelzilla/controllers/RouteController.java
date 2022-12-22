package com.travelzilla.controllers;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.RouteService;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/Route")
public class RouteController {
	
	@Autowired
	private RouteService routeservice;
	
	@Autowired
	SessionServices service;
	
//	Resister new Route along with bus if admin wants.
	@PostMapping("/Register")
	public ResponseEntity<Route> registerRouteHandler(@Valid  @RequestBody Route route,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		
		Session session= service.getASessionByKey(key);
//		authentication
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function calling
			Route route1= routeservice.registerRoute(route);
			return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
	}
	
	
//	Search route by id.
	@GetMapping("/GetById/{Route_id}")
	public ResponseEntity<Route> getRouteByIdHandler(@Valid  @PathVariable("Route_id") Integer routeID ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
//		authentication	
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function			Route route1= routeservice.getRouteById(routeID);
			return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
	
	}
	
//	Get all routes.
	@GetMapping("/GetAll")
	public ResponseEntity<List<Route>> getAllRouteDetails(@Valid  @RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
//		authentication
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function			List<Route> route1= routeservice.getAllRouteDetails();
			return new ResponseEntity<List<Route>>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		

	}
	

	
//	Search All packages which is associated with (destination and origin) location.
	@GetMapping("/SearchPackage/{Routefrom}/{Routeto}")
	public ResponseEntity<List<Packages>> getAllRouteByFrom_To(@Valid  @PathVariable("Routefrom") String from,@PathVariable("Routeto") String to ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
//		authentication
		Session session= service.getASessionByKey(key);
		if(session !=null) {
//			Main Function			List<Packages> route1= routeservice.getAllRouteByFrom_To(from, to);
			return new ResponseEntity<List<Packages>> (route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
	
	}

//	Search All packages which is associated with origin location.
	@GetMapping("/SearchPackageFromOrigin/{Routefrom}")
	public ResponseEntity<List<Packages>> getAllRouteByFrom(@Valid  @PathVariable("Routefrom") String from ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
//		authentication
		if(session!=null) {
//			Main Function			List<Packages> route1= routeservice.getAllRouteByFrom(from);
			return new ResponseEntity<List<Packages>> (route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
	
	}


}
