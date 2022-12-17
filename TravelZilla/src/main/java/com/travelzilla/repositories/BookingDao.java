package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Booking;
@Repository
public interface BookingDao extends JpaRepository<Booking,Integer>{

}
