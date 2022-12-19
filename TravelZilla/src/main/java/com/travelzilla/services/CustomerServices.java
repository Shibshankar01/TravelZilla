package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.models.Customer;

public interface CustomerServices {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;
	
	

}
