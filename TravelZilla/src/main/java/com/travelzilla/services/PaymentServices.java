package com.travelzilla.services;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.travelzilla.exceptions.PaymentException;
import com.travelzilla.models.Payment;
import com.travelzilla.models.PaymentDTO;



@Repository
public interface PaymentServices {

	public Payment makePayment(PaymentDTO paymentDTO) throws PaymentException;
	
	public List<Payment> viewAllPayments();
}
