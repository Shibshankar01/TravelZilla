package com.travelzilla.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;
import com.travelzilla.repositories.RouteDAO;


@Service
public class RouteServiceImpl implements RouteService{
	
	@Autowired
	private RouteDAO Rrepo;

//	Resister new Route along with bus.
	@Override
	public Route registerRoute(Route route) throws RouteException {
            if(route !=null) {
			
//          If any Bus is associated with route it create bus object 
//          and save data in bus as well as route databases.	
            	
		          java.util.Set<Bus> buslist= route.getBusList();
			      for(Bus buss:buslist) {
		
			      	buss.setRoute(route);
				
			      }
			
			return Rrepo.save(route);
			
		   }else {
			throw new RouteException("Route is null ");
		   }
	}

//	To get specific Route object 
	@Override
	public Route getRouteById(Integer routeID) throws RouteException {
		
        Optional<Route> em=Rrepo.findById(routeID);
		
		if(em.isPresent()) {
			Route cus1= em.get();
			return cus1;
		}else {
			throw new RouteException("Route Not Found.");
		}
	}

//	It provide all the route from database.
	@Override
	public List<Route> getAllRouteDetails() throws RouteException {
          List<Route> list= Rrepo.findAll();
		
		if(list.size()==0) {
			throw new RouteException(" no Route ");
		}else {
			return list;
		}
	}


//	This function provides all packages based on customer search(destination and origin).
	@Override
	public List<Packages> getAllRouteByFrom_To(String from, String to) throws RouteException {
		
//      Get all Routes.
		List<Route> Route= Rrepo.getAllRouteByFrom_To(from, to);
		List<Packages> list=new ArrayList<>();
		
		if(Route.size() > 0)
		{
			for(Route r:Route) {
//				get all packages in side a route and add in new List.
				Set<Packages> pac=r.getPackageList();
				List<Packages> l=new ArrayList<>(pac);
				
				list.addAll(l);
				
			}
		
		
		
		return list;
		}else {
			throw new RouteException("Route does not exist from "+from+" to "+to);
		}
	}

//	This function provides all packages which is start from origin.
	@Override
	public List<Packages> getAllRouteByFrom(String from) throws RouteException {
        List<Route> package1= Rrepo.getAllRouteByFrom(from);
		
		List<Packages> list=new ArrayList<>();
		
		if(package1.size() > 0)
		{
			for(Route r:package1) {
				Set<Packages> pac=r.getPackageList();
				List<Packages> l=new ArrayList<>(pac);
				
				list.addAll(l);
				
			}
		
		
		return list;
		}else {
			throw new RouteException("Route does not exist from "+from);
		}
	}

}
