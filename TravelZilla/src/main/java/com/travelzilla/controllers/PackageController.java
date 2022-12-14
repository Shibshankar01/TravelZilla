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

import com.travelzilla.exceptions.PackageException;
import com.travelzilla.services.packageServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
	packageServicesImpl pService;
	
	@PostMapping("/addPackage")
	public ResponseEntity<Package> addPackage(@Valid @RequestBody Package pack){
		return new ResponseEntity<Package>(pService.addPackage(pack), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		return new ResponseEntity<Package>(pService.deletePackageById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/searchPackageById/{id}")
	public ResponseEntity<Package> searchPackageById(@PathVariable("id") Integer id) throws PackageException{
		return new ResponseEntity<Package>(pService.searchPackageById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewAllPackages")
	public ResponseEntity<List<Package>> viewAllPackages(){
		return new ResponseEntity <List<Package>>(pService.viewAllPackages(), HttpStatus.OK);
	}
	
}
