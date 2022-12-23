package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.TravelsException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Travels;
import com.travelzilla.models.TravelsDTO;



public interface TravelsService {
	public Travels  registerNewTravels(Travels travel)throws TravelsException;
	
	public Travels  registerNewBusInTravels(Integer tid, Bus bus)throws TravelsException;
	
	public Travels  registerOldBusInTravels(Integer tid,Integer bid)throws TravelsException,BusException;

	public Travels getTravelsById(Integer travels)throws TravelsException;

	public List<Travels>  getAllTravelsDetails()throws TravelsException;

	

}
