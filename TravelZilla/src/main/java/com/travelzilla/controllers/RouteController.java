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
public class RouteController {
	
	@Autowired
	private RouteService cont;
	
	@Autowired
	SessionServices service;
	
	@PostMapping("/AddRoute")
	public ResponseEntity<Route> registerRouteHandler(@Valid  @RequestBody Route route,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
		
		if(session.getUserType()==UserType.ADMIN) {
			Route route1= cont.registerRoute(route);
			return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
	}
	
	
	
	@GetMapping("/Route/{Route_id}")
	public ResponseEntity<Route> getRouteByIdHandler(@Valid  @PathVariable("Route_id") Integer routeID ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Route route1= cont.getRouteById(routeID);
			return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
	
	}
	
	@GetMapping("/GetAllRoutes")
	public ResponseEntity<List<Route>> getAllRouteDetails(@Valid  @RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			List<Route> route1= cont.getAllRouteDetails();
			return new ResponseEntity<List<Route>>(route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		

	}
	

	
	
	@GetMapping("/GetPackagesFromRoute_From_To/{Routefrom}/{Routeto}")
	public ResponseEntity<List<Packages>> getAllRouteByFrom_To(@Valid  @PathVariable("Routefrom") String from,@PathVariable("Routeto") String to ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			List<Packages> route1= cont.getAllRouteByFrom_To(from, to);
			return new ResponseEntity<List<Packages>> (route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
	
	}

	
	@GetMapping("/GetPackagesFromRoute_From/{Routefrom}")
	public ResponseEntity<List<Packages>> getAllRouteByFrom(@Valid  @PathVariable("Routefrom") String from ,@RequestParam("sessionKey") String key) throws RouteException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			List<Packages> route1= cont.getAllRouteByFrom(from);
			return new ResponseEntity<List<Packages>> (route1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
	
	}
	
	
//	
//	@DeleteMapping("/route/{id}")
//	public ResponseEntity<Route> deleteRouteByIdHandler(@Valid  @PathVariable("id") Integer routeId ,@RequestParam("sessionKey") String key) throws RouteException{
//	Session session= service.getASessionByKey(key);
//	if(session.getUserType()==UserType.ADMIN) {
	
//		Route route1= cont.deleteRouteById(routeId);
//	return new ResponseEntity<Route>(route1, HttpStatus.CREATED);
//		
//	}else {
//		throw new SessionException("Please Enter Correct Key..!");
//	}
//		
//		
//	}
//	
//	
//	@PutMapping("/route")
//	public ResponseEntity<Route> modifyRoute(@Valid  @RequestBody Route route ,@RequestParam("sessionKey") String key) throws RouteException{
//		
//	Session session= service.getASessionByKey(key);
//	if(session.getUserType()==UserType.ADMIN) {
//			Route route1= cont.modifyRoute(route);
//	return new ResponseEntity<Route>(route1, HttpStatus.OK);
//		
//	}else {
//		throw new SessionException("Please Enter Correct Key..!");
//	}
//	
//		
//	}

}
