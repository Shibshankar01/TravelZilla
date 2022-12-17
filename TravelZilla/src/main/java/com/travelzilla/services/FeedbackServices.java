package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.models.Feedback;

public interface FeedbackServices {
	
	public Feedback addFeedback(Feedback feedback) throws FeedbackException;
	
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public Feedback findFeedbackByCustomerId(Integer customerId) throws FeedbackException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;
	

}
