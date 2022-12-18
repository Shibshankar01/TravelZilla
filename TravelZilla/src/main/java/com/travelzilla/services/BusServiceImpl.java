package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.RouteMatcher.Route;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.repositories.BusDAO;
import com.travelzilla.repositories.RouteDAO;
import com.travelzilla.repositories.TravelsDAO;

@Service
public class BusServiceImpl implements BusService {
	
	
	@Autowired
	private BusDAO erepo;
	@Autowired
	private RouteDAO route_repo;
	@Autowired
	private TravelsDAO travel_repo;

	@Override
	public Bus registerBus(Bus bus) throws BusException {
		// TODO Auto-generated method stub
        if(bus !=null) {
			
        	Bus bus1 =erepo.save(bus);
			return bus1;
		}else {
			throw new BusException("Customer is null ");
		}
	}

	@Override
	public Bus getBusById(Integer busID) throws BusException {
		
        Optional<Bus> em=erepo.findById(busID);
		
		if(em.isPresent()) {
			Bus cus1= em.get();
			return cus1;
		}else {
			throw new BusException("Bus Not Found.");
		}
	}

	@Override
	public List<Bus> getAllBusDetails() throws BusException {
          List<Bus> list= erepo.findAll();
		
		if(list.size()==0) {
			throw new BusException(" no Bus ");
		}else {
			return list;
		}
	}

//	@Override
//	public Bus deleteBusById(Integer busId) throws BusException {
//        Optional<Bus> em=erepo.findById(busId);
//		
//		if(em.isPresent()) {
//			Bus cus1= em.get();
//			erepo.delete(cus1);
//			
//			return cus1;
//		}else {
//			throw new BusException("Bus deleted.");
//		}
//	}

	@Override
	public Bus  RegisterBusWithRoute_idANDTravels_id(Integer routeId, Integer travelId, Bus bus)throws BusException, RouteException, TravelsException {
		// TODO Auto-generated method stub
		
	
		
        if(bus !=null) {
        	
        	Optional<com.travelzilla.models.Route> rou=route_repo.findById(routeId);
        	Optional<com.travelzilla.models.Travels> tra=travel_repo.findById(travelId);

    		
    		if(rou.isPresent() ) {
    			
    			if(tra.isPresent()) {
    				com.travelzilla.models.Route route= rou.get();
        			com.travelzilla.models.Travels travel= tra.get();
        			route.getBusList().add(bus);
        			bus.setRoute(route);
        			
        			travel.getBusList().add(bus);
        			bus.setTravel(travel);
    			}else {
    				throw new TravelsException("Travels Not Found");
    			}
      			
    		}else {
    			throw new RouteException("Route Not Found.");
    		}
	
        	Bus bus1 =erepo.save(bus);
  
			return bus1;
		}else {
			throw new BusException("Bus is null ");
		}
	}
}
