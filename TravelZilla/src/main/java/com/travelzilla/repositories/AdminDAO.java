package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer>{

	public Admin findByEmail(String email);
	

}
