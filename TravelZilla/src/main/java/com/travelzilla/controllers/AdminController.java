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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Admin;
import com.travelzilla.models.Report;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.AdminServices;
import com.travelzilla.services.SessionServices;


@RestController("/admin")
public class AdminController {

	@Autowired
	private AdminServices aServices;
	
	@Autowired
	private SessionServices sServices;
	
	@PostMapping("/add")
	public ResponseEntity<Admin> addAAdmin(@Valid @RequestBody Admin admin) throws AdminException{
		Admin admin1= aServices.addAdmin(admin);
		return new ResponseEntity<Admin>(admin1, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{adminId}")
	public ResponseEntity<List<Report>> getAllReportsOfAAdmin(@PathVariable("adminId") Integer adminId, @RequestParam("sessionKey")String sessionKey) throws AdminException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==adminId && session.getUserType()==UserType.ADMIN) {
			List<Report> reports =  aServices.getAdminById(adminId).getReports();
			return new ResponseEntity<List<Report>>(reports, HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
		
	}
	
	@DeleteMapping("/{adminId}")
	public ResponseEntity<Admin> deleteAAdmin(@PathVariable Integer adminId, @RequestParam("sessionKey")String sessionKey) throws AdminException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==adminId && session.getUserType()==UserType.ADMIN) {
			Admin admin = aServices.deleteAdminById(adminId);
			return new ResponseEntity<Admin>(admin, HttpStatus.OK);
		}
		throw new AdminException("Please login with the correct credentials");
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@Valid @RequestBody Admin admin, @RequestParam("sessionKey") String sessionKey) throws SessionException, AdminException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId() == admin.getAdminID() && session.getUserType() == UserType.ADMIN) {
			Admin myAdmin = aServices.updateAdmin(admin);
			return new ResponseEntity<Admin>(myAdmin, HttpStatus.ACCEPTED); 
		}
		throw new AdminException("Please login with the correct correct credentials");
	}
}
