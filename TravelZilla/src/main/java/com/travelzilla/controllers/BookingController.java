package com.travelzilla.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.models.Booking;
import com.travelzilla.services.BookingServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

	private BookingServices bService;
	
	@PostMapping("/makeBooking")
	public ResponseEntity<Booking> makeBooking(@Valid @RequestBody Booking booking)throws BookingException{
		return new ResponseEntity<Booking>(bService.makeBooking(booking), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteBooking/{id}")
	public ResponseEntity<Booking> deleteBookingById(@PathVariable("id") Integer bookingId) throws BookingException{
		return new ResponseEntity<Booking>(bService.deleteBookingById(bookingId), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewBooking/{id}")
	public ResponseEntity<Booking> viewBookingById(@PathVariable("id") Integer bookingId) throws BookingException{
		return new ResponseEntity<Booking>(bService.ViewBookingById(bookingId), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewAllBookings")
	public ResponseEntity<List<Booking>> viewAllBookings() throws BookingException{
		return new ResponseEntity <List<Booking>>(bService.viewAllBookings(), HttpStatus.OK);
	}
}
