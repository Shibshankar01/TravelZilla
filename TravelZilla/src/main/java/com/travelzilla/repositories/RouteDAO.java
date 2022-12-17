package com.travelzilla.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelzilla.models.Route;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer> {

	public List<Route> findByRouteFromAndRouteTo(String routeFrom, String routeTo);
}
