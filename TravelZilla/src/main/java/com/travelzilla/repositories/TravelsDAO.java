package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.travelzilla.models.Travels;

public interface TravelsDAO extends JpaRepository<Travels, Integer>{
	
	public Travels findByEmail(String email);
}
