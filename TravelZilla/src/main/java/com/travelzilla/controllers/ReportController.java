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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.AdminException;
import com.travelzilla.exceptions.ReportException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Report;
import com.travelzilla.models.ReportDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.ReportServices;
import com.travelzilla.services.SessionServices;


@RestController("/report")
public class ReportController {

	@Autowired
	private ReportServices rServices;
	
	@Autowired
	private SessionServices sServices;
	
	@PostMapping("/addReport")
	public ResponseEntity<Report> addAReport(@RequestBody ReportDTO report, @RequestParam("sessionKey") String sessionKey) throws AdminException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserId()==report.getAdminId() && session.getUserType()==UserType.ADMIN) {
			Report myReport = rServices.addAReport(report);
			return new ResponseEntity<Report>(myReport, HttpStatus.ACCEPTED);
		}
		throw new AdminException("Please Login with the correct credentials");
	}
	
	
	@DeleteMapping("/deleteAReport/{reportId}")
	public ResponseEntity<Report> deleteAReport(@PathVariable Integer reportId, @RequestParam("sessionKey") String sessionKey) throws ReportException, SessionException {
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			Report report = rServices.deleteAReportById(reportId);
			return new ResponseEntity<Report>(report, HttpStatus.OK);
		}
		throw new ReportException("Please Login with the correct credentials");
		
	}
}
