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
import com.travelzilla.models.Travels;
import com.travelzilla.repositories.BusDAO;

import com.travelzilla.repositories.RouteDAO;
import com.travelzilla.repositories.TravelsDAO;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDAO busrepo;

	@Autowired
	private RouteDAO route_repo;

	@Autowired
	private TravelsDAO travel_repo;



//	Register New Bus .
	@Override
	public Bus registerBus(Bus bus) throws BusException {
	
		if (bus != null) {

			Bus bus1 = busrepo.save(bus);
			return bus1;
		} else {
			throw new BusException("Customer is null ");
		}
	}

//  Search Bus with their IDs.
	@Override
	public Bus getBusById(Integer busID) throws BusException {

		Optional<Bus> em = busrepo.findById(busID);

		if (em.isPresent()) {
			Bus cus1 = em.get();
			return cus1;
		} else {
			throw new BusException("Bus Not Found.");
		}
	}

//	Get all Bus from database.
	@Override
	public List<Bus> getAllBusDetails() throws BusException {
		List<Bus> list = busrepo.findAll();
		
		
		if (list.size() == 0) {
			throw new BusException(" no Bus ");
		} else {
			return list;
		}
	}


// Register Bus Along with Existing Travels and route.
	@Override
	public Bus  RegisterBusWithRoute_idANDTravels_id(Integer routeId, Integer travelId, Bus bus)throws BusException, RouteException, TravelsException {

		
        if(bus !=null) {

        	
        	Optional<com.travelzilla.models.Route> rou=route_repo.findById(routeId);
//        	associating route with bus if exist.
        	if(rou.isPresent() ) {

        		com.travelzilla.models.Route route= rou.get();
        		
        		route.getBusList().add(bus);
    			bus.setRoute(route);
        	}else {
    			throw new RouteException("Route Not Found.");
    		}		
   
        	Optional<com.travelzilla.models.Travels> trav= travel_repo.findById(travelId);
//        	associating Travels with bus if exist.
    			if(trav.isPresent()) {

    				
        			com.travelzilla.models.Travels travel= trav.get();
        			
        			
        			travel.getBusList().add(bus);
        			bus.setTravel(travel);
    			}else {
    				throw new TravelsException("Travels Not Found");
    			}
      			
    		
	
        	Bus bus1 =busrepo.save(bus);
  
			return bus1;
		}else {
			throw new BusException("Bus is null ");

		}
	}
}
