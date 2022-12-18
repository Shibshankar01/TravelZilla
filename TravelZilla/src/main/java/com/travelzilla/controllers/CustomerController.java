package com.travelzilla.controllers;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.models.Customer;
import com.travelzilla.services.CustomerServices;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	
	@Autowired
	private CustomerServices customerServices;
	
	@Autowired
	private SessionServices sServices;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) throws CustomerException{
		
		return new ResponseEntity<Customer>(customerServices.addCustomer(customer),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deletecustomer/{cid}")
	public ResponseEntity<Customer> deleteCustomerbyIdHandler(@PathVariable Integer customerId) throws CustomerException{
		Customer dc = customerServices.deleteCustomer(customerId) ;
		return new ResponseEntity<Customer>(dc, HttpStatus.OK);
	}
	
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer customer) throws CustomerException{
		
		Customer updatedCustomer= customerServices.updateCustomer(customer, null);
		
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/viewcustomer/{id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("id") Integer id) throws CustomerException{
		
		return new ResponseEntity<>(customerServices.viewCustomer(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/viewallcustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws CustomerException{
		
		return new ResponseEntity<List<Customer>>(customerServices.viewAllCustomer(),HttpStatus.OK);
		
	}
	
	

	
}
