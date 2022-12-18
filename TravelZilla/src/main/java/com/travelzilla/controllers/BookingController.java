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
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Admin;
import com.travelzilla.models.Booking;
import com.travelzilla.models.BookingDTO;
import com.travelzilla.models.Report;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.BookingServices;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingServices bService;
	
	@Autowired
	private SessionServices sServices;

	@PostMapping("/makeBooking")
	public ResponseEntity<Booking> makeBooking(@Valid @RequestBody BookingDTO booking, @RequestParam("sessionKey")String sessionKey) throws BookingException, SessionException {
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==booking.getCustomerId()&& session.getUserType()==UserType.CUSTOMER) {
			return new ResponseEntity<Booking>(bService.makeBooking(booking), HttpStatus.OK);
		}
		throw new BookingException("Please login with the correct credentials");
	}

	@DeleteMapping("/cancelBooking/{id}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("id") Integer bookingId, @RequestParam("sessionKey")String sessionKey,@RequestParam("customerId") int customerId) throws BookingException, SessionException {
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==customerId&&session.getUserType()==UserType.CUSTOMER) {
			Booking booking = bService.cancelBookingById(bookingId);
			return new ResponseEntity<Booking>(bService.cancelBookingById(bookingId), HttpStatus.OK);
		}
		throw new BookingException("Please login with the correct credentials");
		
	}

	@GetMapping("/viewBooking/{id}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable("id") Integer bookingId, @RequestParam("sessionKey")String sessionKey,@RequestParam("customerId") int customerId) throws BookingException, SessionException {
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==customerId&& session.getUserType()==UserType.CUSTOMER) {
			Booking booking = bService.cancelBookingById(bookingId);
			return new ResponseEntity<Booking>(bService.ViewBookingById(bookingId), HttpStatus.OK);
		}
		throw new BookingException("Please login with the correct credentials");
		
	}

	@GetMapping("/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBookings( @RequestParam("sessionKey")String sessionKey ) throws BookingException, SessionException {
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<List<Booking>>(bService.viewAllBookings(), HttpStatus.OK);
		}
		throw new BookingException("Please login with the correct credentials");
		
	}
}
