package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.HotelException;
import com.travelzilla.models.Hotel;
import com.travelzilla.repositories.HotelDAO;


@Service
public class HotelServicesImpl implements HotelServices {

	@Autowired
	private HotelDAO hDao;

	@Override
	public Hotel addHotel(Hotel pack) {
		return hDao.save(pack);
	}

	@Override
	public Hotel deleteHotelById(Integer id) throws HotelException {
		Hotel h = hDao.findById(id)
				.orElseThrow(() -> new HotelException("Hotel Not Found With Hotel ID :" + id));

		if (h != null) {
			hDao.deleteById(id);
		}
		return h;
	}

	@Override
	public Hotel searchHotelById(Integer id) throws HotelException {
		return hDao.findById(id).orElseThrow(() -> new HotelException("Hotel Not Found With Hotel ID :" + id));
	}

	@Override
	public List<Hotel> viewAllHotels() {
		return hDao.findAll();
	}

}
