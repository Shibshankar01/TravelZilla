package com.travelzilla.models;


import java.time.LocalDateTime;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank
	private Integer feedbackId;
	@NotBlank
	private String feedback;
	@NotBlank
	private Integer rating;
	
	@NotBlank
	private LocalDateTime submitDate = LocalDateTime.now();
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "bookingId")
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "packageId")
	private Packages packages;
	 
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Feedback(Integer feedbackId, String feedback, Integer rating, LocalDateTime submitDate, Customer customerId,
			Booking bookingId) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customerId;
		this.booking = bookingId;
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

	public LocalDateTime getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDateTime submitDate) {
		this.submitDate = submitDate;
	}

	public Customer getCustomerId() {
		return customer;
	}

	public void setCustomerId(Customer customerId) {
		this.customer = customerId;
	}

	public Booking getBookingId() {
		return booking;
	}

	public void setBookingId(Booking bookingId) {
		this.booking = bookingId;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", feedback=" + feedback + ", rating=" + rating + ", submitDate="
				+ submitDate + ", customerId=" + customer + ", bookingId=" + booking + "]";
	}
	
	

}
