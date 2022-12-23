package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.travelzilla.controllers.BusController;
import com.travelzilla.exceptions.AdminException;
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
	
	private EncryptService encrypt=new EncryptServiceImpl();

//	Register New traveler along with new bus If travels want.
	@Override
	public Travels registerNewTravels(Travels travel) throws TravelsException {

		if(Trepo.findByEmail(travel.getEmail()) != null)
			throw new TravelsException("Travels already present with that email id");
		

			
			java.util.Set<Bus> buslist= travel.getBusList();
//			associating each Bus with Travels.		
			for(Bus buss:buslist) {
				
				buss.setTravel(travel);
				
			}
			String admin1= encrypt.EncryptPassword(travel.getTravelPassword());
			travel.setTravelPassword(admin1);
			
			return Trepo.save(travel);
			

		
	}

//	Add new Bus With existing Travels.
	@Override
	public Travels registerNewBusInTravels(Integer tid, Bus bus) throws TravelsException {
		Optional<Travels> tra= Trepo.findById(tid);
//		Set bus inside Travels if travels exist.
		if(tra.isPresent()) {
			Travels travel= tra.get();
			travel.getBusList().add(bus);
			bus.setTravel(travel);
			
			return Trepo.save(travel);
			
		}else {
			throw new TravelsException("Travels is found by Travel_id - "+tid);
		}
		
	
	}

//	Register old bus with other travels.
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
	

//  Search travels with their IDs.
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

//	Get all Travels from database.
	@Override
	public List<Travels> getAllTravelsDetails() throws TravelsException {
          List<Travels> list= Trepo.findAll();
		
		if(list.size()==0) {
			throw new TravelsException(" no Travels ");
		}else {
			return list;
		}
	}

}
