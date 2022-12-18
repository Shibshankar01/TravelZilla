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
import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Booking;
import com.travelzilla.models.BookingDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.BookingServices;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingServices bookingService;

	@Autowired
	private SessionServices sessionService;
	
	
	@PostMapping("/makeBooking")
	public ResponseEntity<Booking> makeBooking(@Valid @RequestBody BookingDTO booking, @RequestParam("sessionKey") String sessionKey) throws BookingException, SessionException, CustomerException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.CUSTOMER) {
		return new ResponseEntity<Booking>(bookingService.makeBooking(booking, session), HttpStatus.OK);
		}
		throw new CustomerException("Please login with the correct credentials");
	}

	@DeleteMapping("/cancelBooking/{bookingId}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("bookingId") Integer bookingId, @RequestParam("sessionKey") String sessionKey) throws BookingException, SessionException, CustomerException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.CUSTOMER) {
		return new ResponseEntity<Booking>(bookingService.cancelBookingById(bookingId), HttpStatus.OK);
		}
		throw new CustomerException("Please login with the correct credentials");
	}

	@GetMapping("/viewBooking/{bookingId}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable("bookingId") Integer bookingId, @RequestParam("sessionKey") String sessionKey) throws BookingException, SessionException, CustomerException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.CUSTOMER) {
		return new ResponseEntity<Booking>(bookingService.ViewBookingById(bookingId), HttpStatus.OK);
	}
	throw new CustomerException("Please login with the correct credentials");
	}

	@GetMapping("/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBookings( @RequestParam("sessionKey") String sessionKey) throws BookingException, AdminException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
		return new ResponseEntity<List<Booking>>(bookingService.viewAllBookings(), HttpStatus.OK);
	}
	throw new AdminException("Please login with the correct credentials");
	}
}
