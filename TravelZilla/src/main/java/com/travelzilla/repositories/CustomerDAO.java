package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

}
