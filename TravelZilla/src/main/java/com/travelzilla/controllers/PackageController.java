package com.travelzilla.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.HotelException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.PackageDTO;
import com.travelzilla.models.Packages;
import com.travelzilla.models.Report;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.PackageServices;
import com.travelzilla.services.SessionServices;

@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageServices pService;
	@Autowired
	private SessionServices sessionServices;

	@PostMapping("/addPackageByIds")
	public ResponseEntity<Packages> addPackage(@Valid @RequestBody PackageDTO pDto  , @RequestParam("sessionKey")String sessionKey) throws SessionException, HotelException, BusException, RouteException, AdminException {
		Session session = sessionServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<Packages>(pService.addPackage(pDto), HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
		
		
	}

	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer id) throws PackageException {
		return new ResponseEntity<Packages>(pService.deletePackageById(id), HttpStatus.OK);
	}

	@GetMapping("/searchPackageById/{id}")
	public ResponseEntity<Packages> searchPackageById(@PathVariable("id") Integer id) throws PackageException {
		return new ResponseEntity<Packages>(pService.searchPackageById(id), HttpStatus.OK);
	}

	@GetMapping("/viewAllPackages")
	public ResponseEntity<List<Packages>> viewAllPackages() {
		return new ResponseEntity<List<Packages>>(pService.viewAllPackages(), HttpStatus.OK);
	}

}
