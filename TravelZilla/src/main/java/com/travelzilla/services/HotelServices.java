package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.HotelException;
import com.travelzilla.models.Hotel;
import com.travelzilla.models.HotelStatusDTO;

public interface HotelServices {

	public Hotel addHotel(Hotel hotel);

	public Hotel deleteHotelById(Integer id) throws HotelException;

	public Hotel searchHotelById(Integer id) throws HotelException;

	public List<Hotel> viewAllHotels() throws HotelException;
	
	public Hotel updateHotelStatus(HotelStatusDTO hotelStatusDTO) throws HotelException;

}
