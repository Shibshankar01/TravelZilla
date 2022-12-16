package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.models.Booking;
import com.travelzilla.repositories.BookingDao;
@Service
public class BookingServicesImpl implements BookingServices{
	@Autowired
	private BookingDao bDao;
	@Override
	public Booking makeBooking(Booking booking) throws BookingException {
		return bDao.save(booking);
	}

	@Override
	public Booking deleteBookingById(Integer bookingId) throws BookingException {
		Booking b = bDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));

		if (b != null) {
			bDao.deleteById(bookingId);
		}
		return b;
	}

	@Override
	public Booking ViewBookingById(Integer bookingId) throws BookingException {
		return bDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));
	}

	@Override
	public List<Booking> viewAllBookings() throws BookingException {
		return bDao.findAll();
	}

}
