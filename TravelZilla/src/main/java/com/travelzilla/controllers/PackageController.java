package com.travelzilla.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BusException;
import com.travelzilla.exceptions.HotelException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.exceptions.RouteException;
import com.travelzilla.models.PackageDTO;
import com.travelzilla.models.Packages;
import com.travelzilla.services.PackageServices;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	private PackageServices pService;

	@PostMapping("/addPackageByIds")
	public ResponseEntity<Packages> addPackage(@Valid @RequestBody PackageDTO pDto)
			throws HotelException, BusException, RouteException {

		return new ResponseEntity<Packages>(pService.addPackage(pDto), HttpStatus.OK);
	}
	@PostMapping("/addPackage")
	public ResponseEntity<Packages> addPackage(@Valid @RequestBody Packages packages)
			throws HotelException, BusException, RouteException {
System.out.println(packages);
		return new ResponseEntity<Packages>(pService.addPackage(packages), HttpStatus.OK);
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
