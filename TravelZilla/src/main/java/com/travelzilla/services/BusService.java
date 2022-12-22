package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;


public interface BusService {
	
	public Bus  RegisterBusWithRoute_idANDTravels_id(Integer routeId, Integer travelId, Bus bus)throws BusException, RouteException,TravelsException;
	
	public Bus  registerBus(Bus bus)throws BusException;
	
	public Bus getBusById(Integer bus)throws BusException;
	
	public List<Bus>  getAllBusDetails()throws BusException;
	
}
