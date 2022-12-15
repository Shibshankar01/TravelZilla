package com.travelzilla.service;

import java.util.List;

import com.travelzilla.Exception.BusException;
import com.travelzilla.models.Bus;


public interface BusService {
	
	public Bus  registerBus(Bus bus)throws BusException;
	public Bus getBusById(Integer bus)throws BusException;
	public List<Bus>  getAllBusDetails()throws BusException;
	public  Bus deleteBusById(Integer busId)throws BusException;

}
