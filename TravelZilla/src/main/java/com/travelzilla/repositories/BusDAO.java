package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.Bus;

public interface BusDAO extends JpaRepository<Bus, Integer>{

}
