package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	public Customer findByEmail(String email);

}
