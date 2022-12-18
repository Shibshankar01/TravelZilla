package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;

public interface FeedbackServices {
	
	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException;
	
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public Feedback findFeedbackByCustomerId(Integer customerId) throws FeedbackException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;
	

}
