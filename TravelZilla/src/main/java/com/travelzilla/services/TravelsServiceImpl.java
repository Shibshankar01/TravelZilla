package com.travelzilla.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Travels;
import com.travelzilla.repositories.TravelsDAO;

@Service
public class TravelsServiceImpl implements TravelsService {
	
	@Autowired
	private TravelsDAO erepo;

	@Override
	public Travels registerTravels(Travels travels) throws TravelsException {
		// TODO Auto-generated method stub
        if(travels !=null) {
			
        	Travels travels1 =erepo.save(travels);
			return travels1;
		}else {
			throw new TravelsException("Travels is null ");
		}
	}

	@Override
	public Travels getTravelsById(Integer travelsID) throws TravelsException {
		
        Optional<Travels> em=erepo.findById(travelsID);
		
		if(em.isPresent()) {
			Travels cus1= em.get();
			return cus1;
		}else {
			throw new TravelsException("Travels Not Found.");
		}
	}

	@Override
	public List<Travels> getAllTravelsDetails() throws TravelsException {
          List<Travels> list= erepo.findAll();
		
		if(list.size()==0) {
			throw new TravelsException(" no Travels ");
		}else {
			return list;
		}
	}

	@Override
	public Travels deleteTravelsById(Integer travelsId) throws TravelsException {
        Optional<Travels> em=erepo.findById(travelsId);
		
		if(em.isPresent()) {
			Travels cus1= em.get();
			erepo.delete(cus1);
			
			return cus1;
		}else {
			throw new TravelsException("Travels deleted.");
		}
	}

}
