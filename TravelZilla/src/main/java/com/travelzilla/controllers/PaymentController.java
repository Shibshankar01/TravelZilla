package com.travelzilla.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.PaymentException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Hotel;
import com.travelzilla.models.Payment;
import com.travelzilla.models.PaymentDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.PaymentServices;
import com.travelzilla.services.SessionServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentServices paymentService;

	@Autowired
	SessionServices sessionService;
	
	
	@PostMapping("/makePayment")
	public ResponseEntity<Payment> makePayment(@Valid @RequestBody PaymentDTO pDto, @RequestParam("sessionKey") String sessionKey) throws PaymentException, AdminException, SessionException {
		Session session = sessionService.getASessionByKey(sessionKey);
		if (session.getUserType() == UserType.ADMIN) {
		return new ResponseEntity<Payment>(paymentService.makePayment(pDto, session), HttpStatus.OK);
	}
	throw new AdminException("Please login with the correct credentials");
	}

	@GetMapping("viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.viewAllPayments(), HttpStatus.OK);
	}

}
