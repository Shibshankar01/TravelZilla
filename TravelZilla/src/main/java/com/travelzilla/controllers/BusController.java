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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Route;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.BusService;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/Bus")
public class BusController {
	
	
	@Autowired
	private BusService busservice;
	
	@Autowired
	SessionServices service;
	
//	Register New Bus .
	@PostMapping("/Register")
	public ResponseEntity<Bus> registerBusHandler(@Valid  @RequestBody Bus bus ,@RequestParam("sessionKey") String key) throws BusException, SessionException{
		
		Session session= service.getASessionByKey(key);
//		authentication	
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function
			Bus bus1= busservice.registerBus(bus);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
		
	}
	
	
// Register Bus Along with Existing Travels and route.
	@PostMapping("/RegisterWithIds/{Route_Id}/{Travel_Id}")
	public ResponseEntity<Bus> RegisterBusWithRoute_idANDTravels_id(@Valid  @PathVariable("Route_Id") Integer routeId,@PathVariable("Travel_Id") Integer travelId,@RequestBody Bus bus ,@RequestParam("sessionKey") String key)throws BusException, RouteException, TravelsException, SessionException{

		Session session= service.getASessionByKey(key);
//		authentication	
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function
			Bus bus1= busservice.RegisterBusWithRoute_idANDTravels_id(routeId, travelId, bus);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
	
	}
	
//	Search Bus by id.
	@GetMapping("/GetById/{Bus_Id}")
	public ResponseEntity<Bus> getBusByIdHandler(@Valid  @PathVariable("Bus_Id") Integer busID ,@RequestParam("sessionKey") String key) throws BusException, SessionException{

		Session session= service.getASessionByKey(key);
//		authentication	
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function
			Bus bus1= busservice.getBusById(busID);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	
//	Get all Buses.
	@GetMapping("/GetAll")
	public ResponseEntity<List<Bus>> getAllBusDetailsHandler(@Valid  @RequestParam("sessionKey") String key) throws BusException, SessionException{

		Session session= service.getASessionByKey(key);
//		authentication	
		if(session.getUserType()==UserType.ADMIN) {
//			Main Function
			List<Bus> bus1= busservice.getAllBusDetails();
			return new ResponseEntity<List<Bus>>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	
}
