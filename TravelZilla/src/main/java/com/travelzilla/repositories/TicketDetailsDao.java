package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travelzilla.models.TicketDetails;

public interface TicketDetailsDao extends JpaRepository<TicketDetails,Integer>{

}