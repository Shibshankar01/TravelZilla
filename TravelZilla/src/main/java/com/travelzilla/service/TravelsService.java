package com.travelzilla.service;

import java.util.List;

import com.travelzilla.Exception.TravelsException;
import com.travelzilla.models.Travels;



public interface TravelsService {
	
	public Travels  registerTravels(Travels travels)throws TravelsException;
	public Travels getTravelsById(Integer travels)throws TravelsException;
	public List<Travels>  getAllTravelsDetails()throws TravelsException;
	public  Travels deleteTravelsById(Integer travelsId)throws TravelsException;

}
