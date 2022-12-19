package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.PaymentException;
import com.travelzilla.models.Booking;
import com.travelzilla.models.BookingStatus;
import com.travelzilla.models.PackageStatus;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Payment;
import com.travelzilla.models.PaymentDTO;
import com.travelzilla.models.PaymentStatus;
import com.travelzilla.models.Session;
import com.travelzilla.repositories.BookingDao;
import com.travelzilla.repositories.BusDAO;
import com.travelzilla.repositories.PackageDAO;
import com.travelzilla.repositories.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentServices {

	@Autowired
	PaymentDAO paymentDAO;

	@Autowired
	BookingDao bookingDao;

	@Autowired
	PackageDAO packageDAO;

	@Autowired
	BusDAO busDao;

	@Override
	public Payment makePayment(PaymentDTO paymentDTO, Session session) throws PaymentException {

		Booking currentBooking = bookingDao.findById(paymentDTO.getBookingId()).orElseThrow(() -> new PaymentException(
				"Payment Cannot Be Done For Inavalid Booking ID : " + paymentDTO.getBookingId()));
		Packages bookedPackage = packageDAO.findById(currentBooking.getPackages().getPackageId()).orElseThrow();

		Payment newPayment = new Payment();

		String correctUpiId = currentBooking.getCustomer().getCustomerName() +"@upi";
		
		if (paymentDTO.getUpi_Id().equals(correctUpiId) && paymentDTO.getPin() == 123456
				&& currentBooking.getBookingStatus() == BookingStatus.PAYMENT_PENDING
				&& bookedPackage.getPackageStatus() == PackageStatus.AVAILABLE
				&& currentBooking.getCustomer().getCustomerId() == session.getUserId()) {

			newPayment.setBooking(currentBooking);
			newPayment.setPaymentStatus(PaymentStatus.SUCCESSFULL);
			newPayment.setPaymentInfo("Mode of Payment : UPI |" + "UPI ID : " + paymentDTO.getUpi_Id());
			newPayment.setPaymentAmount(currentBooking.getTotalCost());

			currentBooking.setBookingStatus(BookingStatus.BOOKING_CONFIRMED);
			int seatNo = bookedPackage.getBus().getCapacity() - bookedPackage.getBus().getAvailabeSeat() + 1;
			String bookingDescription = "Bus Number : " + bookedPackage.getBus().getBusNumber() + "\n Bus Type : "
					+ bookedPackage.getBus().getBusType() + "\n Seat Number : " + seatNo + "\n Hotel Name : "
					+ bookedPackage.getHotel().getHotelName();
			currentBooking.setDescription(bookingDescription);
			bookedPackage.setPackageStatus(currentBooking.getNoOfPersons());

			packageDAO.save(bookedPackage);
			busDao.save(bookedPackage.getBus());
			bookingDao.save(currentBooking);

			return paymentDAO.save(newPayment) ;
		} else {
			newPayment.setBooking(currentBooking);
			newPayment.setPaymentStatus(PaymentStatus.FAILED);

			if (bookedPackage.getPackageStatus() == PackageStatus.SOLD_OUT) {
				newPayment.setPaymentInfo("Sorry You're Late For Payment, Package Is Sold Out!!");
			} else if (currentBooking.getBookingStatus() == BookingStatus.BOOKING_CONFIRMED) {
				newPayment.setPaymentInfo("Payment for This Booking has Already been Done !!");
			} else {
				newPayment.setPaymentInfo("Payment Failed Due To Wrong/Invalid Credentials !!");
			}

			newPayment.setPaymentAmount(0.00);

			return newPayment;
		}

	}

	@Override
	public List<Payment> viewAllPayments() {
		return paymentDAO.findAll();
	}

}
