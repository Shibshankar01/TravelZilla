package com.travelzilla.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.models.Booking;
import com.travelzilla.models.BookingDTO;
import com.travelzilla.models.BookingStatus;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Customer;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Session;
import com.travelzilla.models.TicketDetails;
import com.travelzilla.repositories.BookingDao;
import com.travelzilla.repositories.BusDAO;
import com.travelzilla.repositories.CustomerDAO;
import com.travelzilla.repositories.PackageDAO;
import com.travelzilla.repositories.TicketDetailsDao;

@Service
public class BookingServicesImpl implements BookingServices {
	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private PackageDAO packageDAO;

	@Autowired
	private TicketDetailsDao ticketDetailsDao;

	@Autowired
	private BusDAO busDao;


	
	@Override
	public Booking makeBooking(BookingDTO bookingDTO, Session session) throws BookingException {

		Packages bookedPackage = packageDAO.findById(bookingDTO.getPackageId())
				.orElseThrow(() -> new BookingException("Invalid Package ID ! "));
		
		Customer currentCustomer = customerDAO.findById(session.getUserId())
				.orElseThrow(() -> new BookingException("Invalid Customer ID ! "));

		if (bookedPackage != null ) {
			if (bookedPackage.getCurrentAvailability() >= bookingDTO.getNoOfPersons()) {

				// Creating New Booking
				Booking booking = new Booking();

				// Setting Booking Details
				booking.setBookingDate(LocalDateTime.now());
				booking.setBookingTitle(bookedPackage.getPackageName() + " " + bookedPackage.getPackageDescription());
				booking.setCustomer(currentCustomer);
				String bookingDescription = "Bus Number : " + bookedPackage.getBus().getBusNumber() + " - Bus Type : "
						+ bookedPackage.getBus().getBusType() + "- Seat Number : Will Be Alloted After Payment."
						+ " - Hotel Name : " + bookedPackage.getHotel().getHotelName();
				booking.setDescription(bookingDescription);
				booking.setBookingStatus(BookingStatus.PAYMENT_PENDING);
				booking.setPackages(bookedPackage);
				booking.setTotalCost(bookedPackage.getPackageCost() * bookingDTO.getNoOfPersons());
				booking.setNoOfPersons(bookingDTO.getNoOfPersons());

				// Creating a New Bus Ticket
				TicketDetails td = new TicketDetails();

				// Assigning Bus To The Ticket
				td.setBus(bookedPackage.getBus());

				// Storing The Ticket Inside the List of Tickets Of The Bus
				bookedPackage.getBus().getTicketdetails().add(td);

				// Updating the Bus To Database
				busDao.save(bookedPackage.getBus());

				// Assigning Ticket To The Booking
				booking.setTicket(td);

				// Updating Ticket Details To Database
				ticketDetailsDao.save(td);

				// Saving The Booking To Database
				return bookingDao.save(booking);
			} else {
				throw new BookingException("Number Of Person Is Greater Than Available Seats.");
			}
		} else
			throw new BookingException("Package And Customer Cannot Be Null !");
	}

	@Override
	public Booking cancelBookingById(Integer bookingId) throws BookingException {
		Booking currentBooking = bookingDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));

		currentBooking.setBookingStatus(BookingStatus.CANCELLED);

		Packages cancelledPackage = currentBooking.getPackages();

		cancelledPackage.setPackageStatus(currentBooking.getNoOfPersons() - (currentBooking.getNoOfPersons() * 2));

		busDao.save(cancelledPackage.getBus());

		bookingDao.save(currentBooking);

		packageDAO.save(cancelledPackage);

		return currentBooking;
	}

	@Override
	public Booking ViewBookingById(Integer bookingId) throws BookingException {
		return bookingDao.findById(bookingId)
				.orElseThrow(() -> new BookingException("Bookings Not Found With Packages ID :" + bookingId));
	}

	@Override
	public List<Booking> viewAllBookings() throws BookingException {
		return bookingDao.findAll();
	}

}
