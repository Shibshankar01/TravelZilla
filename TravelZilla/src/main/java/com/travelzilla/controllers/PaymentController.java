package com.travelzilla.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.PaymentException;
import com.travelzilla.models.Payment;
import com.travelzilla.models.PaymentDTO;
import com.travelzilla.services.PaymentServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentServices paymentService;

	@PostMapping("/makePayment")
	public ResponseEntity<Payment> makePayment(@Valid @RequestBody PaymentDTO pDto) throws PaymentException {
		return new ResponseEntity<Payment>(paymentService.makePayment(pDto), HttpStatus.OK);
	}

	@GetMapping("viewAllPayments")
	public ResponseEntity<List<Payment>> viewAllPayments() {
		return new ResponseEntity<List<Payment>>(paymentService.viewAllPayments(), HttpStatus.OK);
	}

}
