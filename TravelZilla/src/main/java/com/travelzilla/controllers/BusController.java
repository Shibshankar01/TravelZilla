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
public class BusController {
	
	
	@Autowired
	private BusService cont;
	
	@Autowired
	SessionServices service;
	
	
	@PostMapping("/AddBus")
	public ResponseEntity<Bus> registerBusHandler(@Valid  @RequestBody Bus bus ,@RequestParam("sessionKey") String key) throws BusException, SessionException{
		
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Bus bus1= cont.registerBus(bus);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
		
	}
	
	
	
	@PostMapping("/Addbus/{Route_Id}/{Travel_Id}")
	public ResponseEntity<Bus> RegisterBusWithRoute_idANDTravels_id(@Valid  @PathVariable("Route_Id") Integer routeId,@PathVariable("Travel_Id") Integer travelId,@RequestBody Bus bus ,@RequestParam("sessionKey") String key)throws BusException, RouteException, TravelsException, SessionException{

		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Bus bus1= cont.RegisterBusWithRoute_idANDTravels_id(routeId, travelId, bus);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
	}
	
	@GetMapping("/GetBus/{Bus_Id}")
	public ResponseEntity<Bus> getBusByIdHandler(@Valid  @PathVariable("Bus_Id") Integer busID ,@RequestParam("sessionKey") String key) throws BusException, SessionException{

		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Bus bus1= cont.getBusById(busID);
			return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	
	@GetMapping("/GetAllBuses")
	public ResponseEntity<List<Bus>> getAllBusDetailsHandler(@Valid  @RequestParam("sessionKey") String key) throws BusException, SessionException{

		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			List<Bus> bus1= cont.getAllBusDetails();
			return new ResponseEntity<List<Bus>>(bus1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	
//	@DeleteMapping("/bus/{id}")
//	public ResponseEntity<Bus> deleteBusByIdHandler(@Valid  @PathVariable("id") Integer busId ,@RequestParam("sessionKey") String key) throws BusException{
//		
//	Session session= service.getASessionByKey(key);
//	if(session.getUserType()==UserType.ADMIN) {
//		
//	Bus bus1= cont.deleteBusById(busId);
//	System.out.println(bus1);
//	return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
//		
//	}else {
//		throw new SessionException("Please Enter Correct Key..!");
//	}
//	
//		
//	}

}
