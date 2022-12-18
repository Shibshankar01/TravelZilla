package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.HotelException;
import com.travelzilla.models.Hotel;
import com.travelzilla.models.HotelStatusDTO;
import com.travelzilla.repositories.HotelDAO;

@Service
public class HotelServicesImpl implements HotelServices {

	@Autowired
	private HotelDAO hotelDAO;

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelDAO.save(hotel);
	}

	@Override
	public Hotel deleteHotelById(Integer id) throws HotelException {
		Hotel h = hotelDAO.findById(id).orElseThrow(() -> new HotelException("Hotel Not Found With Hotel ID :" + id));

		if (h != null) {
			hotelDAO.deleteById(id);
		}
		return h;
	}

	@Override
	public Hotel searchHotelById(Integer id) throws HotelException {
		return hotelDAO.findById(id).orElseThrow(() -> new HotelException("Hotel Not Found With Hotel ID :" + id));
	}

	@Override
	public List<Hotel> viewAllHotels() {
		return hotelDAO.findAll();
	}

	@Override
	public Hotel updateHotelStatus(HotelStatusDTO hotelStatusDTO) throws HotelException {

		Hotel h = hotelDAO.findById(hotelStatusDTO.getHotel_Id()).orElseThrow(
				() -> new HotelException("Hotel Not Found With Hotel ID :" + hotelStatusDTO.getHotel_Id()));

		h.setHotelStatus(hotelStatusDTO.getUpdatedHotelStatus());
		hotelDAO.save(h);
		return h;

	}

}
