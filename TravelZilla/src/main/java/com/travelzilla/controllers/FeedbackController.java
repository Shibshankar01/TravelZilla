package com.travelzilla.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.exceptions.SessionException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;
import com.travelzilla.models.Session;
import com.travelzilla.models.UserType;
import com.travelzilla.services.FeedbackServices;
import com.travelzilla.services.SessionServices;



@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackServices fServices;
	@Autowired
	private SessionServices sServices;
	
	@PostMapping("/addfeedback")
	public ResponseEntity<Feedback> addfeedback(@Valid @RequestBody FeedbackDTO feedback, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, BookingException, PackageException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.CUSTOMER) {
			return new ResponseEntity<Feedback>(fServices.addFeedback(feedback),HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
		
	}
	
	@GetMapping("/feedbackbyfeedbackid/{id}")
	public ResponseEntity<Feedback> findFeedbackByFeedbackId(@PathVariable("id") Integer id, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<>(fServices.findFeedbackByFeedbackId(id), HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
	}
	
	@GetMapping("/feedbackbycustomerid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByCustomerId(@PathVariable("id") Integer id, @RequestParam("sessionKey")String sessionKey) throws FeedbackException, CustomerException, SessionException{
		Session session = sServices.getASessionByKey(sessionKey);
		if(session.getUserType()==UserType.ADMIN) {
			return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByCustomerId(id), HttpStatus.OK);
		}
		throw new FeedbackException("Please login with the correct credentials");
		
	}
	
	@GetMapping("/feedbackbypackageid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByPackageId(@PathVariable("id") Integer id) throws FeedbackException, PackageException, SessionException{

		return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByPackageId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/viewallfeedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException{
		
		return new ResponseEntity<List<Feedback>>(fServices.viewAllFeedback(),HttpStatus.OK);
		
	}
	
	

}
