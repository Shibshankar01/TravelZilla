package com.travelzilla.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer paymentId;
	
	@NotNull(message = "Payment Cannot Be Done Without Booking")
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookingId")
	private Booking booking;
	

	private PaymentStatus paymentStatus;
	
	private String paymentInfo; // Wrong credentials or credential details if correct
	
	private Double paymentAmount;

	public Payment() {
		// TODO Auto-generated constructor stub
	}
	
	public Payment(Integer paymentId, @NotNull(message = "Payment Cannot Be Done Without Booking") Booking booking,
			PaymentStatus paymentStatus, String paymentInfo, Double paymentAmount) {
		super();
		this.paymentId = paymentId;
		this.booking = booking;
		this.paymentStatus = paymentStatus;
		this.paymentInfo = paymentInfo;
		this.paymentAmount = paymentAmount;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(String paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public Double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	
	
}
