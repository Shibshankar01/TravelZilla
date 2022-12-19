package com.travelzilla.services;

import java.util.ArrayList;
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
import com.travelzilla.models.PackageUpdateDTO;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Route;
import com.travelzilla.repositories.BusDAO;
import com.travelzilla.repositories.HotelDAO;
import com.travelzilla.repositories.PackageDAO;
import com.travelzilla.repositories.RouteDAO;

@Service
public class PackageServicesImpl implements PackageServices {

	@Autowired
	private PackageDAO packageDAO;
	@Autowired
	private HotelDAO hotelDAO;

	@Autowired
	private BusDAO busDAO;

	@Autowired
	private RouteDAO routeDAO;

	@Override
	public Packages addPackage(PackageDTO pDto) throws BusException, RouteException, HotelException {

//		System.out.println("kk");

		Packages pack = new Packages();
//		System.out.println("kk");
//		(Integer packageId, String packageName, String packageDescription, Route route, Hotel hotel, Bus bus,
//				Double packageCost)
		pack.setCurrentAvailability(pDto.getPackageCapacity());
		pack.setPackageName(pDto.getPackageName());
		
		pack.setPackageCost(pDto.getPackageCost());

		Hotel h = hotelDAO.findById(pDto.getHotel_Id())
				.orElseThrow(() -> new HotelException("Hotel Not Found With HotelID : " + pDto.getHotel_Id()));
//		System.out.println(h.toString());	

		Bus b = busDAO.findById(pDto.getBusId())
				.orElseThrow(() -> new BusException("Bust Not Found With Bus ID : " + pDto.getBusId()));
//		System.out.println(b.toString());

		Route r = routeDAO.findById(pDto.getRouteId())
				.orElseThrow(() -> new RouteException("Route Not Found With Route ID : " + pDto.getRouteId()));

		System.out.println(r.toString());
		pack.setPackageDescription(r.getRouteFrom()+" " +r.getRouteTo()+ " - " + pDto.getPackageDescription());

		pack.setRoute(r);
		pack.setHotel(h);
		pack.setBus(b);

		Packages newPackage = packageDAO.save(pack);

//		h.getpSet().add(newPackage);


//		r.getPackageList().add(newPackage);
		hotelDAO.save(h);
		routeDAO.save(r);
//		System.out.println(h.toString() + b.toString() + r.toString());
		return newPackage;
	}

	@Override
	public Packages deletePackageById(Integer id) throws PackageException {
		Packages p = packageDAO.findById(id)
				.orElseThrow(() -> new PackageException("Packages Not Found With Packages ID :" + id));

		if (p != null) {
			packageDAO.deleteById(id);
		}
		return p;
	}

	@Override
	public Packages searchPackageById(Integer id) throws PackageException {
		return packageDAO.findById(id)
				.orElseThrow(() -> new PackageException("Packages Not Found With Packages ID :" + id));
	}

	@Override
	public List<Packages> viewAllPackages() {
		return packageDAO.findAll();
	}


	@Override
	public List<ArrayList<Packages>> viewPackagesBySourceAndDestination(String source, String destination) {
		source = source.toLowerCase();
		destination = destination.toLowerCase();

		List<ArrayList<Packages>> sameRoutePackageList = new ArrayList<ArrayList<Packages>>();
		List<Route> routeList = routeDAO.findByRouteFromAndRouteTo(source, destination);
		for (Route r : routeList) {
			sameRoutePackageList.add((ArrayList<Packages>) packageDAO.findByRoute(r));
		}
		return sameRoutePackageList;
	}


//	@Override
//	public Packages updatePackage(PackageUpdateDTO packageUpdateDTO) {
//	
//		return null;
//	}



	@Override
	public Packages updatePackage(Packages p) {

		packageDAO.save(p);
		return null;
	}


}
