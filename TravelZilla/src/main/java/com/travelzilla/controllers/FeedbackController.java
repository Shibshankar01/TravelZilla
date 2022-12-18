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

import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.models.Feedback;
import com.travelzilla.services.FeedbackServices;



@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {
	
	@Autowired
	private FeedbackServices fServices;
	
	@PostMapping("/addfeedback")
	public ResponseEntity<Feedback> addfeedback(@Valid @RequestBody Feedback feedback) throws FeedbackException{
		
		return new ResponseEntity<Feedback>(fServices.addFeedback(feedback),HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbackbyfeedbackid/{id}")
	public ResponseEntity<Feedback> findFeedbackByFeedbackId(@PathVariable("id") Integer id) throws FeedbackException{
		
		return new ResponseEntity<>(fServices.findFeedbackByFeedbackId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/feedbackbycustomerid/{id}")
	public ResponseEntity<Feedback> findFeedbackByCustomerId(@PathVariable("id") Integer id) throws FeedbackException{
		
		return new ResponseEntity<>(fServices.findFeedbackByCustomerId(id), HttpStatus.OK);
		
	}
	
	@GetMapping("/viewallfeedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException{
		
		return new ResponseEntity<List<Feedback>>(fServices.viewAllFeedback(),HttpStatus.OK);
		
	}
	
	

}
