package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.Booking;

public interface BookingDao extends JpaRepository<Booking,Integer>{

}
