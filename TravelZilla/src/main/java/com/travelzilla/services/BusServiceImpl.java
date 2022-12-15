package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.models.Bus;
import com.travelzilla.repositories.BusDTO;

@Service
public class BusServiceImpl implements BusService {
	
	
	@Autowired
	private BusDTO erepo;

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

	@Override
	public Bus deleteBusById(Integer busId) throws BusException {
        Optional<Bus> em=erepo.findById(busId);
		
		if(em.isPresent()) {
			Bus cus1= em.get();
			erepo.delete(cus1);
			
			return cus1;
		}else {
			throw new BusException("Bus deleted.");
		}
	}
}
