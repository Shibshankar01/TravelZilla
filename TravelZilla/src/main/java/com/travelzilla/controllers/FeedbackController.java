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
import org.springframework.web.bind.annotation.RestController;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;
import com.travelzilla.services.FeedbackServices;



@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackServices fServices;
	
	@PostMapping("/addfeedback")
	public ResponseEntity<Feedback> addfeedback(@Valid @RequestBody FeedbackDTO feedback) throws FeedbackException, BookingException, PackageException{
		
		return new ResponseEntity<Feedback>(fServices.addFeedback(feedback),HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbackbyfeedbackid/{id}")
	public ResponseEntity<Feedback> findFeedbackByFeedbackId(@PathVariable("id") Integer id) throws FeedbackException{
		
		return new ResponseEntity<>(fServices.findFeedbackByFeedbackId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbackbycustomerid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByCustomerId(@PathVariable("id") Integer id) throws FeedbackException, CustomerException{
		
		return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByCustomerId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbackbypackageid/{id}")
	public ResponseEntity<List<Feedback>> findFeedbackByPackageId(@PathVariable("id") Integer id) throws FeedbackException, PackageException{
		
		return new ResponseEntity<List<Feedback>>(fServices.findFeedbackByPackageId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/viewallfeedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException{
		
		return new ResponseEntity<List<Feedback>>(fServices.viewAllFeedback(),HttpStatus.OK);
		
	}
	
	

}
