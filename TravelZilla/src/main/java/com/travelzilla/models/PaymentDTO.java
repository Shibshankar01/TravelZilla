package com.travelzilla.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PaymentDTO {

	@NotNull(message = "Payment Cannot be Done Without Booking ID")
	private Integer bookingId;
	@NotNull(message = "Payment Cannot be Done Without UPI ID")
	private String upi_Id;

	@NotNull(message = "Pin Is Required To Make Payment")
	@Min(value = 6, message = "Pin Must Be 6 Digit Long")
	@Max(value = 6, message = "Pin Must Be 6 Digit Long")
	private Integer pin;

	public PaymentDTO() {

	}

	public PaymentDTO(Integer bookingId, String upi_Id, Integer pin) {
		super();
		this.bookingId = bookingId;
		this.upi_Id = upi_Id;
		this.pin = pin;
	}

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getUpi_Id() {
		return upi_Id;
	}

	public void setUpi_Id(String upi_Id) {
		this.upi_Id = upi_Id;
	}

	public Integer getPin() {
		return pin;
	}

}
