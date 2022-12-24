package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.models.Customer;
import com.travelzilla.repositories.CustomerDAO;

@Service
public class CustomerServicesImpl implements CustomerServices{
	
	@Autowired
	private CustomerDAO cDao;
	
	private EncryptService encrypt=new EncryptServiceImpl();

	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		if(cDao.findByEmail(customer.getEmail())!= null)
			throw new CustomerException("Customer already present with that email");
		
		String admin1= encrypt.EncryptPassword(customer.getCustomerPassword());
		customer.setCustomerPassword(admin1);
	   
	     
		return cDao.save(customer);
		
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		cDao.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("Customer does not exist with Id:- "+customer.getCustomerId()));
		
		return cDao.save(customer);
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerException {

		Optional<Customer> opt = cDao.findById(customerId);
		
		if(opt.isPresent()) {
			Customer customer = opt.get();
			cDao.delete(customer);
			return customer;
		}else {
			throw new CustomerException("Customer does not exist with Id:- "+customerId);
		}
		
	}
	
	

	@Override
	public Customer viewCustomer(Integer customerId) throws CustomerException {
		
		return cDao
				.findById(customerId)
				.orElseThrow(() -> 
				new CustomerException("No Customer found with Id:- "+customerId));
		
	}
	


	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {

		List<Customer> customers = cDao.findAll();
		
		if (customers.size()!=0) {
			
			return customers;
			
		}else {
			
			throw new CustomerException("No Customer found!");
			
		}
		
	}

	

}
