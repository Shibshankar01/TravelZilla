package com.travelzilla.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;
import com.travelzilla.repositories.FeedbackDAO;

@Service
public class FeedbackServicesImpl implements FeedbackServices{
	
	@Autowired
	private FeedbackDAO fDao;
	
	@Autowired
	private BookingServices bServices;

	@Override
	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException { //use feedbackDto
		
		Feedback newFeedback= new Feedback();
		newFeedback.setFeedback(feedback.getFeedback());
		newFeedback.setRating(feedback.getRating());
		newFeedback.setBooking(bServices.ViewBookingById(feedback.getBookingId()));
		
		return fDao.save(newFeedback);
		
		
//		fDao.getavgfeedbackbypackId() //2
		//update average rating inside package 3
//		packageService.updatePackage.save(package) //4
	}

	@Override
	public Feedback findFeedbackByFeedbackId(Integer feedbackId) throws FeedbackException {

		return fDao.findById(feedbackId)
				.orElseThrow(()-> 
				new FeedbackException("No feedback found with feedback Id:- "+feedbackId));
		
	}

	@Override
	public Feedback findFeedbackByCustomerId(Integer customerId) throws FeedbackException {
		
		return fDao.findById(customerId)
				.orElseThrow(()-> 
				new FeedbackException("No feedback found with customer Id:- "+customerId));
		
	}
	
	

	@Override
	public List<Feedback> viewAllFeedback() throws FeedbackException {
		List <Feedback> feedbacks = fDao.findAll();
		
		if (feedbacks.size()==0) {
			throw new FeedbackException("No Feedbacks present");
		} else {
			return feedbacks;
		}
		
	}

}
