package com.travelzilla.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelzilla.exceptions.BookingException;
import com.travelzilla.exceptions.CustomerException;
import com.travelzilla.exceptions.FeedbackException;
import com.travelzilla.exceptions.PackageException;
import com.travelzilla.models.Feedback;
import com.travelzilla.models.FeedbackDTO;
import com.travelzilla.models.Packages;
import com.travelzilla.repositories.FeedbackDAO;

@Service
public class FeedbackServicesImpl implements FeedbackServices{
	
	@Autowired
	private FeedbackDAO fDao;
	
	@Autowired
	private BookingServices bServices;
	
	@Autowired
	private CustomerServices cServices;
	
	@Autowired
	private PackageServices pServices;

	@Override
	public Feedback addFeedback(FeedbackDTO feedback) throws FeedbackException, BookingException, PackageException { //use feedbackDto
		
		Feedback newFeedback= new Feedback();
		newFeedback.setFeedback(feedback.getFeedback());
		newFeedback.setRating(feedback.getRating());
		newFeedback.setBooking(bServices.ViewBookingById(feedback.getBookingId()));
		newFeedback.setCustomer(bServices.ViewBookingById(feedback.getBookingId()).getCustomer());
		Packages p= pServices.searchPackageById(feedback.getPackageId());
		
		newFeedback.setPackages(p);
		
		Feedback feedback2= fDao.save(newFeedback);
		
		List<Feedback> feedbacks= findFeedbackByPackageId(p.getPackageId());
		double sum=0;
		for (Feedback feedback21 : feedbacks) {
			sum+=feedback21.getRating();
		}
		double avg =sum/feedbacks.size();
		
		p.setPackageRating(avg+"");
		
		pServices.updatePackage(p);
		
		return feedback2;
		
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
	public List<Feedback> findFeedbackByCustomerId(Integer customerId)throws CustomerException {
		
		return cServices.viewCustomer(customerId).getFeedbacks();
		
		
	}
	
	@Override
	public List<Feedback> findFeedbackByPackageId(Integer packageId) throws PackageException{
		
		Packages mypackage=pServices.searchPackageById(packageId);
		
		return fDao.findByPackages(mypackage);
		
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
