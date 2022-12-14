package com.travelzilla.models;

import java.time.LocalDate;

public class Feedback {
	
	private Integer feedbackId;
	private String feedback;
	private Integer rating;
	private LocalDate submitDate;
	private Integer customerId;
	private Integer bookingId;
	
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId, String feedback, Integer rating, LocalDate submitDate, Integer customerId,
			Integer bookingId) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customerId = customerId;
		this.bookingId = bookingId;
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", rating=" + rating + ", submitDate="
				+ submitDate + ", customerId=" + customerId + ", bookingId=" + bookingId + "]";
	}
	
	

}
