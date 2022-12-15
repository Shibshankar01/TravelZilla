package com.travelzilla.services;

import java.util.List;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

import com.travelzilla.Exception.BusException;
=======
import com.travelzilla.exceptions.BusException;
>>>>>>> 9e10bba05273986d70539cbe28f376fc69f6124d
import com.travelzilla.models.Bus;

@Service
public interface BusService {
	
	public Bus  registerBus(Bus bus)throws BusException;
	public Bus getBusById(Integer bus)throws BusException;
	public List<Bus>  getAllBusDetails()throws BusException;
	public  Bus deleteBusById(Integer busId)throws BusException;

}
