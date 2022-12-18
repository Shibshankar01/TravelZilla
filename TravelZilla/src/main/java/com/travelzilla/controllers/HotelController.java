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

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.HotelException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Hotel;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.HotelServicesImpl;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	HotelServicesImpl pService;

	@Autowired
	SessionServices sessionService;

	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel pack, @RequestParam("sessionKey") String sessionKey)
			throws AdminException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.ADMIN) {
			return new ResponseEntity<Hotel>(pService.addHotel(pack), HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
	}

	@DeleteMapping("/deleteHotel/{id}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("id") Integer id,
			@RequestParam("sessionKey") String sessionKey) throws HotelException, AdminException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.ADMIN) {
			return new ResponseEntity<Hotel>(pService.deleteHotelById(id), HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
	}

	@GetMapping("/searchHotelById/{id}")
	public ResponseEntity<Hotel> searchHotelById(@PathVariable("id") Integer id,
			@RequestParam("sessionKey") String sessionKey) throws HotelException, CustomerException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.ADMIN || session.getUserType() == UserType.ADMIN) {

			return new ResponseEntity<Hotel>(pService.searchHotelById(id), HttpStatus.OK);
		}
		throw new CustomerException("Please login with the correct credentials");
	}

	@GetMapping("/viewAllHotels")
	public ResponseEntity<List<Hotel>> viewAllHotels(@RequestParam("sessionKey") String sessionKey)
			throws SessionException, AdminException {

		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.ADMIN) {
			return new ResponseEntity<List<Hotel>>(pService.viewAllHotels(), HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
	}

}
