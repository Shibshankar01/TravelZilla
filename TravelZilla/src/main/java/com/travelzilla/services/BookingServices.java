package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.models.Booking;
import com.travelzilla.models.BookingDTO;
import com.travelzilla.models.Session;

public interface BookingServices {

	Booking makeBooking(BookingDTO bookingDTO, Session session) throws BookingException;

	public Booking ViewBookingById(Integer bookingId) throws BookingException;

	public List<Booking> viewAllBookings() throws BookingException;

	public Booking cancelBookingById(Integer bookingId) throws BookingException;


}
