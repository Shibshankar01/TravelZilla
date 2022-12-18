package com.travelzilla.services;

import java.util.ArrayList;
import java.util.List;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.HotelException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.PackageDTO;
import com.travelzilla.models.PackageUpdateDTO;
import com.travelzilla.models.Packages;

public interface PackageServices {

	public Packages addPackage(PackageDTO pDto) throws BusException, RouteException, HotelException;

	public Packages deletePackageById(Integer id) throws PackageException;

	public Packages searchPackageById(Integer id) throws PackageException;

	public List<Packages> viewAllPackages();



	public List<ArrayList<Packages>> viewPackagesBySourceAndDestination(String source, String destination);

	
//	public Packages updatePackage(PackageUpdateDTO packageUpdateDTO) ;

	Packages updatePackage(Packages p);
}
