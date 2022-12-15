package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.Bus;

public interface BusDTO extends JpaRepository<Bus, Integer>{

}
