package com.travelzilla.models;

import javax.validation.constraints.NotNull;

public class FeedbackDTO {

//rating, feedback, bookingid
	
	@NotNull
	private String feedback;
	@NotNull
	private Integer rating;
	@NotNull
	private Integer bookingId;
	public FeedbackDTO(@NotNull String feedback, @NotNull Integer rating, @NotNull Integer bookingId) {
		super();
		this.feedback = feedback;
		this.rating = rating;
		this.bookingId = bookingId;
	}
	
	public FeedbackDTO() {
		// TODO Auto-generated constructor stub
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

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	@Override
	public String toString() {
		return "FeedbackDTO [feedback=" + feedback + ", rating=" + rating + ", bookingId=" + bookingId + "]";
	}
	
	
	
	
}
