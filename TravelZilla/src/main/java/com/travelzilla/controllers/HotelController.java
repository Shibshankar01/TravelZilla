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
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.HotelException;
import com.travelzilla.models.Hotel;
import com.travelzilla.services.HotelServicesImpl;


@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelServicesImpl pService;

	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel pack) {
		return new ResponseEntity<Hotel>(pService.addHotel(pack), HttpStatus.OK);
	}

	@DeleteMapping("/deleteHotel/{id}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Integer id) throws HotelException {
		return new ResponseEntity<Hotel>(pService.deleteHotelById(id), HttpStatus.OK);
	}

	@GetMapping("/searchHotelById/{id}")
	public ResponseEntity<Hotel> searchHotelById(@PathVariable("id") Integer id) throws HotelException {
		return new ResponseEntity<Hotel>(pService.searchHotelById(id), HttpStatus.OK);
	}

	@GetMapping("/viewAllHotels")
	public ResponseEntity<List<Hotel>> viewAllHotels() {
		return new ResponseEntity<List<Hotel>>(pService.viewAllHotels(), HttpStatus.OK);
	}

}
