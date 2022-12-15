package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.PackageException;

public interface PackageServices {

	public Package addPackage(Package pack);

	public Package deletePackageById(Integer id) throws PackageException;

	public Package searchPackageById(Integer id) throws PackageException;

	public List<Package> viewAllPackages();

}
