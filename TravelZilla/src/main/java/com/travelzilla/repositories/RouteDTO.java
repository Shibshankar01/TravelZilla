package com.travelzilla.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Route;

@Repository
public interface RouteDTO extends JpaRepository<Route, Integer>{

}
