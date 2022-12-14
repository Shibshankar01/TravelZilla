package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Hotel;

@Repository
public interface HotelDAO extends JpaRepository<Hotel, Integer> {

}
