package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.travelzilla.controllers.BusController;
import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Travels;
import com.travelzilla.models.TravelsDTO;
import com.travelzilla.repositories.BusDAO;
import com.travelzilla.repositories.TravelsDAO;


@Service
public class TravelsServiceImpl implements TravelsService {
	
	@Autowired
	private TravelsDAO Trepo;
	@Autowired
	private BusDAO brepo;

	@Override
	public Travels registerNewTravels(Travels travel) throws TravelsException {
		// TODO Auto-generated method stub
//		Add/create traveler with new bus or with out bus.
		if(travel !=null) {
			
			java.util.Set<Bus> buslist= travel.getBusList();
			
			for(Bus buss:buslist) {
				
				//associating each student with course
				buss.setTravel(travel);
				
			}
			
			return Trepo.save(travel);
			
		}else {
			throw new TravelsException("Travels is null ");
		}
		
		
	}

	@Override
	public Travels registerNewBusInTravels(Integer tid, Bus bus) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> tra= Trepo.findById(tid);
		if(tra.isPresent()) {
			Travels travel= tra.get();
			travel.getBusList().add(bus);
			bus.setTravel(travel);
			
			return Trepo.save(travel);
			
		}else {
			throw new TravelsException("Travels is found by Travel_id - "+tid);
		}
		
	
	}

	@Override
	public Travels registerOldBusInTravels(Integer tid, Integer bid) throws TravelsException, BusException {
		
		Travels t = Trepo.findById(tid)
				.orElseThrow(() -> new TravelsException("Travels Not Found With Travel ID- "+tid));

		Bus b = brepo.findById(bid)
				.orElseThrow(() -> new BusException("Bust Not Found With Bus ID- "+bid));

		b.setTravel(t);
		t.getBusList().add(b);
	    Travels t1= Trepo.save(t);

		return t1;
	}
	


	@Override
	public Travels getTravelsById(Integer travelsID) throws TravelsException {
		
        Optional<Travels> em=Trepo.findById(travelsID);
		
		if(em.isPresent()) {
			Travels cus1= em.get();
			return cus1;
		}else {
			throw new TravelsException("Travels Not Found by Travels Id- "+travelsID);
		}
	}

	@Override
	public List<Travels> getAllTravelsDetails() throws TravelsException {
          List<Travels> list= Trepo.findAll();
		
		if(list.size()==0) {
			throw new TravelsException(" no Travels ");
		}else {
			return list;
		}
	}

//	@Override
//	public Travels deleteTravelsById(Integer travelsId) throws TravelsException {
//        Optional<Travels> em=erepo.findById(travelsId);
//		
//		if(em.isPresent()) {
//			Travels cus1= em.get();
//			Trepo.delete(cus1);
//			
//			return cus1;
//		}else {
//			throw new TravelsException("Travels deleted.");
//		}
//	}

	

	

}
