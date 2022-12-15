package com.travelzilla.services;



import java.util.List;

import com.travelzilla.exceptions.PackageException;
import com.travelzilla.models.Packages;

public interface PackageServices {

	public Packages addPackage(Packages pack);

	public Packages deletePackageById(Integer id) throws PackageException;

	public Packages searchPackageById(Integer id) throws PackageException;

<<<<<<< HEAD
	public List<Package> viewAllPackages();
=======
	public List<Packages> viewAllPackages();
>>>>>>> 9e10bba05273986d70539cbe28f376fc69f6124d

}
