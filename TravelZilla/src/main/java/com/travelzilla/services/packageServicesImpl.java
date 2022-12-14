package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.PackageException;
import com.travelzilla.repositories.PackageDAO;

@Service
public class packageServicesImpl implements PackageServices {

	@Autowired
	private PackageDAO pDao;

	@Override
	public Package addPackage(Package pack) {
		return pDao.save(pack);
	}

	@Override
	public Package deletePackageById(Integer id) throws PackageException {
		Package p = pDao.findById(id)
				.orElseThrow(() -> new PackageException("Package Not Found With Package ID :" + id));

		if (p != null) {
			pDao.deleteById(id);
		}
		return p;
	}

	@Override
	public Package searchPackageById(Integer id) throws PackageException {
		return pDao.findById(id).orElseThrow(() -> new PackageException("Package Not Found With Package ID :" + id));
	}

	@Override
	public List<Package> viewAllPackages() {
		return pDao.findAll();
	}

}
