package com.travelzilla.services;

import java.util.List;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;

public interface FeedbackServices {
	
	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException, PackageException;
	
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException;
	
	public List<Feedback> findFeedbackByCustomerId(Integer customerId) throws CustomerException;
	
	public List<Feedback> viewAllFeedback() throws FeedbackException;

	List<Feedback> findFeedbackByPackageId(Integer packageId) throws PackageException;
	

}
