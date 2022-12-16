package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.PaymentException;
import com.travelzilla.models.Payment;
import com.travelzilla.models.PaymentDTO;
import com.travelzilla.repositories.PaymentDAO;

@Service
public class PaymentServiceImpl implements PaymentServices{

	@Autowired
	PaymentDAO pDao;
	
//	@Autowired
//	BookingDAO bDao;
	
	@Override
	public Payment makePayment(PaymentDTO paymentDTO) throws PaymentException {
		
		Payment newPayment = new Payment();
		if(paymentDTO.getUpi_Id().equals("123@abc") && paymentDTO.getPin()==123456) {
			
		}
		else {
//			newPayment.
//			throw new PaymentException("Invalid Credentials, Payment Failed!");
		}
		
		return newPayment;
		
	}

	@Override
	public List<Payment> viewAllPayments() {
		return pDao.findAll();
	}

}
