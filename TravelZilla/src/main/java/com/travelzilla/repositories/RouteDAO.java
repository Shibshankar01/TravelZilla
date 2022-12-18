package com.travelzilla.repositories;



import java.util.List;
import java.util.Set;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;

@Repository
public interface RouteDAO extends JpaRepository<Route, Integer>{
	
	@Query("select r from Route r where r.routeFrom=?1 AND r.routeTo=?2")
	public List<Route> getAllRouteByFrom_To(String from, String to);
	
	@Query("select r from Route r where r.routeFrom=?1")
	public List<Route> getAllRouteByFrom(String from);
	

	public List<Route> findByRouteFromAndRouteTo(String source, String destination);







	
	


}
