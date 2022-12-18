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

	@Override
	public Route registerRoute(Route route) throws RouteException {
		// TODO Auto-generated method stub
            if(route !=null) {
			
			java.util.Set<Bus> buslist= route.getBusList();
	
			for(Bus buss:buslist) {
				
				//associating each student with course
				buss.setRoute(route);
				
			}
			
			return Rrepo.save(route);
			
		}else {
			throw new RouteException("Route is null ");
		}
	}

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

	@Override
	public List<Route> getAllRouteDetails() throws RouteException {
          List<Route> list= Rrepo.findAll();
		
		if(list.size()==0) {
			throw new RouteException(" no Route ");
		}else {
			return list;
		}
	}

//	@Override
//	public List<Packages> getAllRouteByFrom_To(Integer from, Integer to) throws RouteException {
//		// TODO Auto-generated method stub
//		Set<Packages> package1= Rrepo.getAllRouteByFrom_To(from, to);
//		
//		if(package1.size() > 0)
//		{
//		
//		List<Packages> list=new ArrayList<>(package1);
//		
//		return list;
//		}else {
//			throw new RouteException("Route does not exist from "+from+" to "+to);
//		}
//	}

	@Override
	public List<Packages> getAllRouteByFrom(String from) throws RouteException {
       Set<Packages> package1= Rrepo.getAllRouteByFrom_To(from);
		
		if(package1.size() > 0)
		{
		
		List<Packages> list= new ArrayList<>(package1);
		
		return list;
		}else {
			throw new RouteException("Route does not exist from "+from);
		}
	}

	

//	@Override
//	public Route deleteRouteById(Integer routeId) throws RouteException {
//        Optional<Route> em=erepo.findById(routeId);
//		
//		if(em.isPresent()) {
//			Route cus1= em.get();
//			erepo.delete(cus1);
//			
//			return cus1;
//		}else {
//			throw new RouteException("Route deleted.");
//		}
//	}

//	@Override
//	public Route modifyRoute(Route route) throws RouteException {
//        Optional<Route> em=erepo.findById(route.getRouteId());
//		
//		if(em.isPresent()) {
//			Route cud1 =erepo.save(route);
//			return cud1;
//		}else {
//			throw new RouteException("Customer Not Found.");
//		} 
//	}

}
