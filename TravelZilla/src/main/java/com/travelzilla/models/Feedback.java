package com.travelzilla.models;


import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer feedbackId;
	@NotNull
	private String feedback;
	@NotNull
	private Integer rating;
	
	@NotNull
	private LocalDateTime submitDate = LocalDateTime.now();
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "customerId")
	@JsonIgnore
	private Customer customer;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "bookingId")
	@JsonIgnore
	private Booking booking;
	
	@ManyToOne
	@JoinColumn(name = "packageId")
	private Packages packages;
	 
	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public Feedback(@NotNull Integer feedbackId, @NotNull String feedback, @NotNull Integer rating,
			@NotNull LocalDateTime submitDate, @NotNull Customer customer, @NotNull Booking booking,
			Packages packages) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
		this.booking = booking;
		this.packages = packages;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Packages getPackages() {
		return packages;
	}

	public void setPackages(Packages packages) {
		this.packages = packages;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	

}
