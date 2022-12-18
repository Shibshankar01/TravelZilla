package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Payment;

@Repository
public interface PaymentDAO extends JpaRepository<Payment, Integer> {

}
