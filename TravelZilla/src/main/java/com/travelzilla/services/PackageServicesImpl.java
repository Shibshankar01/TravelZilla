package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.PackageException;
import com.travelzilla.models.Packages;
import com.travelzilla.repositories.PackageDAO;

@Service
public class PackageServicesImpl implements PackageServices {

	@Autowired
	private PackageDAO pDao;

	@Override
	public Packages addPackage(Packages pack) {
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

}
