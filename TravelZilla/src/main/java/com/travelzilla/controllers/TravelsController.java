package com.travelzilla.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Travels;
import com.travelzilla.services.TravelsService;

@RestController
public class TravelsController {

	
	
	@Autowired
	private TravelsService cont;
	
	@GetMapping("/travels")
	public ResponseEntity<Travels> registerTravelsHandler(@RequestBody Travels travels) throws TravelsException{
		
		Travels travels1= cont.registerTravels(travels);
		return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/travels/{id}")
	public ResponseEntity<Travels> getTravelsByIdHandler(@PathVariable("id") Integer travelsID) throws TravelsException{
		Travels travels1= cont.getTravelsById(travelsID);
		return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
	}
	
	@GetMapping("/travelss")
	public ResponseEntity<List<Travels>> getAllTravelsDetails() throws TravelsException{
		
		List<Travels> travels1= cont.getAllTravelsDetails();
		return new ResponseEntity<List<Travels>>(travels1, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/travels/{id}")
	public ResponseEntity<Travels> deleteTravelsByIdHandler(@PathVariable("id") Integer travelsId) throws TravelsException{
		
		Travels travels1= cont.deleteTravelsById(travelsId);
		return new ResponseEntity<Travels>(travels1, HttpStatus.CREATED);
		
	}
	
	
}
