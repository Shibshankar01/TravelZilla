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

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Session;
import com.travelzilla.models.Travels;
import com.travelzilla.models.TravelsDTO;
import com.travelzilla.models.UserType;
import com.travelzilla.services.SessionServices;
import com.travelzilla.services.TravelsService;

@RestController
public class TravelsController {
	@Autowired
	private TravelsService cont;

	@Autowired
	SessionServices service;
	
	
	
	@PostMapping("/Newtravels")
	public ResponseEntity<Travels> registerNewTravels(@Valid @RequestBody Travels travel ,@RequestParam("sessionKey") String key) throws TravelsException, BusException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Travels travels1=cont.registerNewTravels(travel);
			
			return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
		
	}
	
	@PostMapping("/AddNewBusIn_travels/{Travel_id}")
	public ResponseEntity<Travels> registerNewBusInTravels(@Valid @PathVariable("Travel_id") Integer tid,@RequestBody Bus bus ,@RequestParam("sessionKey") String key) throws TravelsException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {

			Travels travels1=cont.registerNewBusInTravels(tid, bus);
			return new ResponseEntity<Travels>(travels1, HttpStatus.OK);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	@PutMapping("/AddOldBusIntravels/{Travel_id}/{Bus_Id}")
	public ResponseEntity<Travels> registerOldBusInTravels(@Valid @PathVariable("Travel_id") Integer tid,@PathVariable("Bus_Id") Integer bid ,@RequestParam("sessionKey") String key) throws TravelsException, BusException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Travels travels1=cont.registerOldBusInTravels(tid, bid);
			return new ResponseEntity<Travels>(travels1, HttpStatus.OK);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	

	@GetMapping("/GettravelsById/{Travel_id}")
	public ResponseEntity<Travels> getTravelsByIdHandler(@Valid  @PathVariable("Travel_id") Integer travelsID ,@RequestParam("sessionKey") String key) throws TravelsException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			Travels travels1= cont.getTravelsById(travelsID);
			return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
	
	@GetMapping("/Alltravels")
	public ResponseEntity<List<Travels>> getAllTravelsDetails(@Valid  @RequestParam("sessionKey") String key) throws TravelsException, SessionException{
		Session session= service.getASessionByKey(key);
		if(session.getUserType()==UserType.ADMIN) {
			List<Travels> travels1= cont.getAllTravelsDetails();
			return new ResponseEntity<List<Travels>>(travels1, HttpStatus.CREATED);
			
		}else {
			throw new SessionException("Please Enter Correct Key..!");
		}
		
		
	}
//	
//	@DeleteMapping("/travels/{id}")
//	public ResponseEntity<Travels> deleteTravelsByIdHandler(@Valid  @PathVariable("id") Integer travelsId ,@RequestParam("sessionKey") String key) throws TravelsException{
//		Session session= service.getASessionByKey(key);
//	if(session.getUserType()==UserType.ADMIN) {
//		Travels travels1= cont.deleteTravelsById(travelsId);
//	return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
//		
//	}else {
//		throw new SessionException("Please Enter Correct Key..!");
//	}
//	
//		
//		
//	}
	
	
}
