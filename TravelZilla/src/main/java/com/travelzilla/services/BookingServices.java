package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.models.Booking;



public interface BookingServices {
	
public Booking  makeBooking(Booking booking)throws BookingException;
public Booking deleteBookingById(Integer bookingId)throws BookingException;
public Booking ViewBookingById(Integer bookingId)throws BookingException;
public List<Booking> viewAllBookings()throws BookingException;
	
	
}
