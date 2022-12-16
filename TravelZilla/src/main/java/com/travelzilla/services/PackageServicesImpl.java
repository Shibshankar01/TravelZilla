package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.DAO;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.HotelException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.Bus;
import com.travelzilla.models.Hotel;
import com.travelzilla.models.PackageDTO;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;
import com.travelzilla.repositories.BusDTO;
import com.travelzilla.repositories.HotelDAO;
import com.travelzilla.repositories.PackageDAO;
import com.travelzilla.repositories.RouteDTO;

@Service
public class PackageServicesImpl implements PackageServices {

	@Autowired
	private PackageDAO pDao;
	@Autowired
	private HotelDAO hDAO;

	@Autowired
	private BusDTO bDAO;

	@Autowired
	private RouteDTO rDAO;

	@Override
	public Packages addPackage(PackageDTO pDto) throws BusException, RouteException, HotelException {

		Packages pack = new Packages();

		pack.setPackageName(pDto.getPackageName());
		pack.setPackageDescription(pDto.getPackageDescription());
		pack.setPackageCost(pDto.getPackageCost());

		Hotel h = hDAO.findById(pDto.getHotel_Id())
				.orElseThrow(() -> new HotelException("Hotel Not Found With HotelID : " + pDto.getHotel_Id()));
		pack.setHotel(h);
		h.getpSet().add(pack);
		hDAO.save(h);
		
		Bus b = bDAO.findById(pDto.getBusId())
				.orElseThrow(() -> new BusException("Bust Not Found With Bus ID : " + pDto.getBusId()));
		pack.setBus(b);

		Route r = rDAO.findById(pDto.getRouteId())
				.orElseThrow(() -> new RouteException("Route Not Found With Route ID : " + pDto.getRouteId()));
		pack.setRoute(r);
		r.getPackageList().add(pack);
		rDAO.save(r);
		

		return pDao.save(pack);
	}

	@Override
	public Packages deletePackageById(Integer id) throws PackageException {
		Packages p = pDao.findById(id)
				.orElseThrow(() -> new PackageException("Packages Not Found With Packages ID :" + id));

		if (p != null) {
			pDao.deleteById(id);
		}
		return p;
	}

	@Override
	public Packages searchPackageById(Integer id) throws PackageException {
		return pDao.findById(id).orElseThrow(() -> new PackageException("Packages Not Found With Packages ID :" + id));
	}

	@Override
	public List<Packages> viewAllPackages() {
		return pDao.findAll();
	}

	@Override
	public Packages addPackage(Packages packages) {
		packages.getHotel().getpSet().add(packages);
		packages.getRoute().getPackageList().add(packages);
//		packages.getBus().
		return pDao.save(packages);
		
	}

}
