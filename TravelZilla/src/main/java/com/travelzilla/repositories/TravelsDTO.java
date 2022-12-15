package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.Travels;

public interface TravelsDTO extends JpaRepository<Travels, Integer>{

}
