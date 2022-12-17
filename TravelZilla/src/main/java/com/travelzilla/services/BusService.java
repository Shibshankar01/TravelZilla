package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Bus;


public interface BusService {
	
	public Bus  TRYregisterBus(Integer routeId, Bus bus)throws BusException, RouteException;
	public Bus  registerBus(Bus bus)throws BusException;
	
	public Bus getBusById(Integer bus)throws BusException;
	
	public List<Bus>  getAllBusDetails()throws BusException;
	
	public  Bus deleteBusById(Integer busId)throws BusException;

}
