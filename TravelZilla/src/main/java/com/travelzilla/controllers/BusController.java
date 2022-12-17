package com.travelzilla.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Bus;
import com.travelzilla.services.BusService;

@RestController
public class BusController {
	
	
	@Autowired
	private BusService cont;
	
	@PostMapping("/bus")
	public ResponseEntity<Bus> registerBusHandler(@RequestBody Bus bus) throws BusException{
		
		Bus bus1= cont.registerBus(bus);
		return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
		
		
	}
	
	@PostMapping("/bus/{id}")
	public ResponseEntity<Bus>  TRYregisterBus(@PathVariable("id") Integer routeId, @RequestBody Bus bus)throws BusException, RouteException{
		
		Bus bus1= cont.TRYregisterBus(routeId, bus);
		return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/bus/{id}")
	public ResponseEntity<Bus> getBusByIdHandler(@PathVariable("id") Integer busID) throws BusException{
		Bus bus1= cont.getBusById(busID);
		return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
	}
	
	@GetMapping("/buss")
	public ResponseEntity<List<Bus>> getAllBusDetails() throws BusException{
		
		List<Bus> bus1= cont.getAllBusDetails();
		return new ResponseEntity<List<Bus>>(bus1, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/bus/{id}")
	public ResponseEntity<Bus> deleteBusByIdHandler(@PathVariable("id") Integer busId) throws BusException{
		
		Bus bus1= cont.deleteBusById(busId);
		System.out.println(bus1);
		return new ResponseEntity<Bus>(bus1, HttpStatus.CREATED);
		
	}

}
