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
<<<<<<< HEAD
=======
import com.travelzilla.models.Packages;
>>>>>>> 9e10bba05273986d70539cbe28f376fc69f6124d
import com.travelzilla.services.PackageServices;
import com.travelzilla.services.PackageServicesImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/package")
public class PackageController {

	@Autowired
<<<<<<< HEAD
	public PackageServices pService;
=======
	private PackageServices pService;
>>>>>>> 9e10bba05273986d70539cbe28f376fc69f6124d
	
	@PostMapping("/addPackage")
	public ResponseEntity<Packages> addPackage(@Valid @RequestBody Packages pack){
		return new ResponseEntity<Packages>(pService.addPackage(pack), HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deletePackage/{id}")
	public ResponseEntity<Packages> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		return new ResponseEntity<Packages>(pService.deletePackageById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/searchPackageById/{id}")
	public ResponseEntity<Packages> searchPackageById(@PathVariable("id") Integer id) throws PackageException{
		return new ResponseEntity<Packages>(pService.searchPackageById(id), HttpStatus.OK);
	}
	
	
	@GetMapping("/viewAllPackages")
	public ResponseEntity<List<Packages>> viewAllPackages(){
		return new ResponseEntity <List<Packages>>(pService.viewAllPackages(), HttpStatus.OK);
	}
	
}
